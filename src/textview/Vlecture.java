package textview;

import java.util.Scanner;
import java.util.Vector;

import controller.Clecture;
import valueObject.Odata;

public class Vlecture {

	private Scanner scanner;
	private Clecture clecture;
	public Vlecture(Scanner scanner) {
		this.scanner = scanner;
		this.clecture = new Clecture();
	}
	public Odata show(String Filename, String message) {
		Vector<Odata> odatas = this.clecture.readAll(Filename);
		System.out.println( message + "를 선택하세요.");
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
				return data;			
			} 
		}
		System.out.println("잘못 입력하셨습니다.");
		return null;
	}


}
