package test;

import java.util.*;

public class test1118_2 {
	public static void main(String[] args) {
		

	
	int num = 0;
	Scanner sc = new Scanner(System.in);
	
	outer:
	while(true) {
		System.out.println("1. 제곱");
		System.out.println("2. 루트씌워");
		System.out.println("3. 로그");
		System.out.println("99 누르면 프로그램 종료");
		
		int menu = sc.nextInt();
		
		
		if(menu==99) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		
		switch (menu) {

		case 1:
			System.out.println("제곱할 숫자를 입력하세요.>");
			num = sc.nextInt();
			System.out.println(num*num);
			break;
		case 2:
			System.out.println("루트씌울 숫자를 입력하세요.>");
			num = sc.nextInt();
			System.out.println(Math.sqrt(num));
			break;
		case 3:
			System.out.println("로그씌울 숫자를 입력하세요.>");
			num = sc.nextInt();
			System.out.println(Math.log(num));
		default:
			System.out.println("1~3 숫자만 입력하세요.");
			continue;
		}
	}

}
}
