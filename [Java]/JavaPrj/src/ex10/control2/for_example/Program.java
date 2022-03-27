package ex10.control2.for_example;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 1~10까지 더한 숫자를 구하라.
		int total = 0;

		for (int i = 0; i < 10; i++) {
			total += i+1;
		}
		
		System.out.printf("total is %d\n", total);
		
		
		// 3부터 7까지 더한 숫자를 구하라.
		int total2 = 0;
		
		for (int i=0;i<5;i++) {
			total2 += i+3;
		} 
		
		System.out.printf("total2 is %d\n", total2);
		
		// 3부터 7까지 더한 숫자를 구하라(함수이용)
		// n*(a+l)/2
		int total3 = 5*(3+7)/2;

		System.out.printf("total3 is %d\n", total3);
	}

}