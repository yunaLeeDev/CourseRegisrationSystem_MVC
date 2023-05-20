package textview;

import java.util.Scanner;

public class Vdoummal {
	
	private Scanner scanner;
		public Vdoummal(Scanner scanner) {
			this.scanner = scanner;
	}
	public void show() {
		int a = 0; 
		while(a==0) {
		System.out.println("도움이 필요한 부분을 선택하세요!");
		System.out.println("수강신청 이용안내[1], 책가방 이용 안내[2], 도움말 종료[3]");
			a = this.scanner.nextInt();
			if(a==1) {
				System.out.println("수강신청 버튼 클릭 > 캠퍼스 선택 > 소속대학 선택 > 소속학과 선택 > 강좌 선택 > 미리담기/바로 신청 결정");
				System.out.println("수강신청 계속 / 책가방 가기 선택지 결정");
				a = 0;
		} else if(a==2) {
			System.out.println("책가방 버튼 클릭 > 책가방 안에서 신청할 강좌 선택 > 초기화 후 신청 / 이어서 신청 결정");
			System.out.println("*신청할 시에도 초기화 후 신청 / 이어서 신청의 두가지 선택지가 주어짐*");
			a = 0;
		} else {
			if(a==3) {
			} else {
			System.out.println("잘못입력하셨습니다.");	
			a = 0;
			}
		}
		}
	}
}
