package controller;

import java.util.Vector;

import dataAccessObject.Ddata;
import valueObject.Odata;

public class Clecture {

	private Ddata ddata;
	public Clecture() {
		this.ddata = new Ddata();
	}

	public Vector<Odata> readAll(String filename) {
		Vector<Odata> odatas = this.ddata.readAll(filename);
		return odatas;
	}

	public void writeAll(Odata olecture, String filename) {
		this.ddata.writeAll(olecture, filename);
		
	}
	public void write(Odata olecture, String filename) {
		this.ddata.write(olecture, filename);
	}

	public String hakjumhwakin(String filename) {
		String hakjum = this.ddata.hjhi(filename);
		return hakjum;
	}

	public boolean siganpyo(Odata olecture, String filename) {
		Vector<Odata> odatas = this.ddata.readAll(filename);
		int a = 0;
		for(Odata data : odatas) {
			if(data.getTime().equals(olecture.getTime())) {
				a = 1;
			} 
		}
		if(a==1) {
		return false;
		} 
		return true;
	}
}
