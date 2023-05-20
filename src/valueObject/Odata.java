package valueObject;

import model.Mdata;

public class Odata {
	private String id;
	private String name;
	private String professorname;
	private String credit;
	private String time;
	
	public Odata() {
		// TODO Auto-generated constructor stub
	}
	public void set(Mdata mdata) {
		this.setId(mdata.getId());
		this.setCredit(mdata.getCredit());
		this.setProfessorname(mdata.getProfessorname());
		this.setTime(mdata.getTime());
		this.setName(mdata.getName());

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
