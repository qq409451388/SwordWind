package com.poethan.gear.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Slf4j
@Aspect
public class SchdulerJobAspect {
    //@Pointcut(value = "execution(com.poethan.gear.anno.SchdulerJob)")
    @Pointcut(value =  "@annotation(com.poethan.gear.anno.SchdulerJob)")
    public void jobPointCut(){

    }

    @Around(value = "jobPointCut()")
    public Object jobPointCutRun(ProceedingJoinPoint pjp, JoinPoint joinPoint) {
        try{
            Object ret = pjp.proceed();
            return ret;
        } catch(Throwable e) {
            log.error("SchdulerJob({}) Register Fail!", pjp.getClass().getSimpleName());
            return null;
        }
    }
}
