package com.test.aspect;

import com.test.annotation.LoggerOperator;
import com.test.entities.User;
import com.test.util.GsonUtils;
import com.test.util.IpAddressUtil;
import com.test.util.JwtUtil;
import com.test.vo.LoggerVO;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/10 21:13
 * @Describe
 */

@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.test.annotation.LoggerOperator)")
    public void controllerAspect(){
    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        LoggerVO loggerVO = new LoggerVO();
        String visitor = getVisitor(request);
        loggerVO.setVisitor(visitor);
        loggerVO.setIp(IpAddressUtil.getIpAddress(request));
        String method = joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName();
        loggerVO.setMethod(method);
        loggerVO.setDescription(getDescription(joinPoint));
        Object[] args = joinPoint.getArgs();
        List<Object> objects = new ArrayList<>();
        for (Object obj:args) {
            if(!(obj instanceof HttpServletRequest || obj instanceof HttpServletResponse)){
                objects.add(obj);
            }
        }
        loggerVO.setData(objects);
        String json = GsonUtils.toJson(loggerVO);
        logger.info(json);
    }

    private String getDescription(JoinPoint joinPoint) {
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        LoggerOperator operation = method.getAnnotation(LoggerOperator.class);
        if (operation != null) {
            String value = operation.description();
            return value;
        }
        return null;
    }

    private String getVisitor(HttpServletRequest request) {
        String token = JwtUtil.getToken(request);
        if(token==null || token.equals(""))
            return null;
        String username = JwtUtil.getClaim(token,"username");
        return username;
    }

}
