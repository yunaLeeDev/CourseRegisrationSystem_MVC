package controller;

import java.io.IOException;

import dataAccessObject.Dhwdr;
import model.Mmember;
import valueObject.Omember;

public class Chwdr {
	private Dhwdr dhwdr;
	public Chwdr(){
	this.dhwdr = new Dhwdr();	
	}
	public void Chwdr() {
		
	}
	public Omember getmember() {
		return null;
	}
	public void setmember(Omember vomember) {
		this.dhwdr.write(vomember);
	}
}
