package cc.fxea.test.config;

import cc.fxea.test.annotation.TargetDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className RoutingAopAspect
 * @description
 * @date 7/5/2020 20:21
 **/
@Order(0)
@Aspect
@Component
public class RoutingAopAspect {

    @Around("@annotation(targetDataSource)")
    public Object routingWithDataSource(ProceedingJoinPoint joinPoint, TargetDataSource targetDataSource) throws Throwable {
        try {
            DynamicRoutingDataSourceContext.setRoutingDataSource(targetDataSource.value());
            return joinPoint.proceed();
        } finally {
            DynamicRoutingDataSourceContext.removeRoutingDataSource();
        }
    }

}
