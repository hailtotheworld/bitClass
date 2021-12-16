package ver01;

public class ContactMain {
	public static void main(String[] args) {
		
		// 인스턴스 생성 => new 클래스이름 -> 클래스() 생성자 호출
		Contact c1 = new Contact("손흥민", "010-0000-0000", "hi@gmail.com", "서울시", "20211010", "친구");
		Contact c2 = new Contact("김두한", "010-2111-0222");
		Contact c3 = new Contact();
		
		// getter 메소드를 이용해서 출력
		// 저장된 데이터를 가져오는 방법 -> 참조변수.메소드이름()
		System.out.println("이름: "+c1.getName());
		System.out.println("이름: "+c2.getName());
		
		System.out.println("-----------------------------------");
		
		// 저장된 전체 데이터 출력
		c1.printContact();
		c2.printContact();
		
		System.out.println("-----------------------------------");

		// 데이터 변경: setter 메소드를 이용해서 변경
		
		c2.setEmail("set@ggg.com");
		c2.setAddress("런던");
		c2.setBirth("2000-01-01");
		c2.setGroup("직장");
		
		System.out.println("데이터 변경(추가)");
		c2.printContact();
		
	}

}
