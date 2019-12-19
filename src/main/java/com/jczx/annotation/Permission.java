package com.jczx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 孙文举
 * @description
 * @create 2019-12-18 10:25
 */
@Target({ElementType.METHOD}) //代表写在方法上
@Retention(RetentionPolicy.RUNTIME) //在运行时生效
public @interface Permission {
    String value() default "";
}
