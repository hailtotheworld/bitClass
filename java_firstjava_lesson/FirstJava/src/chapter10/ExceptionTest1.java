package chapter10;

import java.util.Scanner;

public class ExceptionTest1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("나누어지는 수_피제수를 입력해주세요.>");
		int num1 = scanner.nextInt();
		System.out.println("나누는 수_제수를 입력해주세요.>");
		int num2 = scanner.nextInt();
		if (num2 == 0) {
			System.out.println("0으로 나눌수 없습니다.");
		} else {
			System.out.println(num1/num2);
		}
				
	}
}
