package org.doit.ky.aop3.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
@Component
public class LogPrintBeforeAdvice3 implements MethodBeforeAdvice {

	@Override            // add()          3,4      핵심 기능 실체 객체
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">> " + methodName +"() LogPrintBeforeAdvice.");

	}

}
