package cn.elwy.eplus.framework.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.common.entity.Page;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.exception.DaoException;
import cn.elwy.common.util.Assert;
import cn.elwy.common.util.ClassUtil;
import cn.elwy.eplus.framework.Constant;
import cn.elwy.eplus.framework.dao.Dao;
import cn.elwy.eplus.framework.dao.SqlIdConst;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MybatisDao<E> implements Dao<E>, Constant, SqlIdConst {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public static final String SQLNAME_SEPARATOR = ".";

	@Autowired(required = true)
	private SqlSession sqlSession;

	/** 数据源ID */
	private String dsId = "default";

	/**
	 * @fields sqlNamespace SqlMapping命名空间
	 */
	protected String sqlNamespace = getDefaultSqlNamespace();

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
	public int countByCondition(Parameter parameter) {
		Assert.notNull(parameter);
		String sqlName = getSqlName(countByCondition);
		try {
			return getSqlSession().selectOne(sqlName, parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件统计记录数出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int deleteByCondition(Parameter parameter) {
		Assert.notNull(parameter);
		String sqlName = getSqlName(deleteByCondition);
		try {
			return getSqlSession().delete(sqlName, parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件删除对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		Assert.notNull(id);
		String sqlName = getSqlName(deleteByPrimaryKey);
		try {
			return getSqlSession().delete(sqlName, id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int deleteByPrimaryKeys(String... ids) {
		Assert.notNull(ids);
		String sqlName = getSqlName(deleteByPrimaryKeys);
		try {
			return getSqlSession().delete(sqlName, ids);
		} catch (Exception e) {
			throw new DaoException(String.format("根据IDS删除对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public E insert(E entity) {
		Assert.notNull(entity);
		String sqlName = getSqlName(insert);
		try {
			// if (StringUtils.isBlank(entity.getId()))
			// entity.setId(generateId());
			getSqlSession().insert(sqlName, entity);
			return entity;
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public E insertSelective(E entity) {
		Assert.notNull(entity);
		String sqlName = getSqlName(insertSelective);
		try {
			getSqlSession().insert(sqlName, entity);
			return entity;
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	@Transactional
	public List<E> insertBatch(List<E> entityList) {
		Assert.notNull(entityList);
		List<E> idList = new ArrayList<E>();
		for (E entity : entityList) {
			idList.add(this.insert(entity));
		}
		return idList;
	}

	@Override
	public List<E> insertBatchSelective(List<E> entityList) {
		Assert.notNull(entityList);
		List<E> idList = new ArrayList<E>();

		for (E entity : entityList) {
			idList.add(this.insertSelective(entity));
		}
		return idList;
	}

	@Override
	public List<E> selectAll() {
		String sqlName = getSqlName(selectByCondition);
		try {
			return getSqlSession().selectList(sqlName);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件查询对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public Page<E> selectAllByPage(Page<E> page) {
		Assert.notNull(page);
		String sqlName = getSqlName(selectByCondition);
		try {
			MyBatisPage<E> myBatisPage = new MyBatisPage<E>(page.getOffset(), page.getLimit());
			List<E> data = getSqlSession().selectList(sqlName, myBatisPage);
			page.setData(data);
			return page;
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件分页查询对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public List<E> selectByCondition(Parameter parameter) {
		String sqlName = getSqlName(selectByCondition);
		try {
			return getSqlSession().selectList(sqlName, parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件查询对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public Page<E> selectByConditionPage(Parameter parameter, Page<E> page) {
		Assert.notNull(parameter);
		Assert.notNull(page);
		String sqlName = getSqlName(selectByCondition);
		// String sqlName = getSqlName(selectByConditionPage);
		try {
			MyBatisPage<E> myBatisPage = new MyBatisPage<E>(page.getOffset(), page.getLimit());
			List<E> data = getSqlSession().selectList(sqlName, parameter, myBatisPage);
			page.setData(data);
			return page;
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件分页查询对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public E selectByPrimaryKey(String id) {
		Assert.notNull(id);
		String sqlName = getSqlName(selectByPrimaryKey);
		try {
			return getSqlSession().selectOne(sqlName, id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public List<E> selectByPrimaryKeys(String... ids) {
		Assert.notNull(ids);
		String sqlName = getSqlName(selectByPrimaryKey);
		try {
			return getSqlSession().selectList(sqlName, ids);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int updateByCondition(Parameter parameter) {
		String sqlName = getSqlName(updateByCondition);
		return update(sqlName, parameter);
	}

	@Override
	public int updateByConditionSelectives(Parameter parameter) {
		String sqlName = getSqlName(updateByConditionSelectives);
		return update(sqlName, parameter);
	}

	protected int update(String sqlName, Parameter parameter) {
		Assert.notNull(parameter);
		Object record = parameter.getData();
		Assert.notNull(record);
		try {
			return getSqlSession().update(sqlName, parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("根据条件更新对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int updateByPrimaryKey(E entity) {
		Assert.notNull(entity);
		String sqlName = getSqlName(updateByPrimaryKey);
		try {
			return getSqlSession().update(sqlName, entity);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象出错！语句：%s", sqlName), e);
		}
	}

	@Override
	public int updateByPrimaryKeySelective(E entity) {
		Assert.notNull(entity);
		String sqlName = getSqlName(updateByPrimaryKeySelective);
		try {
			return getSqlSession().update(sqlName, entity);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象某些属性出错！语句：%s", sqlName), e);
		}
	}

	@Override
	@Transactional
	public int updateByPrimaryKeys(List<E> entityList) {
		Assert.notNull(entityList);
		int result = 0;
		for (E entity : entityList) {
			result += this.updateByPrimaryKey(entity);
		}
		return result;
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelectives(List<E> entityList) {
		Assert.notNull(entityList);
		int result = 0;
		for (E entity : entityList) {
			result += this.updateByPrimaryKeySelective(entity);
		}
		return result;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
	}

}
