package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.Mdata;
import model.Mmember;
import valueObject.Odata;
import valueObject.Omember;

public class Dhwdr {
	private static final String PATHNAME = "data";
	private Mmember mmember;
	private FileWriter filewriter;
	public void Dhwdr() {					
	}
	public Vector<Omember> readAll(String filename) {
		 Vector<Omember> vomembers = new Vector<Omember>();
	try {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		this.mmember = new Mmember();
		while(mmember.read(scanner)) {
				Omember vomember = new Omember();
				vomember.set(mmember);
				vomembers.add(vomember);
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return vomembers;
}
	public Omember read(String id) {
		try {
			File file = new File("lms"); 
			Scanner scanner = new Scanner(file);
			this.mmember = new Mmember();
			while(mmember.read(scanner)) {
				if(mmember.getId().equals(id)) {
					Omember vomember = new Omember();
					vomember.set(mmember);
					scanner.close();
					return vomember;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void write(Omember vomember) {
		try {
			File file = new File("lms"); 
			this.filewriter = new FileWriter(file,true);
			this.mmember = new Mmember();
			this.mmember.write(filewriter, vomember);	
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}