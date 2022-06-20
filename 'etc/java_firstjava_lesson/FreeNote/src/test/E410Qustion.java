package test;

import java.util.Scanner;

public class E410Qustion {
	public static void main(String[] args) {
		
		// 생성자
		int answer = (int) (Math.random()*100+1);
		int count = 0;
		int input = 0;
		
		// 스캐너
		Scanner sc = new Scanner(System.in);
		
		// do while
		do {
			count++;
			System.out.println("숫자를 입력해주세요.>>");
			input = sc.nextInt();
			
			if(answer > input) {
				System.out.println("값이 작습니다.");
			} else if(answer < input) {
				System.out.println("값이 큽니다.");
			} else if(answer == input) {
				System.out.println("정답입니다.");
				break;
			}
		} while(true);
		
		
		
		System.out.println("시도횟수:"+count);
		System.out.println("정답숫자:"+answer);
		
		
	}

} 