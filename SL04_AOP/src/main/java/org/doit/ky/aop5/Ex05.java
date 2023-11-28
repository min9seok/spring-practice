package org.doit.ky.aop5;

import org.doit.ky.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {
	
	public static void main(String[] args) {
		// p 211 XML 스키마 기반 AOP 구현 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context5.xml");		
		Calculator calc =  ctx.getBean("calculatorImpl5",Calculator.class);
		System.out.println(calc.add(3, 4));
		System.out.println(" END ");
	}

}

// 스프링 3가지 AOP 구현 방식
// 1) 스프링API 이용한 구현  X
//   org.doit.ky.aop2  
//   org.doit.ky.aop2.advice > LogPrintAroundAdvice

