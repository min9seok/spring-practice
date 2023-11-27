package org.doit.ky.aop;

import org.springframework.stereotype.Component;

public interface Calculator {

	int add(int x, int y);  // +
	int sub(int x, int y);  // -
	int mult(int x, int y); // *
	int div(int x, int y);  // /
}
