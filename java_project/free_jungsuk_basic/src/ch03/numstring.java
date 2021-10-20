package ch03;

import java.util.Scanner;

public class numstring {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';

		
		System.out.println("문자를 하나 입력하세요.>");
		
		String input = scanner.nextLine();
		ch = input.charAt(0);

		
		if('0' <= ch && '9' >= ch) {
			System.out.println("숫자입니다.");
		} else if(('a' <= ch && 'z' >= ch) || ('A' <= ch && 'Z' >= ch)) {
			System.out.println("문자입니다.");
		}
		
	

	}

}
