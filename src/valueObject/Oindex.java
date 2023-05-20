package valueObject;

import model.Mindex;

public class Oindex {
	private String id;
	private String name;
	private String ChildFileName;
	
	public void set(Mindex mindex) {
		this.setChildFileName(mindex.getChildFileName());
		this.setId(mindex.getId());
		this.setName(mindex.getName());
	}
	
	public String getId() {	return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getChildFileName() {return ChildFileName;}
	public void setChildFileName(String childFileName) {ChildFileName = childFileName;}

	public Oindex(){
		
	}
	
}
