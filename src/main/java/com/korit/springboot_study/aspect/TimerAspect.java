package com.korit.springboot_study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAspect {

    @Pointcut("execution(* com.korit.springboot_study.service.PostService.getPostById(..))")
    private void pointCut() {}

    @Pointcut("@annotation(com.korit.springboot_study.aspect.annotation.TimerAop)")
    private void annotationPointCut() {}

    @Around("pointCut() || annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        System.out.println("메서드 실행 시간: " + stopWatch.getTotalTimeSeconds());
        return result;
    }
}
