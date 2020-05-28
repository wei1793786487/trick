package com.chenghui.ticket.utlis.annotation;

import java.lang.annotation.*;

/**
 * @author Devil
 * @date 2020/1/22 17:42
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
    String describe() default "";
}
