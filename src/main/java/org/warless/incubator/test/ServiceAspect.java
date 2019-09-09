package org.warless.incubator.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : fetaxyu
 * @date : 2019-09-09
 */
@Aspect
@Component
public class ServiceAspect {

    @Pointcut("execution(* org.warless.incubator.test..*.*(..))")
    public void pointcut() { }

    @Before("pointcut()")
    public void before(JoinPoint point) {
        System.err.println("------ Method " + point.getTarget().getClass().getName() + "." + point.getSignature().getName() + "() Begin ------");
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        System.err.println("------ Method " + point.getTarget().getClass().getName() + "." + point.getSignature().getName() + "() End ------");
    }

}
