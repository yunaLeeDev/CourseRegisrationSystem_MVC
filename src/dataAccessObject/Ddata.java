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

public class Ddata {
	private static final String PATHNAME = "data";
	private Mdata mdata;
	private Scanner scanner;
	public Vector<Odata> readAll(String filename) {
		 Vector<Odata> Odatas = new  Vector<Odata>();
	try {
		File file = new File(PATHNAME +"/"+ filename);
		this.scanner = new Scanner(file);
		this.mdata = new Mdata();
		while(mdata.readAll(scanner)) {
				Odata odata = new Odata();
				odata.set(mdata);
				Odatas.add(odata);
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Odatas;
}

	public void write(Odata odata, String filename) {
			try {
				File file1 = new File(PATHNAME +"/"+ filename);
				FileWriter fw = new FileWriter(file1, true);
				this.mdata = new Mdata();
				this.mdata.write(fw, odata);	
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		public void writeAll(Odata odata, String filename) {
			try {
				File file2 = new File(PATHNAME +"/"+ filename);
				FileWriter fw = new FileWriter(file2);
				this.mdata = new Mdata();
				this.mdata.write(fw, odata);	
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		public String hjhi(String filename) {
			int a = 0;			
				try {
					File f = new File(PATHNAME +"/"+ filename);
					this.scanner = new Scanner(f);
					this.mdata = new Mdata();
					while(mdata.readAll(scanner)) {
						a = Integer.parseInt(mdata.getCredit()) + a;
					}
					String b = Integer.toString(a);
					return b;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;		
		}
}

