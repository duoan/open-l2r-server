package io.github.fullstack.rank.platform.admin.metrics;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;

/**
 * Summary: 服务监控
 * http://www.jianshu.com/p/e20a5f42a395
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/18
 * Time   : 上午10:58
 */
@Aspect
@Component
public class ServiceMonitor {

    @Autowired
    private CounterService counterService;
    @Autowired
    private GaugeService gaugeService;

    @Before("execution(* io.github.fullstack.rank.platform.admin.controller.*.*(..))")
    public void countServiceInvoke(JoinPoint joinPoint) {
        counterService.increment(joinPoint.getSignature() + "");
    }

    @Around("execution(* io.github.fullstack.rank.platform.admin.controller.*.*(..))")
    public void latencyService(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        pjp.proceed();
        long end = System.currentTimeMillis();
        gaugeService.submit(pjp.getSignature().toString(), end - start);
    }

}
