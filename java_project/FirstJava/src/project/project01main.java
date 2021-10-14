package project;

import java.util.Scanner;

import chapter05.Member;

public class project01main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		project01 project = new project01();
		
		System.out.println("이름을 입력해주세요.");
		System.out.print("> ");
		String name = new String(scanner.nextLine());
		
		System.out.println("전화번호를 입력해주세요.");
		System.out.print("> ");
		String phoneNumber = new String(scanner.nextLine());
		
		System.out.println("이메일 주소를 입력해주세요.");
		System.out.print("> ");
		String email = new String(scanner.nextLine());
		
		System.out.println("주소를 입력해주세요.");
		System.out.print("> ");
		String address = new String(scanner.nextLine());
		
		System.out.println("생일을 입력해주세요.");
		System.out.print("> ");
		String birthDay = new String(scanner.nextLine());
		
		System.out.println("그룹을 입력해주세요.");
		System.out.print("> ");
		String group = new String(scanner.nextLine());
			

		// 객체의 정보(데이터들) 출력
		project01.showData();
	}

}
