package cn.elwy.eplus.framework.intercept;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.elwy.common.log.Logger;
import cn.elwy.common.log.LoggerFactory;
import cn.elwy.eplus.framework.annotation.Function;
import cn.elwy.eplus.framework.annotation.Log;
import cn.elwy.eplus.framework.annotation.Operation;

/**
 * @description Coontroller拦截器
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class CoontrollerInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		if (o instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) o;
			Function function = hm.getBeanType().getAnnotation(Function.class);
			Method method = hm.getMethod();
			Operation operation = method.getAnnotation(Operation.class);

			if (function == null) {
				return false;
			}
			if (operation != null) {
				Log log = method.getAnnotation(Log.class);
				if (log != null && !log.ignore()) {
					logger.debug(function.name() + ":" + operation.name());
				}
				// 的到功能代码和操作代码进行拼接，调用权限校验功能进行判断是否有权限。
				if (operation.funcAuth()) {
					operation.code();
					function.code();
				}
			}

			// Object[] parameters = joinPoint.getArgs();
			// ((Parameter) parameters[0]).setPageSize(100);
			System.out.println(method);
		}
		//

		System.out.println("CustomInterceptor1拦截器开始工作，拦截到当前请求地址：" + httpServletRequest.getRequestURL().toString());
		// 只有返回true才会继续向下执行，返回false取消当前请求
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
		// 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
		// System.out.println("CustomInterceptor1.postHandle:" + o + ", modelAndView:" +
		// modelAndView);
		HandlerMethod method = (HandlerMethod) o;
		System.out.println("-- MethodName:" + method.getMethod().getName());
		System.out.println("-- ReturnType:" + method.getMethod().getReturnType());
		System.out.println("-- MethodParameters:" + method.getMethodParameters());
		MethodParameter[] parameters = method.getMethodParameters();
		if (null != parameters) {
			for (MethodParameter parameter : parameters) {
				System.out.println("  -- parameterIndex:" + parameter.getParameterIndex() + ",parameterName:"
						+ parameter.getParameterName() + ",parameterType:" + parameter.getParameterType());
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			Exception e) throws Exception {
		// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
		// System.out.println("CustomInterceptor1.afterCompletion:" + o);
		System.out.println("afterCompletion清理资源...");
		// 清理session
		HttpSession session = httpServletRequest.getSession();
		if (session != null) {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) session.getAttribute("map1");
			if (!CollectionUtils.isEmpty(map)) {
				session.removeAttribute("map1");
				System.out.println("清理map1...");
			}
		}
		System.out.println("afterCompletion资源清理完成...");
	}
}
