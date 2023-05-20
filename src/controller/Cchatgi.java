package controller;

import java.util.Vector;

import dataAccessObject.Ddata;
import dataAccessObject.Dhwdr;
import valueObject.Odata;
import valueObject.Omember;

public class Cchatgi {
	private Dhwdr dhwdr;
	public Cchatgi() {
		this.dhwdr = new Dhwdr();
	}

	public Vector<Omember> readAll(String filename) {
		Vector<Omember> vomembers = this.dhwdr.readAll(filename);
		return vomembers;
	}

}
