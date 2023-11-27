package org.doit.ky.di4;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Component("recordImpl4") // recordImpl4 빈 id 
public class RecordImpl4 implements Record4 {
	
	private int kor;
	private int eng;
	private int mat;
	@Override
	public int total() {
		return kor+eng+mat;
	}
	@Override
	public double avg() {
		return total()/3.0;
	}	
	
}
