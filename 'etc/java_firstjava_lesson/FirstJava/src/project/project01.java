package project;

import java.util.Scanner;

public class project01 {
	private String name;		// 이름
	private String phoneNumber; // 전화번호
	private String email;		// 이메일
	private String address;		// 주소
	private String birthday;	// 생일
	private String group;		// 그룹
	
	
	// getter, setter 생성 (단축키 Shift Alt S)
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
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
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
	
	// 기본 생성자
	public project01() {
	}
		
	// 기본 생성자
	public project01(String name, String phoneNumber, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	

	public void showData() {
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("이메일: " + this.email);
		System.out.println("주소: " + this.address);
		System.out.println("생일: " + this.birthday);
		System.out.println("그룹: " + this.group);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		project01 p = new project01();
		
		System.out.println("이름: " + p.getName());
		System.out.println("전화번호: " + p.phoneNumber);
		System.out.println("이메일: " + p.email);
		System.out.println("주소: " + p.address);
		System.out.println("생일: " + p.birthday);
		System.out.println("그룹: " + p.group);
		
		System.out.println("이름을 입력하십시오.>");
		p.setName(scanner.nextLine());
		
		System.out.println("전화번호를 입력하십시오.>");
		p.setPhoneNumber(scanner.nextLine());
		
		System.out.println("이메일을 입력하십시오.>");
		p.setemail(scanner.nextLine());
		
		System.out.println("주소를 입력하십시오.>");
		p.setAddress(scanner.nextLine());
		
		System.out.println("생일을 입력하십시오.>");
		p.setBirthday(scanner.nextLine());
		
		System.out.println("그룹을 입력하십시오.>");
		p.setGroup(scanner.nextLine());
		
		// 입력받은 값을 출력
		System.out.println("이름: " + p.getName());
		System.out.println("전화번호: " + p.phoneNumber);
		System.out.println("이메일: " + p.email);
		System.out.println("주소: " + p.address);
		System.out.println("생일: " + p.birthday);
		System.out.println("그룹: " + p.group);


		
		
	}

	
	

}
	






