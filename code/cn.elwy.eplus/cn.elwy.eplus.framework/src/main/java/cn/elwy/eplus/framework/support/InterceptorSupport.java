package cn.elwy.eplus.framework.support;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class InterceptorSupport {

	private InterceptorSupport() {
	}

	public static Method getMethod(JoinPoint joinPoint) {
		String methodLongName = joinPoint.getSignature().toLongString();
		Method[] methods = joinPoint.getTarget().getClass().getMethods();
		Method method = null;

		for (int i = 0, len = methods.length; i < len; i++) {
			if (methodLongName.equals((methods[i].toString().split("throws")[0]).trim())) {
				method = methods[i];
				break;
			}
		}
		return method;
	}

}