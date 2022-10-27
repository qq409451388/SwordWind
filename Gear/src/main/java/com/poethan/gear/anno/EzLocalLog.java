package com.poethan.gear.anno;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface EzLocalLog {
    boolean EnableConsume() default false;
}
