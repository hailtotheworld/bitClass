package ch02;

import java.util.Scanner;

public class cScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 대 소 대 대  S s S S
		
		System.out.println("두자리정수를 입력해주세요");
		System.out.println(">");
		String input = scanner.nextLine();
		
		System.out.println("입력내용:"+input);
		
		
	}

}
