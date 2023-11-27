package org.doit.ky.aop;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int x, int y) {		
		long start = System.nanoTime();
		int result = x + y; // 핵심 기능
		long end = System.nanoTime();
		System.out.printf("> 처리 시간 : %d ns\n", (end-start));
		return result;
	}

	@Override
	public int sub(int x, int y) {
		long start = System.nanoTime();
		int result = x - y; // 핵심 기능
		long end = System.nanoTime();
		System.out.printf("> 처리 시간 : %d ns\n", (end-start));
		return result;
	}

	@Override
	public int mult(int x, int y) {
		long start = System.nanoTime();
		int result = x * y; // 핵심 기능
		long end = System.nanoTime();
		System.out.printf("> 처리 시간 : %d ns\n", (end-start));
		return result;
	}

	@Override
	public int div(int x, int y) {
		long start = System.nanoTime();
		int result = x / y; // 핵심 기능
		long end = System.nanoTime();
		System.out.printf("> 처리 시간 : %d ns\n", (end-start));
		return result;
	}

}
