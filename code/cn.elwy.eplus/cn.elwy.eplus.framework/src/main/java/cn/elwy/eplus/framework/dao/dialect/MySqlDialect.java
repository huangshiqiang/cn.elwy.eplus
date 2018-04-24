package cn.elwy.eplus.framework.dao.dialect;

/**
 * MySQL数据库方言
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MySqlDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		if (offset > 0) {
			return sql + " limit " + offset + "," + limit;
		} else {
			return sql + " limit " + limit;
		}
	}

}
