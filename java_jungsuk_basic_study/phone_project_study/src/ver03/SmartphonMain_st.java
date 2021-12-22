package ver03;

import java.util.Scanner;

//1. 회사 동료 전화번호 등록
//2. 고객사 담당자 전화번호 등록
//3. 전화번호 검색 (이름으로 검색)
//4. 전화번호 삭제 (이름으로 검색)
//5. 전화번호 수정 (이름으로 검색)
//6. 전화번호 전체 출력
//7. 프로그램 종료
//메뉴 선택하세요 >>>>>>>>>>>>>>> 

public class SmartphonMain_st {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Smartphone_st phone = new Smartphone_st();
		
		phone.makeArr(10);
		
		
		
		while(true) {

			System.out.println("전화프로그램");
			System.out.println("1. 전화번호 추가");
			System.out.println("6. 전체목록보기");
			System.out.println("7. 프로그램 종료");
			
			
		int select = sc.nextInt();

		switch(select) {
				
		case 1:
			phone.addData();
			break;
		
		case 6:
			phone.printData();
			break;
		
		case 7:
			System.exit(0);
			
			
		
		}
		
		
		}

	}
	

}
