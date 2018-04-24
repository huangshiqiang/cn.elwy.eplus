package cn.elwy.eplus.framework.intercept;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import cn.elwy.common.log.Logger;
import cn.elwy.common.log.LoggerFactory;
import cn.elwy.eplus.framework.annotation.Function;
import cn.elwy.eplus.framework.annotation.Log;
import cn.elwy.eplus.framework.annotation.Operation;
import cn.elwy.eplus.framework.support.InterceptorSupport;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Aspect
@Configuration
public class ControllerAspect {

	private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	public ControllerAspect() {
	}

	@Pointcut("@annotation(cn.elwy.eplus.framework.annotation.Operation)")
	private void aspectOperationMethod() {
	}

	@Before("aspectOperationMethod()")
	public void before(JoinPoint joinPoint) {
		Object handle = joinPoint.getTarget();
		Function function = handle.getClass().getAnnotation(Function.class);
		Method method = InterceptorSupport.getMethod(joinPoint);
		Operation operation = method.getAnnotation(Operation.class);

		if (function == null) {
			return;
		}
		if (operation != null) {
			Log log = method.getAnnotation(Log.class);
			if (log != null && !log.ignore()) {
				logger.debug(function.name() + ":" + operation.name());
			}
		}

		// 的到功能代码和操作代码进行拼接，调用权限校验功能进行判断是否有权限。
		if (operation.funcAuth()) {
			operation.code();
			function.code();
		}

		// Object[] parameters = joinPoint.getArgs();
		// ((Parameter) parameters[0]).setPageSize(100);
		System.out.println(method);

		try {
			// *========控制台输出=========*//
			System.out.println("=====前置通知开始=====");
			System.out.println(
					"请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			System.out.println("方法描述:" + InterceptorSupport.getMethod(joinPoint));
			// *========数据库日志=========*//
			System.out.println("=====前置通知结束=====");
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==前置通知异常==");
			logger.error("异常信息:{}", e.getMessage());
		}
	}

	@After("aspectOperationMethod()")
	public void after(JoinPoint joinPoint) {
		System.out.println("doAfter");

	}

}