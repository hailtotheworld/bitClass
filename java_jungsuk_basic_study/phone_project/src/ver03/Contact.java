package ver03;

public class Contact {

//	저장 정보
//  이름, 전화번호, 이메일, 주소, 생일, 그룹

	// 캡슐화: 외부(다른 인스턴스)에서 변수를 직접 참조하지 못하도록 하는것이다. 정보은닉. 데이터타입 앞에 private 접근제어자 붙힌다.
	private String name; 		 // 이름
	private String phoneNumber;  // 전화번호: 010-0000-0000
	private String email;		 // 이메일
	private String address;		 // 주소
	private String birth; 		 // 생일: 2021-10-21 or 2021.10.21
	private String group; 		 // 그룹
	
	// 생성자는 보통 변수 밑에 둔다. 메서드들이랑 같이두면 햇갈릴수도 있으니까.
	// 생성자 : 멤버 변수들을 초기화 할 때 사용
	public Contact(String name, String phoneNumber, String email, String address, String birth, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.group = group;
	}
	
	// 생성자 내에서 다른 생성자를 호출할 때 사용하는 this()
	// 생성자의 이름으로 클래스이름 대신 this를 사용한다.
	// 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.
	public Contact(String name, String phoneNumber) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		this(name, phoneNumber, null, null, null, null);
	}
		
	public Contact() {
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
		
//	  기능: 위 데이터를 출력하는 기능 (UI측면)
	public void printContact() { // void를 사용한 이유는 반환값이 기본형이 아니기 때문이다
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("이메일: " + email);
		System.out.println("주소: " + address);
		System.out.println("생일: " + birth);
		System.out.println("그룹: " + group);
	}

	@Override // 데이터 잘 들어갔는지 확인할 수 있다.
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birth=" + birth + ", group=" + group + "]";
	}
	

}








