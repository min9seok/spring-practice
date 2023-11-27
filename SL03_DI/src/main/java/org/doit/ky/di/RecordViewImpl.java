package org.doit.ky.di;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordViewImpl implements RecordView  {

	private RecordImpl recordImple = null;
//	private RecordImple recordImple = new RecordImple();
	
	@Override
	public void input() {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.print("> kor, eng, mat input ? ");
			int kor = scanner.nextInt();
			int eng = scanner.nextInt();
			int mat = scanner.nextInt();						
			this.recordImple.setKor(kor);
			this.recordImple.setEng(eng);
			this.recordImple.setMat(mat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void output() {
		System.out.printf("> kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n"
				,this.recordImple.getKor(),this.recordImple.getEng(),this.recordImple.getMat(),this.recordImple.total(),this.recordImple.avg());
	}
	
	
}
