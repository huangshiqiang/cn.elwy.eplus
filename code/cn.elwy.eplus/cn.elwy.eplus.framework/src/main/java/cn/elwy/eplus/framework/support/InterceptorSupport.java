package cn.elwy.eplus.framework.support;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class InterceptorSupport {

	private InterceptorSupport() {
	}

	public static Method getMethod(JoinPoint joinPoint) {
		// // 获得当前访问的class
		// Class<?> className = joinPoint.getTarget().getClass();
		// // 获得访问的方法名
		// String methodName = joinPoint.getSignature().getName();
		// // 得到方法的参数的类型
		// Class<?>[] argClass = ((MethodSignature)
		// joinPoint.getSignature()).getParameterTypes();
		// // 得到访问的方法对象
		// Method method = className.getMethod(methodName, argClass);

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