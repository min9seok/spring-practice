package org.doit.ky.di4.test;

import org.doit.ky.di4.RecordViewImpl4;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-content4.xml");
		RecordViewImpl4 rvi = (RecordViewImpl4) ctx.getBean("recordViewImpl4");
		
		rvi.input();
		rvi.output();
		
		System.out.println(" END ");

	}

}
