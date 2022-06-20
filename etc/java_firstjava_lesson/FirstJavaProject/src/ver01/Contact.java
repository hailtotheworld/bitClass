package ver01;
/*
저장 정보: 이름 / 전화번호 / 이메일 / 주소 / 생일 / 그룹

기능: 위 데이터를 출력하는 기능 

추가 요구 사항:
변수들은 직접 참조를 막아 캡슐화 처리를 하도록 해봅시다. (private처리하자는 의미)
변수의 직접 참조는 안되지만 변수의 값을 얻을 수 있는 메소드(getter)와 변수에 값을 저장할 수 있는 메소드(setter)를 정의합니다.
인스턴스 생성과 함께 데이터를 초기화 할 수 있도록 생성자를 정의해봅시다.
저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성해봅시다.

실행 과정:
main()메소드를 정의합니다.
연락처 데이터를 저장하는 인스턴스를 생성합니다.
변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력합니다. (getter쓰라는 의미이다)
생성된 인스턴스의 정보 출력 메소드를 호출합니다. (기능 출력하라는거야)
인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다. (setter이용하라는 의미이다)
인스턴스의 출력메소드를 다시 실행합니다.
 */


// 저장정보캡슐화 -> getter,setter -> 생성자

public class Contact {
	
	// 저장 정보: 이름 / 전화번호 / 이메일 / 주소 / 생일 / 그룹
	// ★캡슐화: ★private 외부(다른 인스턴스)에서 변수를 직접 참조하지 못하도록 하는것 (정보은닉, 데이터를 보호하기 위한작업이다)
	private String name; 		// 이름
	private String phoneNumber; // 전화번호 010-0000-0000
	private String email; 		// 이메일
	private String address;     // 주소
	private String birthday;    // 생일 2021.10.22 20211022 2021-10-22
	private String group; 	    // 그룹
	
	// 생성자: 변수들을 초기화 할 때 사용한다.
	// shift+alt+s -> generate constructor using fields // super지워버려
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
//		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}

	// 생성자
	// shift+alt+s -> generate constructor using fields // super지워버려
	public Contact(String name, String phoneNumber) {
//		super();
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		this(name, phoneNumber, null,null,null,null);
	}

	// getter, setter 만들기. shift+alt+s
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	// 기능: 위 데이터를 출력하는 기능
	public void printContact() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("이메일: " + email);
		System.out.println("주소: " + address);
		System.out.println("생일: " + birthday);
		System.out.println("그룹: " + group);
	}

	// shift+alt+s -> generate toString (데이터확인용으로 사용하는거다)
	@Override
	public String toString() {
		return "contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
















