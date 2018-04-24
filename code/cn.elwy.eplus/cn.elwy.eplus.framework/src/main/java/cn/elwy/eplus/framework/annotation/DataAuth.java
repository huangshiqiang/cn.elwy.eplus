package cn.elwy.eplus.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DataAuth {

	String[] codes();

	boolean dataAuth() default true;

	boolean columnAuth() default false;

}