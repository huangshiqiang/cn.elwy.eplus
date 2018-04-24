package cn.elwy.eplus.framework.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class CommonDao<E> extends BaseDao<E> implements Dao<E> {

	protected DaoSupport daosupport;

	public List<String> getFilterColumn(Serializable userId, String tableName) {
		return daosupport.getFilterColumn(userId, tableName);
	}

	public List<String> getFilterColumn(String type, Serializable id, String tableName) {
		return daosupport.getFilterColumn(type, id, tableName);
	}

}
