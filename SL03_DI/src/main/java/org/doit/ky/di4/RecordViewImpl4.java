package org.doit.ky.di4;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class RecordViewImpl4 implements RecordView4  {

//	@Autowired(required = false)
//	@ImportResource(name="record") java 9 부터 사용 x
	@Inject
	@Named(value = "recordImpl4")
	private RecordImpl4 recordImpl = null;
	
	@Override
	public void input() {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.print("> kor, eng, mat input ? ");
			int kor = scanner.nextInt();
			int eng = scanner.nextInt();
			int mat = scanner.nextInt();						
			this.recordImpl.setKor(kor);
			this.recordImpl.setEng(eng);
			this.recordImpl.setMat(mat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void output() {
		System.out.printf("> kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n"
				,this.recordImpl.getKor(),this.recordImpl.getEng(),this.recordImpl.getMat(),this.recordImpl.total(),this.recordImpl.avg());
	}
	
	
}
