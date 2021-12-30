package ver03;

import java.util.Scanner;

public class smartphone_st {
	
	Scanner sc = new Scanner(System.in);
	
	// 객체배열 선언
	private Contact_st[] conArr;
	private int curr;
		
	// 객체배열 생성(생성자)
	public smartphone_st(int size) {
		conArr = new Contact_st[size];
		curr = 0;
	}
	
	// 전화번호 등록
	public void addData() {
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력하세요");
		String phonenumber = sc.nextLine();
		
		conArr[curr++] = new Contact_st(name, phonenumber);
	}
	
	// 전화번호 전체조회
	public void printData() {
		System.out.println("현재 "+curr+"명 등록되어 있습니다.");
		for(int i=0;i<curr;i++) {
			conArr[i].printAll();
		}
	}
		
	//////////// 이름을 인덱스로 바꿔주는 메소드가 필요하다.
	private int searchIndex(String name) {
		int index = -1;
		
		for(int i=0;i<curr;i++) {
		if(conArr[i].getName().equals(name)) {
			index = i;
			break;
		}
				
		}
		return index;

	}
	
	//////////// 검색해서조회
	public void seeData() {
		System.out.println("검색할 이름을 입력하세요.>>");
		String name = sc.nextLine();
		
		
		if(searchIndex(name)<0) {
			System.out.println("찾으시는 "+name+"이름이 없습니다.");
		} else {
			conArr[searchIndex(name)].printAll();

		}
	
	}

	//////////// 검색해서수정
	public void editData() {
		System.out.println("수정할 이름을 입력하세요.>>");
		String name = sc.nextLine();
		
		
		if(searchIndex(name)<0) {
			System.out.println("찾으시는 "+name+"이름이 없습니다.");
		} else {
			System.out.println("수정할 이름을 입력하세요.>>");
			String ename = sc.nextLine();
			System.out.println("수정할 전화번호를 입력하세요.>>");
			String phonenumber = sc.nextLine();
			
			conArr[searchIndex(name)] = new Contact_st(ename, phonenumber);

		}

	}
	
	//////////// 검색해서삭제
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다.....");
		System.out.println("삭제하고자하는 데이터의 이름을 입력하세요. >>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("삭제하고자 하는 이름 "+ name +"의 정보가 존재하지 않습니다.");
		} else {
			
			for(int i=index;i<curr-1;i++) {
				conArr[i] = conArr[i+1];
			}
			
			curr--;
			
			System.out.println(name+"정보가 삭제되었습니다.");
			
		}
			
			
			
	}

	

	
	
	
	

}
