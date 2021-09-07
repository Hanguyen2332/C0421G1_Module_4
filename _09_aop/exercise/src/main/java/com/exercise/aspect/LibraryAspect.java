package com.exercise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
@Component
public class LibraryAspect {
    private int countVisitor = 0;  //biến đếm số view


    @Pointcut("execution(* com.exercise.controller.BookController.borrow(..))")
    public void borrowMethodPointCut(){}

    @AfterReturning("borrowMethodPointCut()")
    public void loggerBorrow(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("------------------");
        System.err.println("Borrow book by method:" + methodName + ", time: " + LocalDate.now());
    }

    @Pointcut("execution(* com.exercise.controller.BookController.giveBack(..))")
    public void giveBackMethodPointCut(){}

    @AfterReturning("giveBackMethodPointCut()")
    public void loggerGiveBack(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("------------------");
        System.err.println("Return book by method: " + methodName + ", time: " + LocalDate.now());
    }

    //đếm số người ghé thăm:
    @Pointcut("within(com.exercise.controller.BookController*)")
    public void allControllerPointCut(){}

    @After("allControllerPointCut()")
    public void countVisitor(JoinPoint joinPoint) {
        System.out.println("------------------");
        System.err.println("Tổng số lượt khách ghé thăm thư viện = " +  countVisitor++);
    }
}
