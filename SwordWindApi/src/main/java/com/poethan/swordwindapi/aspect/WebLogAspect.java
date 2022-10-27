package com.poethan.swordwindapi.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class WebLogAspect {
    @Around("execution(public * com.poethan.swordwindapi.api.*.*())")
    public Object weblog(ProceedingJoinPoint pjp){
        try{
            Object ret = pjp.proceed();
            return ret;
        } catch(Throwable e) {
            return null;
        }
    }
}
