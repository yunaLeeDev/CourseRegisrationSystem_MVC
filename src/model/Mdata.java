package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.Odata;
import valueObject.Omember;

public class Mdata {

	private String id;
	private String name;
	private String professorname;
	private String credit;
	private String time;	
	public Mdata() { 
		
	}
	public boolean readAll(Scanner scanner) {
		if(scanner.hasNext()) {
			this.setId(scanner.next());
			this.setName(scanner.next());
			this.setProfessorname(scanner.next());
			this.setCredit(scanner.next());
			this.setTime(scanner.next());
		return true;
		}
		return false;
	}
	
	public void write(FileWriter filewriter, Odata odata) {
		try {
			this.set(odata);
			filewriter.write("\r\n");
			filewriter.write(this.id+" ");
			filewriter.write(this.name+" ");
			filewriter.write(this.professorname+" ");
			filewriter.write(this.credit+" ");
			filewriter.write(this.time);	
			filewriter.write("\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		private void set(Odata odata) {
			this.setCredit(odata.getCredit());
			this.setProfessorname(odata.getProfessorname());
			this.setId(odata.getId());
			this.setName(odata.getName());
			this.setTime(odata.getTime());
			
		}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessorname() {
		return professorname;
	}
	public void setProfessorname(String professorname) {
		this.professorname = professorname;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}



}
