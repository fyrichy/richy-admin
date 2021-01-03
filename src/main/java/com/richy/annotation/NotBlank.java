package com.richy.annotation;

import java.lang.annotation.*;

/**
 * @desc:
 * 自定义非空校验注解
 * @author: Richy
 * @date: 2020-12-27 21:33
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotBlank {
}
