package cn.elwy.eplus.framework.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import cn.elwy.eplus.framework.dao.mybatis.MybatisDao;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class BaseDao<E> extends MybatisDao<E> implements Dao<E> {

	public List<String> getFilterColumn(Serializable userId, String tableName) {
		return Collections.emptyList();
	}

	public List<String> getFilterColumn(String type, Serializable id, String tableName) {
		return Collections.emptyList();
	}

}
