package chaper02;

public class PersonMain {
	public static void main(String[] args) {
		
		// Person 클래스의 인스턴스 생성
		Person p = new Person();
		
		// p.memberName = "안녕히";
		p.setMemberName("안녕히");
		p.setPhoneNumber("010-7777-7777");
		p.setJuminNumber(991211111111L);
		
		System.out.println("이름:" + p.getMemberName());
		System.out.println("전화번호:" + p.getPhoneNumber());
		System.out.println("주민번호:" + p.getJuminNumber());
		
		System.out.println("------------------------------");
		p.printData();
		
		
	}

}
