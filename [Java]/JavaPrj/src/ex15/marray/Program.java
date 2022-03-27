package ex15.marray;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

//		int kor1, kor2, kor3;
		int[] kors = new int[3 * 3];
		int total = 0;
		float avg = 0;
		int menu;// 변수에 의미를 담아라

		Scanner scan = new Scanner(System.in);

//		kor1 = 0; // 기본값의 의미이다. 입력값을 받으면 기본값이 입력값으로 대체된다.
//		kor2 = 0;
//		kor3 = 0;

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				kors[3 * j + i] = 0; // 초기화하는 방법.
			}
		}

		종료: while (true) {
			// ------ 메인 메뉴 부분 ---------------------------------------
			System.out.println("┌──────────────────────┓");
			System.out.println("│        메인 메뉴               │");
			System.out.println("└──────────────────────┘");
			System.out.println("\t1.성적입력");
			System.out.println("\t2.성적출력");
			System.out.println("\t3.종료");
			System.out.println("\t>"); // 프롬프트
			menu = scan.nextInt();

			switch (menu) {

			case 1: // 중괄호가 필요없다. 종속절이 아니기 때문이다.
				// ------ 성적 입력 부분 ---------------------------------------
				System.out.println("┌──────────────────────┓");
				System.out.println("│        성적 입력               │");
				System.out.println("└──────────────────────┘");

//				do {
//					System.out.print("국어1:");
//					kor1 = scan.nextInt();
//
//					if (kor1 < 0 || 100 < kor1)
//						System.out.println("성적범위(0~100)를 벗어났습니다.");
//
//				} while (kor1 < 0 || 100 < kor1);
//
//				do {
//					System.out.print("국어2:");
//					kor2 = scan.nextInt();
//
//					if (kor2 < 0 || 100 < kor2)
//						System.out.println("성적범위(0~100)를 벗어났습니다.");
//
//				} while (kor2 < 0 || 100 < kor2);
//				
//				do {
//					System.out.print("국어3:");
//					kor3 = scan.nextInt();
//
//					if (kor3 < 0 || 100 < kor3)
//						System.out.println("성적범위(0~100)를 벗어났습니다.");
//
//				} while (kor3 < 0 || 100 < kor3);

				for (int j = 0; j < 3; j++) {
					for (int i = 0; i < 3; i++) {
						do {
							System.out.printf("%d학년 국어%d:", j + 1, i + 1);
							kors[3 * j + i] = scan.nextInt();

							if (kors[3 * j + i] < 0 || 100 < kors[3 * j + i])
								System.out.println("성적범위(0~100)를 벗어났습니다.");

						} while (kors[3 * j + i] < 0 || 100 < kors[3 * j + i]);
					}
				}

				break;

			case 2:
				// ------ 성적 출력 부분 ---------------------------------------
//				total = kor1 + kor2 + kor3;
				System.out.println("┌──────────────────────┓");
				System.out.println("│        성적 출력               │");
				System.out.println("└──────────────────────┘");

				for (int j = 0; j < 3; j++) {
					System.out.printf("<%d학년 국어성적>---------\n", j + 1);

					for (int i = 0; i < 3; i++) {
						System.out.printf("\t국어%d: %3d\n", i + 1, kors[3 * j + i]);
						total += kors[j * 3 + i];
						avg = (float) total / 3;
					}

					System.out.printf("\t총점 : %3d\n", total);
					System.out.printf("\t평균 : %6.2f\n", avg);
					System.out.println("────────────────────────");

				}

				break; // while을 벗어나지 못하고 switch문만 벗어난다.

			case 3:
//				System.exit(0); // 프로세스를 종료시킨다. 프로그램으로강제종료시킨거라 바람직하지 않다.
				break 종료; // 라벨을 붙혀서 라벨이 있는곳까지 벗어난다..!

			default:
				System.out.println("입력 오류 1~3 까지만 입력할 수 있습니다.");

			}

		}
		System.out.println("good bye~");

	}

}