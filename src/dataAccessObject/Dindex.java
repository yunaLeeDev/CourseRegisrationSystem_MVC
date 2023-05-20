package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.Mindex;
import valueObject.Oindex;

public class Dindex {
		private static final String PATHNAME = "data";
		private Mindex mindex;
		public Vector<Oindex> readAll(String filename) {

			 Vector<Oindex> indices = new  Vector<Oindex>();
		try {
			File file = new File(PATHNAME + "/" + filename);
			Scanner scanner = new Scanner(file);
			this.mindex = new Mindex();
			while(mindex.readAll(scanner)) {
					Oindex oindex = new Oindex();
					oindex.set(mindex);	
					indices.add(oindex);
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indices;
	}
		
}
	

