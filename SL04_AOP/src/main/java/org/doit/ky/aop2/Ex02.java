package org.doit.ky.aop2;

import org.doit.ky.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
//		p 204 스프링 AOP
//		1. Calculator 인터페이스 + - * /
//		2. CalculatorImpl 클래스 구현
//		3. Ex01 테스트
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context2.xml");
//		Calculator calc =  ctx.getBean("calc",Calculator.class);
		Calculator calc =  ctx.getBean("calcProxy",Calculator.class);
		System.out.println(calc.add(3, 4));
//		System.out.println(calc.sub(3, 4));
		System.out.println(" END ");
	}

}

// 스프링 3가지 AOP 구현 방식
// 1) 스프링API 이용한 구현  X
//   org.doit.ky.aop2  
//   org.doit.ky.aop2.advice > LogPrintAroundAdvice

