package textview;

import java.util.Scanner;
import java.util.Vector;

import controller.Cindex;
import valueObject.Oindex;

public class Vindex {
	private Scanner scanner;
	private Cindex ccampus;
	public Vindex(Scanner scanner) {
		this.scanner = scanner;
		this.ccampus = new Cindex();
	}
	public String show(String Filename, String message) {
		Vector<Oindex> indices = this.ccampus.readAll(Filename);
		System.out.println( message + "를 선택하세요.");
		for(Oindex index : indices) {
			System.out.println(index.getId()+ " " + index.getChildFileName());
		}
		String id = this.scanner.next();
		for(Oindex index : indices) {
			if(index.getId().equals(id)) {
				return index.getChildFileName();
			}
		}
		System.out.println("잘못입력하셨습니다.");
		return null;
	}

}
