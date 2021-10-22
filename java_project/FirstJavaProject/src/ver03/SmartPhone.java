package ver03;

import java.util.Scanner;

/*
프로젝트-1 에서 정의한 Contact 클래스를 기반으로 아래 요구사항을 추가해서 프로그램을 작성 합니다. (프로젝트1패키지에서 Contact클래스 복사해와)
 
1. SmartPhone 클래스를 정의합니다. 이 클래스는 연락처 정보를 관리하는 클래스입니다. 
 ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
 ② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

2. main()메소드를 아래의 요구조건을 정의해봅니다. 
 ① SmartPhone 클래스의 인스턴스를 생성합니다.
 ② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
 ③ 10번 반복해서 배열에 추가합니다.
 ④ 배열의 모든 요소를 출력합니다.
 ⑤ 배열의 모든 요소를 검색합니다.
 ⑥ 배열의 요소를 삭제해 봅시다.
 ⑦ 배열의 요소를 수정해 봅시다.
*/
public class SmartPhone {

//	 ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
//	 ② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

	private Contact[] contacts; // Contact 타입의 인스턴스를 저장하는 배열 선언 (배열의 묶음을 가지는 참조변수이다)
	private int cnt; // 저장된 Contact 타입의 인스턴스 개수, 배열의 index로 사용

	public static Scanner scanner = new Scanner(System.in);
	// 시작부터 끝날때까지(시작할거야?종료할거야?물을때도쓰자나) 스캐너 써야하니까 static 써줌.
	// 메인 뿐만 아니라 여기저기에서 다쓰니까 static붙히자.

	public SmartPhone(int size) {
		contacts = new Contact[size]; // 배열 생성
		cnt = 0; // 안해도되지만 명시적으로 초기화해둬.
	}

	// 배열에 요소를 추가하는 메소드: 참조값을 전달 받아 배열에 추가하는 기능
	public void addContact(Contact contact) {
		contacts[cnt++] = contact;
	}

	// 사용자로부터 데이터를 받아 Contact 객체를 생성하고 배열에 참조값을 저장 메소드 호출
	public void insertContact(int select) {
		System.out.println("연락처 등록을 시작합니다.....");
		System.out.println("이름 >>");
		String name = scanner.nextLine();

		System.out.println("전화번호 >>");
		String phoneNumber = scanner.nextLine();

		System.out.println("이메일 >>");
		String email = scanner.nextLine();

		System.out.println("주소 >>");
		String address = scanner.nextLine();

		System.out.println("생일 >>");
		String birthday = scanner.nextLine();

		System.out.println("그룹 >>");
		String group = scanner.nextLine();

		if(select==1) {
			
			System.out.println("회사이름을 입력하세요. >>");
			String companyName = scanner.nextLine();
			System.out.println("부서이름을 입력하세요. >>");
			String divName = scanner.nextLine();
			System.out.println("직급을 입력사세요. >>");
			String job = scanner.nextLine();
			
			addContact(new CompanyContact(name, phoneNumber, email, address, birthday, group, companyName, divName, job));


			
		} else { // select ==2
			
			System.out.println("거래처 회사이름을 입력하세요. >>");
			String companyName = scanner.nextLine();
			System.out.println("거래품목을 입력하세요. >>");
			String product = scanner.nextLine();
			System.out.println("담당자의 직급을 입력하세요. >>");
			String job = scanner.nextLine();
			
			addContact(new CustomerContact(name, phoneNumber, email, address, birthday, group, companyName, product, job));
			
			
		}
		
		// Contact c = new Contact(name, phoneNumber, email, address, birthday, group);
		// addContact(c);
		// addContact(new Contact(name, phoneNumber, email, address, birthday, group));
		


	}

	// 전체 데이터 출력 : 배열은 반복문이다.
	public void printAllData() {

		System.out.println("리스트를 출력합니다.(" + cnt + "명)");
		System.out.println("=========================");

		for (int i = 0; i < cnt; i++) {
			contacts[i].printContact();
			System.out.println("-----------------");
		}
	}
	
	// 이름(문자열)을 전달 받아서 배열에서 배열의 각 요소의 이름과 비교 같은 요소가 있으면 해당 index 반환
	private int searchIndex(String name) {
		int index = -1;

		// 배열의 요소를 반복해서 참조하고 이름가 비교 -> 찾으면 반복 종료 index
		for (int i = 0; i < cnt; i++) {
			if (contacts[i].getName().equals(name)) { // private되있기떄문에 getName()해야해
				index = i;
				break;
			}
		}

		return index;
	}

	// 이름으로 검색(이름으로 검색하기 핵심은 index 찾기) -> 해당 데이터 출력
	public void searchPrint() {

		System.out.println("검색을 시작합니다.....");
		System.out.println("찾고자 하는 이름을 입력하세요. >>");
		String name = scanner.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			// 찾는 데이터가 없다.
			System.out.println("찾으시는 이름 " + name + "의 정보가 존재하지 않습니다.");
		} else {
			// 데이터 출력
			System.out.println("검색 결과 입니다.");
			System.out.println("-------------------------------");
			contacts[index].printContact();
			System.out.println("-------------------------------");
		}
	}

	// 이름으로 검색 -> 해당 데이터 삭제
	public void deleteContact() {
		
		System.out.println("데이터 삭제를 시작합니다.....");
		System.out.println("삭제하고자하는 데이터의 이름을 입력하세요. >");
		String name = scanner.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("삭제하고자 하는 이름 " + name + "의 데이터가 존재하지 않습니다.");
		} else {
			// 삭제 처리: index 위치의 참조값을 index+1 위치의 값으로 치환, 시프트
			for(int i=index; i<cnt-1;i++) {
				contacts[index] = contacts[index+1];
				cnt--;
			}
			
			System.out.println(name + "의 데이터가 삭제되었습니다.");
			
		}
		
	}

	// 이름으로 검색해서 데이터 수정해보기: 사용자에게 수정할 데이터를 받아서 처리
	public void editContact() {
		
		System.out.println("데이터 수정을 시작합니다.....");
		System.out.println("변경을 원하는 정보의 이름을 입력하세요. >>");
		String name = scanner.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름 " + name + " 의 정보가 존재하지 않습니다.");
		} else {
			System.out.println("데이터 수정을 위해 각각의 데이터를 입력하세요.....");
			System.out.println("이름 >>");
			String ename = scanner.nextLine(); // name이 지역변수 중복된다. 그래서 ename으로 수정했어

			System.out.println("전화번호 >>");
			String phoneNumber = scanner.nextLine();

			System.out.println("이메일 >>");
			String email = scanner.nextLine();

			System.out.println("주소 >>");
			String address = scanner.nextLine();

			System.out.println("생일 >>");
			String birthday = scanner.nextLine();

			System.out.println("그룹 >>");
			String group = scanner.nextLine();
			
			// Contact c
			contacts[index].setName(ename);
			contacts[index].setPhoneNumber(phoneNumber);
			contacts[index].setEmail(email);
			contacts[index].setAddress(address);
			contacts[index].setBirthday(birthday);
			contacts[index].setGroup(group);
			
			System.out.println(name + " 의 정보가 수정되었습니다.");
		}
	}

}












