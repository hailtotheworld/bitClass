package ver02;
/*
2. main()메소드를 아래의 요구조건을 정의해봅니다. 
 ① SmartPhone 클래스의 인스턴스를 생성합니다.
 ② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
 ③ 10번 반복해서 배열에 추가합니다.
 ④ 배열의 모든 요소를 출력합니다.
 ⑤ 배열의 모든 요소를 검색합니다.
 ⑥ 배열의 요소를 삭제해 봅시다.
 ⑦ 배열의 요소를 수정해 봅시다.
*/

public class SmartPhoneMain2 {
	public static void main(String[] args) {
		
//		 ① SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(10);
		
		while(true) {
			System.out.println("### 전화번호관리 프로그램 ###");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 검색(이름으로 검색)");
			System.out.println("3. 전화번호 삭제(이름으로 검색)");
			System.out.println("4. 전화번호 수정(이름으로 검색)");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 프로그램 종료");
			System.out.println("메뉴 선택하세요 >>>>>>>>>>>>>>>>> ");
			
			int select = Integer.parseInt(SmartPhone.scanner.nextLine());
			
			switch(select) {
			case 1:
				phone.insertContact();
				break;
			case 2:
				phone.searchPrint();
				break;
			case 3:
				phone.deleteContact();
				break;
			case 4:
				phone.editContact();
				break;				
			case 5:
				phone.printAllData();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				// return;
				System.exit(0);
			
			}
			
		}
				
		
		

		
	}

}
