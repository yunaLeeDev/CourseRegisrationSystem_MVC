package textview;

import java.util.Scanner;

import controller.Chwdr;
import valueObject.Omember;

public class Vhwdr {
	private Omember omember;
	private Chwdr chwdr;
	private Scanner scanner;
	public Vhwdr(Scanner scanner) {
		this.scanner = scanner;
		this.omember = new Omember();
		this.chwdr = new Chwdr();
	}
	public void show() {
		System.out.println("개인정보를 입력하세요.");
		System.out.print("id : ");
		String id =  scanner.next();
		omember.setId(id);
		System.out.print("password : ");
		String password = scanner.next();
		omember.setPassword(password);
		System.out.print("이름 : ");
		String name = scanner.next();
		omember.setName(name);
		System.out.print("주소 : ");
		String address = scanner.next();
		omember.setAddress(address);
		System.out.print("학과 : ");
		String department = scanner.next();
		omember.setDepartment(department);	
		this.chwdr.setmember(this.omember);
	}

}
