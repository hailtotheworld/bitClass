package ex17.test;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// A,B,C,D,E
		for (int i = 0; i < 5; i++)
			if (i == 4) // if에 특별한 경우를 작성하자.
				System.out.printf("%c", 'A' + i);
			else // else가 기본값이다.
				System.out.printf("%c,", 'A' + i);

		System.out.println("\n------------------------");

		// ,B, ,D,E
		for (int i = 0; i < 5; i++)
			if (i == 4)
				System.out.printf("%c", 'A' + i);
			else if (i % 2 == 0)
				System.out.printf(" ,");
			else
				System.out.printf("%c,", 'A' + i);

		System.out.println("\n------------------------");

		// ,B, ,D, ,
		for (int i = 0; i < 5; i++)
			if (i % 2 == 0)
				System.out.printf(" ,");
			else if (i == 4)
				System.out.printf("%c", 'A' + i);
			else
				System.out.printf("%c,", 'A' + i);

		System.out.println("\n------------------------");

		// 1 2 3
		// 4 5 6
		// 7 8 9

		for (int i = 0; i < 9; i++) {
			if (i % 3 == 2)
				System.out.printf("%d\n", i + 1);
			else
				System.out.printf("%d ", i + 1);
		}

		System.out.println("\n------------------------");

		// 1 2 3
		// 4 5 6
		// 7 8 9 (중첩 for문 사용)

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				System.out.printf("%d ", (3 * j) + i + 1);
			}
			System.out.println();
		}

	}

}