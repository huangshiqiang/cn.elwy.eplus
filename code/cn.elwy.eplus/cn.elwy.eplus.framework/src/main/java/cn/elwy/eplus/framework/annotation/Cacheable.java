package cn.elwy.eplus.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 缓存注解（自动缓存拦截）,用于标识一个方法的输出结果是可以自动缓存的.
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cacheable {

	/**
	 * 缓存的操作类型枚举，用于指明数据的操作方式.
	 * @author huangsq
	 */
	public enum OperateType {
		/** 清除缓存操作 */
		CLEAR,
		/** 向缓存中添加数据 */
		PUT
	}

	/**
	 * 指定的缓存操作
	 * @return OperateType
	 */
	public OperateType operate() default OperateType.CLEAR;

}
