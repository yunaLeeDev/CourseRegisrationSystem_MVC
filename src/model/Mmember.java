package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.Omember;

public class Mmember {
		private String id;
		private String password;
		private String address;
		private String department;
		private String name;
	public Mmember() {	
	}
	public boolean read(Scanner scanner) {
		if(scanner.hasNext()) {
			this.setId(scanner.next());
			this.setPassword(scanner.next());
			this.setName(scanner.next());
			this.setAddress(scanner.next());
			this.setDepartment(scanner.next());
			return true;
		}
		return false;
	}	
	private void set(Omember vomember) {
		this.setAddress(vomember.getAddress());
		this.setDepartment(vomember.getDepartment());
		this.setId(vomember.getId());
		this.setName(vomember.getName());
		this.setPassword(vomember.getPassword());
		
	}	
	public void write(FileWriter filewriter, Omember vomember) {
	try {
		this.set(vomember);
		filewriter.write("\r\n");
		filewriter.write(this.id + "\n");
		filewriter.write(this.password + "\n");
		filewriter.write(this.name + "\n");
		filewriter.write(this.address + "\n");
		filewriter.write(this.department + "\n");	
		filewriter.write("\r\n");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}




}
