package controller;

import java.io.IOException;

import dataAccessObject.Dhwdr;
import model.Mmember;
import valueObject.Ologin;
import valueObject.Omember;

public class Clogin {
	private Dhwdr dhwdr;
	public Clogin(){
	this.dhwdr = new Dhwdr();	
	}
	public void Chwdr() {
		
	}
	public Omember validate(Ologin ologin) {
		Omember vomember = this.dhwdr.read(ologin.getId());
		if (vomember != null) {
			if(ologin.getPassword().equals(vomember.getPassword())) {
				return vomember;
			}
		}
		return null;
	}
	
}
