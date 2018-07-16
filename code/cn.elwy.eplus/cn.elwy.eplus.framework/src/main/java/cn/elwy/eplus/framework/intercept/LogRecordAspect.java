package cn.elwy.eplus.framework.intercept;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.elwy.common.log.Logger;
import cn.elwy.common.log.LoggerFactory;
import cn.elwy.common.util.JsonUtil;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Aspect
@Configuration
public class LogRecordAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

	// 定义切点Pointcut
	@Pointcut("execution(* cn.elwy.*.controller.*(..))")
	public void excudeService() {
	}

	@Around("excudeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		logger.info("请求结束，controller的返回值是 " + JsonUtil.toJson(result));
		return result;
	}
}