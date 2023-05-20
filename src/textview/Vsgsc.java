package textview;

import java.util.Scanner;
import java.util.Vector;

import valueObject.Odata;
import valueObject.Omember;

public class Vsgsc {
	private static final String RUTE_PATHNAME = "root";
	private Scanner scanner;
	private Vindex vcampus;
	private Vindex vcollege;
	private Vindex vdepartment;
	private Vlecture vlecture;
	private Vmiridamgi vmiridamgi;
	private Vsincheong vsincheong; 
	private Vdoummal vdoummal;
	public Vsgsc(Scanner scanner) {
		this.scanner = scanner;
		this.vcampus = new Vindex(this.scanner);
		this.vcollege = new Vindex(this.scanner);
		this.vdepartment = new Vindex(this.scanner);
		this.vlecture = new Vlecture(this.scanner);
		this.vmiridamgi = new Vmiridamgi(this.scanner);
		this.vsincheong = new Vsincheong(this.scanner);
		this.vdoummal = new Vdoummal(this.scanner);
	}

	public void show(Omember vomember) {
		System.out.println(vomember.getName() + "님 도와드릴까요?");
		System.out.println("네[1], 아니요[2]");
		int d = 0;
		while(d==0) {
			d = this.scanner.nextInt();
			if(d==1) {
				this.vdoummal.show();
			} else if(d==2){
			} else {
				d=0;
			}
		}
		
		int a=0;		
		while(a==0) {
			System.out.println("원하는 기능을 선택하세요.");
			System.out.println("강좌선택[0], 책가방가기[1]");
			a = this.scanner.nextInt();
				if(a==0) {
		String coliegeFile = this.vcampus.show(RUTE_PATHNAME,"캠퍼스");
		  if (coliegeFile != null) {
		     String departmentFile = this.vcollege.show(coliegeFile,"대학");
		       if (departmentFile != null) {
		    	   String lecturefile = this.vdepartment.show(departmentFile,"학과");
		    	   if(lecturefile != null) {
		            Odata olecture = this.vlecture.show(lecturefile, "강좌");
		            if(olecture != null) {
		         System.out.println("선택한 강좌를 어떻게 하시겠습니까?");
		         System.out.println("책가방 담기[1] 바로 신청하기[2]");
		 		int input = this.scanner.nextInt();
				if(input == 1) {
					this.vmiridamgi.sijak(olecture,vomember.getName());
					System.out.println(olecture.getName() + " 책가방에 담았습니다.");
					}
				else if (input == 2){
					this.vsincheong.show(olecture,vomember.getName());				
				} else {
				System.out.println("잘못 입력하셨습니다.");	
     			}
		             }
			       } 
		         }
		       }
		    }
				else if(a==1) {
					this.vmiridamgi.sinc(vomember.getName());					
			}	
		int h = 0;
		while (h != 1) {
		System.out.println("원하는 기능을 선택하세요");
         System.out.println("강좌선택 계속하기[0] 수강신청 종료하기[1]");	 
         h = this.scanner.nextInt();    
         if(h==0) {
				this.show(vomember);	        	 
         } else if(h==1){
        	 System.out.println("종료되었습니다.");
        	 //종료화면 생성하기
         } else {
        	 System.out.println("잘못입력하셨습니다.");
         }
		}
		}
	}
	}
