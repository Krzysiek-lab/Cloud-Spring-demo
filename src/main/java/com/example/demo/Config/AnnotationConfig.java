package com.example.demo.Config;

import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@CommonsLog
public class AnnotationConfig {

    @Pointcut("@annotation(com.example.demo.Annotations.MyAnnotation)")
    public void myAnnotationMethod() {
    }

    @Around("myAnnotationMethod()")
    public Object logsBefore(ProceedingJoinPoint pjp) throws Throwable {
        log.info("POST CART BEFORE");
        Object proceed = pjp.proceed();
        log.info("POST CART AFTER");
        return proceed;
    }
}
