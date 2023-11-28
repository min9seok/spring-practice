package org.doit.ky.aop5.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogPrintProfiler5 {

	@Pointcut("execution(* org.doit.ky.aop..*.*(*,*))")
	private void publicMethod() {}
	
	// 3. AfterAdvice p221
	@After("publicMethod()")
	public void afterFinally(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>> " + methodName + "() : LogPrintProfiler5.after 가 호출됨... ");
	}
	
	// 2. BrforeAdvice p217
	@Before("publicMethod()")
	public void before(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>> " + methodName + "() : LogPrintProfiler5.before 가 호출됨... ");
	}

	// 1. AroundAdvice p222
	@Around("publicMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().toShortString();
		Log log =  LogFactory.getLog(this.getClass());
		log.info("> " + methodName +"() start.");
		StopWatch sw = new StopWatch();
		sw.start();       
		// 핵심 관심 사항.
		Object  result = joinPoint.proceed() ;  // calc.add()        
		sw.stop();
		log.info("> " + methodName +"() end.");
		log.info("> " + methodName +"() 처리 시간 :  " + sw.getTotalTimeMillis() +"ms");
		return result;
	}

}
