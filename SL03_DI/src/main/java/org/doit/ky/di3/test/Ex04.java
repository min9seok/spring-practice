package org.doit.ky.di3.test;

import org.doit.ky.di3.RecordViewImpl3;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex04 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-content3.xml");
		RecordViewImpl3 rvi = (RecordViewImpl3) ctx.getBean("rvi");
		
		rvi.input();
		rvi.output();
		
		System.out.println(" END ");

	}

}
