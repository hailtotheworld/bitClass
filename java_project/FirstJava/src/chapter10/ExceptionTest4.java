package chapter10;

import java.util.Scanner;

public class ExceptionTest4 {
	
	public static void main(String[] args) {
		
		int[] arr = new int[3];
		
		try {
		//  배열 인덱스를 잘못 처리한 경우
		System.out.println(arr[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생!!!");
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("프로그램을 종료합니다.");

				
	}
}
