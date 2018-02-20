package cn.elwy.eplus.framework.dao.dialect;

/**
 * @description 数据库方言抽象类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public abstract class Dialect {

	/**
	 * 得到分页sql
	 * @param sql
	 * @param offset
	 * @param limit
	 * @return
	 */
	public abstract String getLimitString(String sql, int offset, int limit);

	/**
	 * 得到总记录数的 sql
	 * @param sql
	 * @return
	 */
	public String getCountString(String sql) {
		return "select count(1) from (" + sql + ") alias_for_page";
	}

}
