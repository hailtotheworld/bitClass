package ex13.control2.continue_break;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		int n = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("값을 sp로 구분해서 5개 이상 입력하세요.");

		// 3 Enter, 34 5 6 234 345 54 45 Enter

		while (scan.hasNext()) {// hasNext() 현재위치에 다음데이터가 있나요?? next가 있으면 true, next없으면 false
			n = scan.nextInt();

			if(n<10) {
				continue; // 건너뛰기
			}
			
			if(n > 300) {
				break; // 끝내자
			}
			

			
			System.out.println(n);
		}
		
		
		

	}

}