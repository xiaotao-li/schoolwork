package com.igeek.ch06.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Order(2)
public class LogAspect {

    @Pointcut("execution(public int com.igeek.ch06.aop.aspect.CountImpl.*(..))")
    public void pointCut(){ }

    @Before("pointCut()")
    public void beforeAdvice(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("日志追踪： the method "+methodName+" begin with "+args);
    }

    @After("pointCut()")
    public void afterAdvice(JoinPoint jp){
        System.out.println("日志追踪： the method "+jp.getSignature().getName()+" end with");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void afterReturningAdvice(JoinPoint jp,Object result){
        System.out.println("日志追踪： the method "+jp.getSignature().getName()+" end with "+result);
    }

 
    //@AfterThrowing(value = "execution(* CountImpl.*(..))" , throwing = "ex")
    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint jp,Exception ex){
        System.out.println("日志追踪： the method "+jp.getSignature().getName()+" 抛出异常： "+ex.getMessage());
    }

    public int aroundAdvice(ProceedingJoinPoint pjp){
        int result = 0;
        System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" begin with "+Arrays.asList(pjp.getArgs()));
        try {
            result = (int)pjp.proceed();
            System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" end with "+result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" 抛出异常： "+throwable.getMessage());
        }
        System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" end with");
        return result;
    }

}
