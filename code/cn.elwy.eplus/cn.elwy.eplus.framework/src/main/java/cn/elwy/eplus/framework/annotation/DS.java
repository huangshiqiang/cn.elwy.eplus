package cn.elwy.eplus.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注解（自动缓存拦截）,用于标识一个方法的输出结果是可以自动缓存的.
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {

	DsId value() default DsId.master;

	/**
	 * 数据源ID枚举，用于指明数据的操作方式.
	 * @author huangsq
	 */
	public enum DsId {
		dataSource,
		/** 主数据源 */
		master,
		/** 从数据源 */
		cluster
	}

}
