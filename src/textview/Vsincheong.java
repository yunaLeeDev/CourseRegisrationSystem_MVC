package textview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import controller.Clecture;
import valueObject.Odata;

public class Vsincheong {
	private static final String PATHNAME = "data";
	private Clecture csincheong;
	private Scanner scanner;
	public Vsincheong(Scanner scanner) {
		this.scanner = scanner;
		this.csincheong = new Clecture();
	}
	public void show(Odata olecture, String filename) {
		System.out.println("기존강좌 지우고 새로 신청하기[1], 기존 강좌에 이어 신청하기[2]");
		int a = this.scanner.nextInt();
		String t = null;
		if(a==1) {
			 t = this.update(olecture, filename);
		} else if(a==2) {
			 t = this.damgi(olecture, filename);
		} else {
			System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
		}
		if (t != null) {
		System.out.println(t + " 신청되었습니다.");
		}
		System.out.println("총 신청학점을 확인하시겠습니까?");
		System.out.println("예[1], 아니요[2]");
		int w = 0;
		while (w==0) {
		int k = this.scanner.nextInt();
		if(k==1) {
			String hakjum = this.csincheong.hakjumhwakin(filename);
			if(hakjum != null){
			System.out.println("신청된 강좌의 학점은 " + hakjum + "입니다.");
			}
			w = 1;
		} else if(k==2) {
			w = 1;
		} else {
			System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
			w = 0;
		}
		}
	}
	
	public String update(Odata olecture, String filename) {
		this.csincheong.writeAll(olecture, filename);
		return olecture.getName();
	}
	public String damgi(Odata olecture, String filename) {
		if(csincheong.siganpyo(olecture, filename)== true) {
		this.csincheong.write(olecture, filename);
		} else if(csincheong.siganpyo(olecture, filename)== false){
			System.out.println("기존 신청 강좌와 시간이 겹쳐 신청이 불가능합니다.");
			return null;
		}
		return olecture.getName();
	}
}
