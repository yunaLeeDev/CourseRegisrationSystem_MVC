package controller;

import java.util.Vector;

import dataAccessObject.Dindex;
import valueObject.Oindex;

public class Cindex {
	private Dindex dindex;
	public Cindex() {
		this.dindex = new Dindex();
	}

	public Vector<Oindex> readAll(String filename) {
		Vector<Oindex> indices = this.dindex.readAll(filename);
		return indices;
	}




}
