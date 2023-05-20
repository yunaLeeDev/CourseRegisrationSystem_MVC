package textview;

import java.util.Scanner;
import java.util.Vector;

import controller.Cchatgi;
import controller.Clecture;
import valueObject.Odata;
import valueObject.Omember;

public class Vchatgi {
	private Cchatgi cchatgi;
	private Scanner scanner;
	public Vchatgi(Scanner scanner) {
		this.scanner = scanner;
		this.cchatgi = new Cchatgi();
	}
	public void show() {
		String Filename = "lms";
		Vector<Omember> vomembers = this.cchatgi.readAll(Filename);
		System.out.println( "개인정보를 입력하세요.");	
		System.out.println( "이름 : ");
		String name = this.scanner.next();
		System.out.println( "학과 : ");
		String department = this.scanner.next();
		System.out.println( "주소 : ");
		String address = this.scanner.next();
		for(Omember member : vomembers) {
			if(member.getName().equals(name)) {			
				if(member.getDepartment().equals(department)) {
					if(member.getAddress().equals(address)) {
						System.out.println(
								"아이디 : " +
								member.getId()
								+ " " +
								"비밀번호 : " +
								member.getPassword()
								);
					} 
					else {
						System.out.println("잘못입력하셨습니다.");
						} 
					}
				}
			}
		}
	}

