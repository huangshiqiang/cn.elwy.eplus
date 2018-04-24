package cn.elwy.eplus.framework.dao.dialect;

/**
 * Oracle数据库方言
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class OracleDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		// pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		// pagingSelect.append(sql);
		// pagingSelect.append(" ) row_ ) where rownum_ > " + offset + " and rownum_ <=
		// " + (offset + limit));

		if (limit < 0) {
			pagingSelect.append(sql);
		} else {
			if (offset > 0) {
				pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
			} else {
				pagingSelect.append("select * from ( ");
			}
			pagingSelect.append(sql);
			if (offset > 0) {
				pagingSelect.append(" ) row_ ) where rownum_ <= " + (offset + limit) + " and rownum_ > " + offset);
			} else {
				pagingSelect.append(" ) where rownum <= " + limit);
			}
		}
		if (isForUpdate) {
			pagingSelect.append(" for update");
		}

		return pagingSelect.toString();
	}

}
