package model;

import java.util.Scanner;

public class Mindex {
	private String id;
	private String name;
	private String ChildFileName;
	public Mindex() {
		
	}
	public boolean readAll(Scanner scanner) {
		if(scanner.hasNext()) {
			this.setId(scanner.next());
			this.setName(scanner.next());
			this.setChildFileName(scanner.next());
		return true;
		
	}
		return false;
	}
	public String getId() {	return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getChildFileName() {return ChildFileName;}
	public void setChildFileName(String childFileName) {ChildFileName = childFileName;}

}
