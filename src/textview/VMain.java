package textview;

import java.util.Scanner;


public class VMain {
	private Vinitial initial;
	public VMain(Scanner scanner) {
		this.initial = new Vinitial(scanner);
	}
	public void run() {
		this.initial.show();
	
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			VMain main = new VMain(scanner);
			main.run();
			scanner.close();
		
	}

}
