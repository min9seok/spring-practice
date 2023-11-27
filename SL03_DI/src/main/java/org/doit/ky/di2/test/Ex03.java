package org.doit.ky.di2.test;

import org.doit.ky.di.RecordViewImpl;
import org.doit.ky.di2.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {

	public static void main(String[] args) {
		
//		1. 스프링 객체 생성 + 조립 > 스프링 컨테이너 == DI 컨테이너
//		2. 2가지 방법 
//		1) xml 파일
//		  src/main/resources/application-content.xml 추가
//		2) 자바(class) 파일
//		  org.doit.ky.di2.Config.java
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);		
		RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("rvi");
//		RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("getrecordViewImpl");
		
		rvi.input();
		rvi.output();
		
		System.out.println(" END ");
	}

}
