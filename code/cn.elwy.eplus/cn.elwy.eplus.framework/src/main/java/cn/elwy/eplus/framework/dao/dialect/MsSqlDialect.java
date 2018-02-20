package cn.elwy.eplus.framework.dao.dialect;

/**
 * @description MsSql 数据库方言
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MsSqlDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		int selectIndex = sql.toLowerCase().lastIndexOf("select");
		if (selectIndex > -1) {
			sql = sql.substring(0, selectIndex) + "select top " + (limit + offset) + sql.substring(selectIndex + 6);
		}

		String pagingSelect = "select * from(select row_number () over (order by getdate()) rownum,* from( " + sql
				+ " ) a ) b where b.rownum > " + offset + " and b.rownum <= " + (limit + offset);
		return pagingSelect;
	}

}
