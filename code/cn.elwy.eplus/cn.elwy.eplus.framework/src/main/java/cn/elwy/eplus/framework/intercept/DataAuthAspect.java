package cn.elwy.eplus.framework.intercept;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.elwy.common.entity.Condition;
import cn.elwy.common.log.Logger;
import cn.elwy.common.log.LoggerFactory;
import cn.elwy.common.util.AssertUtil;
import cn.elwy.eplus.framework.annotation.DataAuth;
import cn.elwy.eplus.framework.annotation.Log;
import cn.elwy.eplus.framework.support.InterceptorSupport;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Aspect
@Component
public class DataAuthAspect {

	private static Logger logger = LoggerFactory.getLogger(DataAuthAspect.class);

	public DataAuthAspect() {
		System.out.println("DataAuthInterceptor");
	}

	@Pointcut("@annotation(cn.elwy.eplus.framework.annotation.DataAuth)")
	private void aspectDataAuthMethod() {
	}

	@Before("aspectDataAuthMethod()")
	public void before(JoinPoint joinPoint) {
		Method method = InterceptorSupport.getMethod(joinPoint);
		DataAuth dataAuth = method.getAnnotation(DataAuth.class);
		if (dataAuth != null) {
			Log log = method.getAnnotation(Log.class);
			if (log != null && !log.ignore()) {
				logger.debug(dataAuth.codes() + ":");
			}
		} else {
			return;
		}

		// 如果数据权限开启，根据当前的代码获取对应的权限列表，获取当前用户的数据权限。拼接
		/*-
		  1.如果是查询方法
		  
		  
		  2.如果是添加、更新方法，获取当前用户拥有的权限，反射获取属性的值进行比较
		    
		  
		  3.如果是删除方法
		  
		  
		  4.如果是添加方法
		  
		 */

		Object[] parameters = joinPoint.getArgs();
		if (AssertUtil.isNotEmpty(parameters)) {
			if (parameters[0] instanceof Condition) {
				Condition pa = (Condition) parameters[0];
				pa.setPageSize(100);
			}
		}
		System.out.println(method);

		try {
			// *========控制台输出=========*//
			System.out.println("=====前置通知开始=====");
			System.out.println(
					"请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			System.out.println("方法描述:" + method.toString());
			// *========数据库日志=========*//
			System.out.println("=====前置通知结束=====");
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==前置通知异常==");
			logger.error("异常信息:{}", e.getMessage());
		}
	}

	@After("aspectDataAuthMethod()")
	public void after(JoinPoint joinPoint) {
		System.out.println("doAfter");

	}

}