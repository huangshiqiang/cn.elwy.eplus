package cn.elwy.eplus.framework.dao.dialect;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认的数据库方言管理器实现类，对数据库方言对象进行管理。 目前已经实现的数据库方言包括：
 * 
 * <pre>
       方言名称                      方言类
    db2            DB2Dialect
    mysql          MySqlDialect
    oracle         OracleDialect
    postgreSql     PostgreSqlDialect
    mssq           MsSqlDialect
    mssql2000      MsSql2000Dialect
    mssql2005      MsSql2005Dialect
 * </pre>
 * 
 * 如果没有指定有效的方言名称，将使用默认的方言类Dialect。
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class DialectFactory {

	private static Map<String, Dialect> dialects;

	static {
		dialects = new HashMap<String, Dialect>();
		dialects.put("db2", new DB2Dialect());
		dialects.put("mysql", new MySqlDialect());
		dialects.put("oracle", new OracleDialect());
		dialects.put("sqlServer2005", new MsSql2005Dialect());
		dialects.put("sqlServer", new MsSql2000Dialect());
	}

	private DialectFactory() {
	}

	/**
	 * 获取数据库方言
	 * @param dbType
	 * @return
	 */
	public static Dialect getDialect(String dbType) {
		if (dbType == null) {
			dbType = "mysql";
		}
		return dialects.get(dbType);
	}

}
