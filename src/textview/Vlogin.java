package textview;

import java.io.IOException;
import java.util.Scanner;

import controller.Chwdr;
import controller.Clogin;
import valueObject.Ologin;
import valueObject.Omember;

public class Vlogin {
	private Ologin ologin;
	private Clogin clogin;
	private Scanner scanner;
	private String id;
	public Vlogin(Scanner scanner) {
		this.ologin = new Ologin();
		this.scanner = scanner;
		this.clogin = new Clogin();
		
	}
	public Omember show() {
		System.out.println("아이디, 비밀번호를 입력하세요.");
		System.out.print("id : ");
		String id =  scanner.next();
		this.ologin.setId(id);
		System.out.print("password : ");
		String password = scanner.next();
		this.ologin.setPassword(password);
		Omember vomember = this.clogin.validate(ologin);
		if (vomember != null) {
		return vomember;	
		} else {
			System.out.print("아이디, 혹은 비밀번호가 틀렸습니다.");
		return null;
		}

		
	}

}
