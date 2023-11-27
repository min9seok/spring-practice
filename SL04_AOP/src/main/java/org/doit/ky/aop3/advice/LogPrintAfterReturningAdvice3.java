package org.doit.ky.aop3.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

// 후 advice + 예외발생 X
@Component
public class LogPrintAfterReturningAdvice3 implements AfterReturningAdvice {

	@Override             //        결과값              add()            3,4           실체객체                 
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable { 
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>> " + methodName +"() LogPrintAfterReturningAdvice.");
	}

}
