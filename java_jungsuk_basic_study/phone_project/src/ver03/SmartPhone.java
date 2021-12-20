package ver03;

import java.util.Scanner;

public class SmartPhone {
	
	//	①Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	//	②배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.
	
	private Contact[] contacts; // Contact 타입의 인스턴스를 저장하는 배열 선언
	private int cnt;			// 저장된 Contact 타입의 인스턴스 개수, 배열의 index로 사용
	
	public static Scanner sc = new Scanner(System.in); // 시작부터 끝날때까지 있어야 하니까 static 사용
		
	public SmartPhone(int size) {
		contacts = new Contact[size]; // 배열 생성
		cnt = 0;
	}
	
	// 배열에 요소를 추가하는 메소드 : 참조값을 전달받아 배열에 추가하는 기능
	public void addContact(Contact contact) { // 데이터를 반환하지 않으므로 void
		contacts[cnt++] = contact;
		System.out.println("데이터가 저장되었습니다.");
	}
	
	// 사용자로부터 데이터를 받아 Contact 객체를 생성하고 배열에 참조값을 저장 메소드 호출
	public void insertContact(int select) {
		System.out.println("연락처 등록을 시작합니다.....");
		System.out.println("이름 >>");
		String name = sc.nextLine();
		System.out.println("전화번호 >>");
		String phoneNumber = sc.nextLine();
		System.out.println("이메일 >>");
		String email = sc.nextLine();
		System.out.println("주소 >>");
		String address = sc.nextLine();
		System.out.println("생일 >>");
		String birth = sc.nextLine();
		System.out.println("그룹 >>");
		String group = sc.nextLine();
		
		if(select == 1) {
			System.out.println("회사이름을 입력하세요. >>");
			String companyName = sc.nextLine();
			System.out.println("부서이름을 입력하세요. >>");
			String divName = sc.nextLine();
			System.out.println("직급을 입력하세요. >>");
			String job = sc.nextLine();
			
			addContact(new CompanyContact(name, phoneNumber, email, address, birth, group, companyName, divName, job));

		} else { // select == 2
			
			System.out.println("거래처 회사이름을 입력하세요. >>");
			String companyName = sc.nextLine();
			System.out.println("거래품목을 입력하세요. >>");
			String product = sc.nextLine();
			System.out.println("담당자의 직급을 입력하세요. >>");
			String job = sc.nextLine();
			
			addContact(new CustomerContact(name, phoneNumber, email, address, birth, group, companyName, product, job));
			
		}
		
		
		// Contact c = new Contact(name, phoneNumber, email, address, birth, group);
		// addContact(c);
		
	}
	
	// 전체 데이터 출력: 배열은 반복문
	public void printAllData() {
		
		System.out.println("리스트를 출력합니다.("+cnt+"명)");
		System.out.println("============================");
		
		for(int i=0; i<cnt; i++) {
			contacts[i].printContact();
			System.out.println("----------------------");
		}
	}
	
	// 이름(문자열)을 전달 받아서 배열의 각 요소의 이름과 비교. 같은 요소가 있다면 해당 index 반환
	private int searchIndex(String name) {
		int index = -1; //index를 0으로 초기화하지 않는 이유: index는 0부터 시작하니까 가장 첫번째 요소가 나올수 있다. 
						// index는 마이너스가 나올수 없으니까 인위적으로 -1 준거임.
		
		// 배열의 요소를 반복해서 참조하고 이름과 비교 -> 찾으면 반복 종료 index
		for(int i=0;i<cnt;i++) {
			if(contacts[i].getName().equals(name)) {
				index = i;
				break; // 더이상 반복할 필요없다. for문을 벗어나는거야.
			}
		}
		
		return index;
	}
	
	// 이름으로 검색(index 찾기) -> 해당 데이터 출력
	public void searchPrint() {
		
		System.out.println("검색을 시작합니다.....");
		System.out.println("찾고자 하는 이름을 입력하세요.>>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			// 찾는 데이터가 없다
			System.out.println("찾으시는 이름 "+ name +"의 정보가 존재하지 않습니다.");
		} else {
			// 데이터 출력
			System.out.println("검색 결과입니다.");
			System.out.println("-----------------------");
			contacts[index].printContact();
			System.out.println("-----------------------");
		}
	}
	
	// 이름으로 검색 -> 해당 데이터 삭제
	public void deleteContact() {
		
		System.out.println("데이터 삭제를 시작합니다.....");
		System.out.println("삭제하고자하는 데이터의 이름을 입력하세요. >>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("삭제하고자 하는 이름 "+ name +"의 정보가 존재하지 않습니다.");
		} else {
			// 삭제 처리: index 위치의 참조값을 index+1 위치의 값으로 치환, 시프트
			for (int i=index;i<cnt-1;i++) {
				contacts[index] = contacts[index+1];
				cnt--; // 인스턴스를 참조하는게 없으면 그 데이터를 보는 방법은 없다.
			}
			System.out.println(name+"의 데이터가 삭제되었습니다.");
		}
	}
	
	// 이름으로 검색 -> 데이터 수정: 수정할 데이터를 받아서 처리
	public void editContact() {
		
		System.out.println("데이터 수정을 시작합니다.....");
		System.out.println("변경을 원하는 정보의 이름을 입력하세요>>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름 "+ name + " 의 정보가 존재하지 않습니다.");
		} else {
			System.out.println("데이터 수정을 위해 각각의 데이터를 입력하세요...");
			
			System.out.println("이름 >>");
			String ename = sc.nextLine();
			System.out.println("전화번호 >>");
			String phoneNumber = sc.nextLine();
			System.out.println("이메일 >>");
			String email = sc.nextLine();
			System.out.println("주소 >>");
			String address = sc.nextLine();
			System.out.println("생일 >>");
			String birth = sc.nextLine();
			System.out.println("그룹 >>");
			String group = sc.nextLine();
			
			// Contact c
			contacts[index].setName(ename);
			contacts[index].setPhoneNumber(phoneNumber);
			contacts[index].setEmail(email);
			contacts[index].setAddress(address);
			contacts[index].setBirth(birth);
			contacts[index].setGroup(group);
			
			System.out.println(name+"의 정보가 수정되었습니다.");
		}
 	}
	
	
	

}












