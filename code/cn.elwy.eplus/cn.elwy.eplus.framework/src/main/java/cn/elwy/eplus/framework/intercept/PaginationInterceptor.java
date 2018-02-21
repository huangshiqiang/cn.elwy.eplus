package cn.elwy.eplus.framework.intercept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import cn.elwy.common.util.CloseUtil;
import cn.elwy.eplus.framework.dao.dialect.Dialect;
import cn.elwy.eplus.framework.dao.dialect.DialectFactory;
import cn.elwy.eplus.framework.dao.mybatis.MyBatisPage;

/**
 * @description 数据库分页插件，只拦截查询语句.
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }) })
public class PaginationInterceptor implements Interceptor {

	private static final Logger logger = Logger.getLogger(PaginationInterceptor.class);

	private String dialectType = "mysql";

	public PaginationInterceptor() {
		System.err.println("PaginationInterceptor");
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();
		if (target instanceof StatementHandler) {
			StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
			RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
			if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
				return invocation.proceed();
			}

			BoundSql boundSql = statementHandler.getBoundSql();
			String originalSql = removeBreakingWhitespace(boundSql.getSql());
			Dialect dialect = DialectFactory.getDialect(this.dialectType);

			// 获取总记录数
			if (rowBounds instanceof MyBatisPage) {
				Connection connection = (Connection) invocation.getArgs()[0];
				ParameterHandler parameterHandler = statementHandler.getParameterHandler();
				String countSql = dialect.getCountString(originalSql);
				long totalRecord = getTotalRecord(parameterHandler, connection, countSql);
				((MyBatisPage<?>) rowBounds).setTotalRecord(totalRecord);
			}

			// 设置物理分页语句
			String pageSql = dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit());
			// 重写分页sql
			metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
			// 屏蔽mybatis原有分页
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
			if (logger.isDebugEnabled()) {
				logger.debug("分页SQL : " + originalSql);
			}
		}
		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}

	protected String removeBreakingWhitespace(String original) {
		StringTokenizer whitespaceStripper = new StringTokenizer(original);
		StringBuilder builder = new StringBuilder();
		while (whitespaceStripper.hasMoreTokens()) {
			builder.append(whitespaceStripper.nextToken());
			builder.append(" ");
		}
		return builder.toString();
	}

	/**
	 * 只拦截这两种类型的 <br>
	 * StatementHandler <br>
	 * ResultSetHandler
	 * @param target
	 * @return
	 */
	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
	}

	/**
	 * 获取结果集总计录数
	 * @param parameterHandler
	 * @param connection
	 * @param countSql
	 * @return 结果集记录数
	 * @throws SQLException
	 */
	protected long getTotalRecord(ParameterHandler parameterHandler, Connection connection, String countSql)
			throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		long count = 0;
		try {
			prepareStatement = connection.prepareStatement(countSql);
			parameterHandler.setParameters(prepareStatement);
			rs = prepareStatement.executeQuery();
			if (rs.next()) {
				count = rs.getLong(1);
			}
			return count;
		} finally {
			CloseUtil.close(rs);
			CloseUtil.close(prepareStatement);
		}
	}

	public String getDialectType() {
		return dialectType;
	}

	public void setDialectType(String dialectType) {
		this.dialectType = dialectType;
	}

}
