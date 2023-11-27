package org.doit.ky.di.test;

import org.doit.ky.di.RecordImpl;
import org.doit.ky.di.RecordViewImpl;

public class Ex01 {

	public static void main(String[] args) {
		
//		System.out.println("Hello ");
		// p 59 스프링 컨테이너
		/*
		 * 1. di 패키지
		 *   ㄴ Record 인터페이스
		 *   ㄴ RecordImple 클래스
		 *   ㄴ RecordView 인터페이스
		 *   ㄴ RecordViewImple 클래스
		 */
		RecordImpl recordImple = new RecordImpl();
		
//		RecordViewImple rvi = new RecordViewImple(recordImple); // 생성자 DI
		RecordViewImpl rvi = new RecordViewImpl();
		rvi.setRecordImple(recordImple); // Setter DI
		
		rvi.input();
		rvi.output();
		
		System.out.println(" END ");
//		스프링 설정파일 + 스프링 컨텍스트 : 객체생성+조립
		
	}

}
