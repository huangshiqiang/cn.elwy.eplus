package cn.elwy.eplus.framework.intercept;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;

/**
 * @description MVC拦截器
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MvcInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation)
			throws InvocationTargetException, IllegalAccessException, SQLException {
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
	}

}