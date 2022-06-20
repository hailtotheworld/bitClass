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

public class SmartPhoneMain {
	public static void main(String[] args) {
		
//		 ① SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(10);
		
//		 ② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
//		 ③ 10번 반복해서 배열에 추가합니다.
		for(int i=0;i<3;i++) {
			phone.insertContact();
		}
		
//		 ④ 배열의 모든 요소를 출력합니다.
		phone.printAllData();
		
//		 ⑤ 배열의 모든 요소를 검색합니다.
		phone.searchPrint();
		
//		 ⑥ 배열의 요소를 삭제해 봅시다.
		phone.deleteContact();
		
//		 ⑦ 배열의 요소를 수정해 봅시다.
		phone.editContact();
		
		// 삭제와 변경여부 확인
		phone.printAllData();
		
		
		
		
		

		
	}

}
