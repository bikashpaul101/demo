package com.example.demo.advice;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

@Aspect
@Component
public class LoggingAdvice {
	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.example.demo.*.*.*(..) )")
	public void demoPointCut() {

	}
	
	@Around("demoPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Jdk8Module());//to print optional objects//
		//https://stackoverflow.com/questions/25693309/using-jackson-objectmapper-with-java-8-optional-values
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		Object obj =  object;
		log.info(className + " : " + methodName + "()" + "Response : "
				+ mapper.writeValueAsString(obj));
		return object;
	}
}
