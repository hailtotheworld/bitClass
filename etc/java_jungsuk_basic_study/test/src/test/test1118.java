package test;

import java.util.*;

public class test1118 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum=0;
		
		System.out.println("숫자를 입력해주세요.");
		System.out.println(">");
		int num = sc.nextInt();
		
//		for (; num>0; num/=10) {
//			sum += num%10;
//
//			System.out.println("sum="+sum);
//
//		}
		
		while(num>0) {
			sum+=num%10;
			
			System.out.println("sum="+sum);
			num/=10;

			
		}
		
		System.out.println("각 자리 더한 값은"+sum+"이다.");

		
		
		
	}

}
