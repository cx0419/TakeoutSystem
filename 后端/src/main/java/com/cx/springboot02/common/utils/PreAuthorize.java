package com.cx.springboot02.common.utils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 预授权
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface PreAuthorize {
    AuthorizeType value() default AuthorizeType.CUSTOMER;
    AuthorizeType[] values() default {};
}
