package com.znsd.filter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.znsd.annotation.LogCutional;
import com.znsd.bean.UserBean;
import com.znsd.service.impl.LogServiceImp;

@Component
@Aspect
public class LogCut {

	@Autowired
	private LogServiceImp service;

	// @Pointcut("execution(* com.znsd.service.impl.UserServiceImp.*(..))")
	@Pointcut("@annotation(com.znsd.annotation.LogCutional)")
	public void needCut() {
		System.out.println("方法进入之前-前置通知");
	}

	@Around("needCut()")
	public Object save(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(123);
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method targetMethod = methodSignature.getMethod();
		System.out.println(targetMethod.getName());
		targetMethod.setAccessible(true);
		LogCutional anno = targetMethod.getAnnotation(LogCutional.class);
		Object result = pjp.proceed();

		Object executeName = anno.value();

		// 获取RequestAttributes
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		// 从获取RequestAttributes中获取HttpServletRequest的信息
		HttpServletRequest request = (HttpServletRequest) requestAttributes
				.resolveReference(RequestAttributes.REFERENCE_REQUEST);

		String userId = ((UserBean) request.getSession().getAttribute("user")).getUserId();

		boolean saveResult = service.save(userId, executeName.toString(), result == null);
		System.out.println(saveResult);

		return result;
	}

}
