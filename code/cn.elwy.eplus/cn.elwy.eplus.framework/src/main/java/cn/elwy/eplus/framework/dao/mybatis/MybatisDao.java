package cn.elwy.eplus.framework.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.elwy.common.entity.Condition;
import cn.elwy.common.entity.Identity;
import cn.elwy.common.entity.Pageable;
import cn.elwy.common.exception.DaoException;
import cn.elwy.common.util.Assert;
import cn.elwy.common.util.ClassUtil;
import cn.elwy.eplus.framework.Constant;
import cn.elwy.eplus.framework.annotation.DS.DsId;
import cn.elwy.eplus.framework.dao.Dao;
import cn.elwy.eplus.framework.dao.SqlIdConst;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MybatisDao<E> implements Dao<E>, Constant, SqlIdConst {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public static final String SQLNAME_SEPARATOR = ".";

	/** 数据源ID */
	private String dsId = DsId.dataSource.name();

	/**
	 * @fields sqlNamespace SqlMapping命名空间
	 */
	protected String sqlNamespace = getDefaultSqlNamespace();

	@Autowired
	private SqlSession sqlSession;

	private SqlSessionFactory sessionFactory;

	public MybatisDao() {
	}

	/**
	 * 获取泛型类型的实体对象类全名
	 * @return
	 */
	protected String getDefaultSqlNamespace() {
		String tableName = getEntityName();
		if (tableName != null && !tableName.isEmpty()) {
			return tableName + "Mapper";
		}
		return "";
	}

	public String getEntityName() {
		Class<?> genericClass = ClassUtil.getGenericClass(this.getClass());
		if (genericClass != null) {
			return genericClass.getName();
		}
		return "";
	}

	/**
	 * 获取SqlMapping命名空间
	 * @return SqlMapping命名空间
	 */
	public String getSqlNamespace() {
		return sqlNamespace;
	}

	/**
	 * 设置SqlMapping命名空间。 以改变默认的SqlMapping命名空间， 不能滥用此方法随意改变SqlMapping命名空间。
	 * @param sqlNamespace SqlMapping命名空间
	 */
	public void setSqlNamespace(String sqlNamespace) {
		this.sqlNamespace = sqlNamespace;
	}

	/**
	 * 将SqlMapping命名空间与给定的SqlMapping名组合在一起。
	 * @param sqlName SqlMapping名
	 * @return 组合了SqlMapping命名空间后的完整SqlMapping名
	 */
	protected String getSqlName(String sqlName) {
		return sqlNamespace + SQLNAME_SEPARATOR + sqlName;
	}

	@Override
	public int countByCondition(Condition condition) {
		Assert.notNull(condition);
		String sqlName = getSqlName(countByCondition);
		try {
			return getSqlSession().selectOne(sqlName, condition);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件统计记录数出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int deleteByCondition(Condition condition) {
		Assert.notNull(condition);
		String sqlName = getSqlName(deleteByCondition);
		try {
			return getSqlSession().delete(sqlName, condition);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件删除对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int deleteByPrimaryKey(E record) {
		Assert.notNull(record);
		String sqlName = getSqlName(deleteByPrimaryKey);
		try {
			return getSqlSession().delete(sqlName, ((Identity) record).getId());
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int deleteByPrimaryKeys(List<E> recordList) {
		Assert.notNull(recordList);
		String sqlName = getSqlName(deleteByPrimaryKeys);
		try {
			return getSqlSession().delete(sqlName, recordList);
		} catch (Exception e) {
			throw new DaoException(String.format("根据IDS删除对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public E insert(E record) throws DaoException {
		Assert.notNull(record);
		String sqlName = getSqlName(insert);
		try {
			// if (StringUtils.isBlank(record.getId()))
			// record.setId(generateId());
			getSqlSession().insert(sqlName, record);
			return record;
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public E insertSelective(E record) {
		Assert.notNull(record);
		String sqlName = getSqlName(insertSelective);
		try {
			getSqlSession().insert(sqlName, record);
			return record;
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public List<E> insertBatch(List<E> recordList) {
		Assert.notNull(recordList);
		List<E> idList = new ArrayList<E>();
		for (E record : recordList) {
			idList.add(this.insert(record));
		}
		return idList;
	}

	@Override
	public List<E> insertBatchSelective(List<E> recordList) {
		Assert.notNull(recordList);
		List<E> idList = new ArrayList<E>();

		for (E record : recordList) {
			idList.add(this.insertSelective(record));
		}
		return idList;
	}

	@Override
	public List<E> selectByCondition(Condition condition) {
		String sqlName = getSqlName(selectByCondition);
		try {
			return getSqlSession().selectList(sqlName, condition);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件查询对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public Pageable<E> selectByCondition(Condition condition, Pageable<E> page) {
		Assert.notNull(condition);
		Assert.notNull(page);
		String sqlName = getSqlName(selectByCondition);
		try {
			MyBatisPage<E> mbPage = new MyBatisPage<E>(page.getOffset(), page.getLimit());
			List<E> datas = getSqlSession().selectList(sqlName, condition, mbPage);
			page.setDatas(datas);
			page.setTotalRecord(mbPage.getTotalRecord());
			return page;
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件分页查询对象出错！语句：%s", sqlName), e);
		}
	}

//	@Override
//	public E selectByPrimaryKey(String id) {
//		Assert.notNull(id);
//		String sqlName = getSqlName(selectByPrimaryKey);
//		try {
//			return getSqlSession().selectOne(sqlName, id);
//		} catch (Exception e) {
//			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", sqlName), e);
//		}
//	}
//
//	@Override
//	public List<E> selectByPrimaryKeys(String... ids) {
//		Assert.notNull(ids);
//		String sqlName = getSqlName(selectByPrimaryKey);
//		try {
//			return getSqlSession().selectList(sqlName, ids);
//		} catch (Exception e) {
//			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", sqlName), e);
//		}
//	}

	@Override
	public int updateByCondition(Condition condition) {
		String sqlName = getSqlName(updateByCondition);
		return update(sqlName, condition);
	}

	@Override
	public int updateByConditionSelective(Condition condition) {
		String sqlName = getSqlName(updateByConditionSelective);
		return update(sqlName, condition);
	}

	protected int update(String sqlName, Condition condition) {
		Assert.notNull(condition.getData());
		try {
			return getSqlSession().update(sqlName, condition);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件更新对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int updateByPrimaryKey(E record) {
		Assert.notNull(record);
		String sqlName = getSqlName(updateByPrimaryKey);
		try {
			return getSqlSession().update(sqlName, record);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int updateByPrimaryKeySelective(E record) {
		Assert.notNull(record);
		String sqlName = getSqlName(updateByPrimaryKeySelective);
		try {
			return getSqlSession().update(sqlName, record);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象某些属性出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int updateByPrimaryKeys(List<E> recordList) {
		Assert.notNull(recordList);
		int result = 0;
		for (E record : recordList) {
			result += this.updateByPrimaryKey(record);
		}
		return result;
	}

	@Override
	public int updateByPrimaryKeySelectives(List<E> recordList) {
		Assert.notNull(recordList);
		int result = 0;
		for (E record : recordList) {
			result += this.updateByPrimaryKeySelective(record);
		}
		return result;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public SqlSessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// sessionFactory =
			// DynamicSqlSessionDaoSupport.getDefaultTargetSqlSessionFactory();
		}
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
	}

}
