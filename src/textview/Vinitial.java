package textview;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import valueObject.Odata;
import valueObject.Omember;

public class Vinitial {
	private Scanner scanner;
	private Vhwdr vhwdr;
	private Vlogin vlogin;
	private Vsgsc sgsc;
	private Vchatgi vchatgi;
	public Vinitial(Scanner scanner) {
		this.scanner = scanner;
		this.vhwdr = new Vhwdr(this.scanner);
		this.vlogin = new Vlogin(this.scanner);
		this.vchatgi = new Vchatgi(this.scanner);
	}
	public void show() {
		System.out.println("원하는 기능을 선택하세요.");
		System.out.println("로그인[1], 회원등록[2]");		
		int input = this.scanner.nextInt();
		if(input == 1) {
			Omember vomember = this.vlogin.show();
			if(vomember != null) {
				Vsgsc vsgsc = new Vsgsc(scanner);
				System.out.println(vomember.getName() + "님! 안녕하세요.");
				vsgsc.show(vomember);
				} else {
					System.out.println("원하는 기능을 선택하세요.");
					System.out.println("다시 시도[1], 아이디/비밀번호 찾기[2]");
					int a = 0; 				
					while (a == 0) {
						a = this.scanner.nextInt();
					if(a==1) {
					        this.show();
					            } 
					else if(a==2){
						vchatgi.show();
						this.show();
					  } else {
						  a = 0;
					  }
					     }		
					}
			}
		else if (input == 2){
			this.vhwdr.show();
			this.show();
		} 
			
	  }
    }
