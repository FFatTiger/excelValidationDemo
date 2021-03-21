package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExcelDataListenerAspect {

    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
    @Pointcut("execution(* com.example.demo.read..*.*(..))")

    public void excelDataPointCut(){}

    @Before("excelDataPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("插入前");
        System.out.println("插入前");
    }

    @After("excelDataPointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("插入后");

        log.info("插入后");
    }



}
