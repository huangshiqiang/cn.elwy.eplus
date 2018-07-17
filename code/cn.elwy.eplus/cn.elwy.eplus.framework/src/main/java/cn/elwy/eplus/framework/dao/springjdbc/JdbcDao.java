package cn.elwy.eplus.framework.dao.springjdbc;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.elwy.common.entity.Condition;
import cn.elwy.common.entity.Pageable;
import cn.elwy.eplus.framework.dao.Dao;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public abstract class JdbcDao<E> extends JdbcDaoSupport implements Dao<E> {

	protected Class<E> entityClass;

	@Resource(name = "dataSource")
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public int countByCondition(Condition condition) {
		return 0;
	}

	@Override
	public int deleteByCondition(Condition condition) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKeys(String... ids) {
		return 0;
	}

	@Override
	public E insert(E entity) {
		return null;
	}

	@Override
	public E insertSelective(E entity) {
		return null;
	}

	public List<E> insertBatch(List<E> entityList) {
		return null;
	}

	public List<E> insertBatchSelective(List<E> entityList) {
		return null;
	}

	@Override
	public List<E> selectByCondition(Condition condition) {
		return null;
	}

	@Override
	public Pageable<E> selectByConditionPage(Condition condition, Pageable<E> page) {
		return null;
	}

	@Override
	public E selectByPrimaryKey(String id) {
		return null;
	}

	@Override
	public List<E> selectByPrimaryKeys(String... ids) {
		return null;
	}

	@Override
	public int updateByCondition(Condition condition) {
		return 0;
	}

	@Override
	public int updateByConditionSelectives(Condition condition) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(E entity) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(E entity) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeys(List<E> entityList) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelectives(List<E> entityList) {
		return 0;
	}

}
