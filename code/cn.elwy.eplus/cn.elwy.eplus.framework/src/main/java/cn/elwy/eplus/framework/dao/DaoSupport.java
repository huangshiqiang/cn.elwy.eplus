package cn.elwy.eplus.framework.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class DaoSupport {

	private Map<String, List<String>> catche = new HashMap<String, List<String>>();
	private BaseDao<String> baseDao;

	public List<String> getFilterColumn(Serializable userId, String tableName) {
		return getFilterColumn("user", userId, tableName);
	}

	public List<String> getFilterColumn(String type, Serializable id, String tableName) {
		String key = type + id;
		List<String> list = catche.get(key);
		if (list == null) {
			list = (List<String>) baseDao.selectByCondition(null);
			catche.put(key, list);
		}
		return list;
	}

	public BaseDao<String> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<String> baseDao) {
		this.baseDao = baseDao;
	}

}
