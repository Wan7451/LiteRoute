package com.wan7451.literoute.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Intent  类名注解
 * 声明要跳转的组件
 *
 * @author wan7451
 * @data 2017/3/24
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassName {
    String value();
}
