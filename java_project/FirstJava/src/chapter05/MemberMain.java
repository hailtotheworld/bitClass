package chapter05;

public class MemberMain {
	public static void main(String[] args) {
		// 회원의 정보를 저장하는 프로그램
		// 데이터를 저장할 수 있는 구조(클래스) 만들었다!
		// Member 클래스로 인스턴스를 생성하면 데이터를 저장하는것과 같다!
		Member member1 = new Member("안녕히", "010-0001-0000", "경영", 1, "hi@hmail.com", "2000.01.05", "서울");

	// 객체의 정보(데이터들) 출력
		member1.showData();
	
	
	
	
	}

}
