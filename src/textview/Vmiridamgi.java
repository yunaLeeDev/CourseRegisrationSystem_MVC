package textview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import controller.Clecture;
import valueObject.Odata;
import valueObject.Oindex;

public class Vmiridamgi {
	private static final String PATHNAME = "data";
	private Scanner scanner;
	private Vsincheong vsincheong;
	private Clecture cmiridamgi;
	
	public Vmiridamgi(Scanner scanner) {
		this.scanner = scanner;
		this.vsincheong = new Vsincheong(scanner);
		this.cmiridamgi = new Clecture();
	}
	public void update(Odata olecture, String filename) {
		String a = filename+"miridamgi";
		this.cmiridamgi.writeAll(olecture, a);		
	}
	
	public void damgi(Odata olecture, String filename) {
		String a = filename+"miridamgi";
		this.cmiridamgi.write(olecture, a);
	}
	public void sijak(Odata olecture, String filename) {
		System.out.println("원하는 기능을 선택하세요.");
		System.out.println("초기화 후 책가방 담기[1], 기존 책가방에 이어담기[2]");
		int a = 0;
		while(a==0) {
		a = this.scanner.nextInt();
		if(a==1) {
			this.update(olecture, filename);
		} else if(a==2) {
			this.damgi(olecture, filename);
		} else {
			System.out.println("잘못입력하셨습니다.");
			a = 0;
		}
		}
	}
	public void sinc(String filename) {
		int p = 0;
		while (p==0) {
		System.out.println("책가방에서 원하는 기능을 선택하세요.");
		System.out.println("책가방 안에 담긴 강좌 신청하기[1], 담긴 학점 조회하기[2]");
		int i = this.scanner.nextInt();
		if(i==1) {
		Vector<Odata> odatas = this.cmiridamgi.readAll(filename+"miridamgi");
		System.out.println( "신청하고 싶은 강좌를 선택하세요.");
		for(Odata data : odatas) {
			System.out.println(
					data.getId()
					+ " " + data.getName()
					+ " " + data.getProfessorname()
					+ " " + data.getCredit()
					+ " " + data.getTime());
		}
		String id = this.scanner.next();
		for(Odata data : odatas) {
			if(data.getId().equals(id)) {
			this.vsincheong.show(data,filename);
			} 
			}
			}
		else if(i==2) {
			String hakjum = this.cmiridamgi.hakjumhwakin(filename+"miridamgi");
			System.out.println("책가방에 담긴 총 학점은 : " + hakjum + "입니다.");
		   }
		System.out.println("기능을 선택하세요.");
		System.out.println("책가방[1], 강좌선택으로 돌아가기[2]");
		int g = 0;
		while(g==0) {
		g = this.scanner.nextInt();
		if(g==1) {
			p = 0;
		} else if(g==2){
			p = 1;
		} else {
			System.out.println("잘못입력하셨습니다.");
			g=0;
		  }
		}
	     } 
	   }	
     }
	
	

