package com.example.demo.Config;

import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@CommonsLog
public class AnnotationConfig {

    @Pointcut("@annotation(com.example.demo.Annotations.MyAnnotation)")
    public void myAnnotationMethod() {
    }

    @Before("myAnnotationMethod()")
    public void logsBefore() {
        log.info("POST CART BEFORE");
    }


    @After("myAnnotationMethod()")
    public void logsAfter() {
        log.info("POST CART AFTER");
    }
}
