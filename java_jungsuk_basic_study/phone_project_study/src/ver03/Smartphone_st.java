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

public class Smartphone_st {
	
	Scanner sc = new Scanner(System.in);
	
	private Contact_st[] contactArr;
	private int cnt;
	
	// 배열생성
	public void makeArr(int size) {
		contactArr = new Contact_st[size];
	}

	
	// 배열에 요소를 추가하는 메소드.
	public void addContract(Contact_st c) {
		contactArr[cnt++] = c;
		
	}
	
	
	// 전화번호 등록
	public void addData() {
		
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("전화번호을 입력하세요.");
		String phonenumber = sc.nextLine();
		
		addContract(new Contact_st(name, phonenumber));	
		
	}
	
	// 전화번호 검색
	
	// 전화번호 삭제
	
	// 전화번호 수정
	
	// 전화번호 전체출력
	public void printData() {
		System.out.println("현재 등록된 인원은"+cnt+"명입니다.");
		
		for(int i=0;i<cnt;i++) {
			contactArr[i].printAll();
		}
	}
	

}
