package ex16.star;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 별 한번 찍기
		System.out.printf("%c", '☆');
		System.out.println("\n------------------");

		// 별 10개 찍기
		for (int i = 0; i < 10; i++) {
			System.out.printf("%c", '☆');
		}

		System.out.println("\n------------------");

		// 별 10개 10번 찍기
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				System.out.printf("%c", '☆');
			}
			System.out.println();
		}

		System.out.println("\n------------------");

		/*
		 * ☆ ☆☆ ☆☆☆ ☆☆☆☆ ☆☆☆☆☆ ☆☆☆☆☆☆ ☆☆☆☆☆☆☆ ☆☆☆☆☆☆☆☆ ☆☆☆☆☆☆☆☆☆ ☆☆☆☆☆☆☆☆☆☆
		 */
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < j + 1; i++) {
				System.out.printf("%c", '☆');
			}
			System.out.println();
		}

		System.out.println("\n------------------");

		/*
		 * ☆☆☆☆☆☆☆☆☆☆ ☆☆☆☆☆☆☆☆☆ ☆☆☆☆☆☆☆☆ ☆☆☆☆☆☆☆ ☆☆☆☆☆☆ ☆☆☆☆☆ ☆☆☆☆ ☆☆☆ ☆☆ ☆
		 */
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10 - j; i++) {
				System.out.printf("%c", '☆');
			}
			System.out.println();
		}

		for (int i = 0; i < 5; i++) {
			if (i < 4)
				System.out.printf("%d,", 1 + 5 * i);
			else
				System.out.printf("%d", 1 + 5 * i);

		}

	}

}