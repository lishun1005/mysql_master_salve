package com.lishun.annotation;

/**
 * @author lishun
 * @Description: TODO
 * @date 2018/2/11
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lishun
 * @Description: 读数据源注解
 * @date 2018/2/9
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadDataSource {
	String vlaue() default "read_ds";
}
