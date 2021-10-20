package chapter10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("나누어지는 수_피제수를 입력해주세요.>");
		int num1 = scanner.nextInt();
		System.out.println("나누는 수_제수를 입력해주세요.>");
		int num2 = scanner.nextInt();
		
		try {
			System.out.println(num1/num2);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나누기를 할 수 없습니다.");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("오류발생");
		}
		
		System.out.println("프로그램을 종료합니다.");

				
	}
}
