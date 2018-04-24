package cn.elwy.eplus.framework.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.elwy.eplus.framework.context.AppContext;
import cn.elwy.eplus.framework.context.AppSession;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		AppSession appSession = (AppSession) request.getSession().getAttribute(AppContext.APP_SESSION_KEY);
		AppContext.setAppSession(appSession);

		return super.preHandle(request, response, handler);
	}

}
