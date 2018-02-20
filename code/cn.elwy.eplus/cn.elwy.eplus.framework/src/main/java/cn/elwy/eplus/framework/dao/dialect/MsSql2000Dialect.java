package cn.elwy.eplus.framework.dao.dialect;

/**
 * MsSql2000数据库方言
 * @author huangsq
 * @version 1.0, 2015-12-12
 * @since 1.0, 2015-12-12
 */
public class MsSql2000Dialect extends Dialect {

	public String getLimitString(String querySelect, int offset, int limit) {
		if (offset > 0) {
			throw new UnsupportedOperationException("sql server has no offset");
		}
		return new StringBuffer(querySelect.length() + 8).append(querySelect)
				.insert(getAfterSelectInsertPoint(querySelect), " top " + limit).toString();
	}

	static int getAfterSelectInsertPoint(String sql) {
		int selectIndex = sql.toLowerCase().indexOf("select");
		final int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
		return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
	}

}
