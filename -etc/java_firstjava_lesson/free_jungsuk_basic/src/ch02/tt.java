package ch02;

import java.util.Scanner;

public class tt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자입력해");
		System.out.println(">");
		
		String input = scanner.nextLine();
		
		System.out.println("입력값"+input);
		
		Integer.parseInt(input);
		
		
		System.out.println(input+500);
	}

}
