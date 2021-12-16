package ver02;

import java.util.Scanner;

public class smt1216 {
	
	// 객체배열 선언
	private Contact_study[] contact1;
	static Scanner sc = new Scanner(System.in);
	int curr;

	// 객체배열 생성
	public smt1216(int size) {
		contact1 = new Contact_study[size];
	}
	
	
	// 1.전화번호등록 (객체 배열에 값넣기)
	public void writeData() {
		System.out.println("이름을 입력해주세요>>");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력해주세요>>");
		String phonenumber = sc.nextLine();
		System.out.println("이메일을 입력해주세요>>");
		String email = sc.nextLine();
		System.out.println("주소를 입력해주세요>>");
		String address = sc.nextLine();
		System.out.println("생일을 입력해주세요>>");
		String birth = sc.nextLine();
		System.out.println("그룹을 입력해주세요>>");
		String group = sc.nextLine();

		contact1[curr++]= new Contact_study(name, phonenumber, email, address, birth, group);
		
	}
	
	// 2.전체목록보기
	public void seeData() {
		System.out.println("현재 등록된 인원은 "+curr+"명입니다.");
		
		for(int i=0; i<curr;i++) {
			contact1[i].printContact();
		}
	}
	
	// 이름을 인덱스로 바꿔주는 메서드가 필요해
	private int seeIndex(String name) {
		int index = -100;
		
		for(int i=0;i<curr;i++) {
			if(contact1[i].getName().equals(name)) {
			index = i;
			}
		}
		
		return index;

	}
	
	// 3.이름으로 검색
	public void searchName() {
		System.out.println("찾으려는 이름을 입력하세요>>");
		String name = sc.nextLine();
		
		if(seeIndex(name)<0) {
			System.out.println("찾는이름없음");
		} else {
			contact1[seeIndex(name)].printContact();
		}
		
	}
	
	
	// 4.이름으로 검색해서 수정
	public void upupName() {
		System.out.println("수정하시려는 이름을 입력하세요.");
		String name = sc.nextLine();
		
		if(seeIndex(name)<0) {
			System.out.println("찾는이름이 없습니다");
		} else {
			System.out.println("이름을 입력해주세요>>");
			String ename = sc.nextLine();
			System.out.println("전화번호를 입력해주세요>>");
			String phonenumber = sc.nextLine();
			System.out.println("이메일을 입력해주세요>>");
			String email = sc.nextLine();
			System.out.println("주소를 입력해주세요>>");
			String address = sc.nextLine();
			System.out.println("생일을 입력해주세요>>");
			String birth = sc.nextLine();
			System.out.println("그룹을 입력해주세요>>");
			String group = sc.nextLine();
			contact1[seeIndex(name)] = new Contact_study(ename, phonenumber, email, address, birth, group);
		}
	}
	
	// 5.이름으로 검색해서 삭제
	public void byeDate() {
		System.out.println("삭제하시려는 이름을 입력하세요.");
		String name = sc.nextLine();
		
		int index = seeIndex(name);
		
		if(seeIndex(name)<0) {
			System.out.println("찾는이름이 없습니다");
		} else {
			for (int i=index;i<curr-1;i++) {
				contact1[index] = contact1[index+1];
			}
			curr--;
			System.out.println(name+"의 정보가 삭제되었습니다.");
		}
	}

}







