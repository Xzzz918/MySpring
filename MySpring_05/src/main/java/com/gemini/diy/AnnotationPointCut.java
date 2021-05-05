package com.gemini.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author gemini
 * Created in  2021/5/5 9:26
 *  注解实现AOP：切面，通知，切入点均用注解定义
 */
@Aspect //标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.gemini.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("=========方法执行前=======");
    }

    @After("execution(* com.gemini.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("=========方法执行后=======");
    }

//    在环绕增强中，我们可以给定一个参数，代表我们要获取处理的点：连接点
    @Around("execution(* com.gemini.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("=========环绕前=======");
//        方法执行
        point.proceed();
        System.out.println("=========环绕后=======");
    }
}
