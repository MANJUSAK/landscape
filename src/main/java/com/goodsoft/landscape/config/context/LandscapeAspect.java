package com.goodsoft.landscape.config.context;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

/**
 * function 系统aop处理类
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 */
//@Aspect
//@Component
public class LandscapeAspect {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(LandscapeAspect.class);

    @Pointcut("execution(public * com.goodsoft.landscape.service.servicelmpl.*.*(..))")
    public void tx() {
    }

    @Before("tx()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("进入doBefore切面");
        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        HttpServletRequest session = (HttpServletRequest) request.getSession().getAttribute("userInfo");
//        if (session == null) {
//            new UserManagementController().test();
//        }

/*
// 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
*/

    }

    @AfterReturning(returning = "ret", pointcut = "tx()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("进入doAfterReturning切面");
    }
}
