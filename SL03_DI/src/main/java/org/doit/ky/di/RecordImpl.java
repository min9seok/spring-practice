package org.doit.ky.di;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordImpl implements Record {
	
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
