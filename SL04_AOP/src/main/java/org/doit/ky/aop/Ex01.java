package org.doit.ky.aop;

public class Ex01 {

	public static void main(String[] args) {
//		p 204 스프링 AOP
//		1. Calculator 인터페이스 + - * /
//		2. CalculatorImpl 클래스 구현
//		3. Ex01 테스트

		Calculator calculator = new CalculatorImpl();
		System.out.println(calculator.add(4, 2));
		System.out.println(calculator.sub(4, 2));
		System.out.println(calculator.mult(4, 2));
		System.out.println(calculator.div(4, 2));
		System.out.println(" END ");
	}

}

// 스프링 3가지 AOP 구현 방식
// 1) 스프링API 이용한 구현 org.doit.ky.aop2