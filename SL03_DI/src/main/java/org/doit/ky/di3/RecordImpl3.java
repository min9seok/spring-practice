package org.doit.ky.di3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordImpl3 implements Record3 {
	
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
