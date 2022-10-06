package com.zhu.aspect;

import com.alibaba.fastjson.JSON;
import com.zhu.annoation.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class LogAspect {


    @Pointcut("@annotation(com.zhu.annoation.SystemLog)")
    public void pt() {

    }


    // 使用环绕通知
    @Around("pt()")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 目标结果的返回值
        // 这里会出现异常
        Object res;
        try {
            handleBefore(joinPoint);
            // 直接抛出去然后让我们的全局异常捕获来操作
            res = joinPoint.proceed();
            handleAfter(res);
        } finally {
            // 结束后换行
            // 注意System.lineSeparator() 是换行符，不同的操作系统的换行符不同， 所以我们不用写死
            log.info("=======End=======" + System.lineSeparator());
        }

        return res;
    }


    private void handleBefore(ProceedingJoinPoint joinPoint) {


        // ctrl + alt + click 查看一个接口的实现类
        // 强转之后我们就可以得到request的了
        // 由这个request就可以得到url地址 http报文
        RequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();


        // 获取被增强方法上的注解对象

        SystemLog systemLog = getSystemLog(joinPoint);



        log.info("=======Start=======");
        // 打印请求 URL
        log.info("URL            : {}", request.getRequestURL());
        // 打印描述信息 业务的名字
        log.info("BusinessName   : {}", systemLog.businessName());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), ((MethodSignature)joinPoint.getSignature()).getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteHost());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSONString(joinPoint.getArgs()));
    }

    private SystemLog getSystemLog(ProceedingJoinPoint joinPoint) {


        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();

        SystemLog systemLog = methodSignature.getMethod().getAnnotation(SystemLog.class);

        return systemLog;
    }

    private void handleAfter(Object res) {
        // 打印出参
        log.info("Response       : {}", JSON.toJSONString(res));
    }

}
