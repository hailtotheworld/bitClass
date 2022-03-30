package part3.ex1.캡슐화;

import java.util.Scanner;

public class ExamList {
	Exam[] exams1;
	int current;
		
	// 현재 배우고 있는 캡슐은 완전한 객체지향의 형태를 가지고 있는 캡슐은 아니고
	// 구조적인 프로그래밍에서의 과도기적인 캡슐이라 생각하고 봐봐.
	
	static void printList(ExamList list) {
		printList(list, list.current);
	}
	
	static void printList(ExamList list, int size) {
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();

		// int size = list.current;
		Exam[] exams = list.exams;

		// 이렇게 임시변수에 담지 않으면, 매변수마다 exam.kor 작성해야한다.
		// 코드의 가독성이 떨어지기도하고 쳐야할 코드양도 많아지지.
		for (int i = 0; i < size; i++) {
			Exam exam = exams[i];

			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			int total = kor + eng + math;
			float avg = (float) total / 3;

			System.out.printf("국어: %d\n", kor);
			System.out.printf("영어: %d\n", eng);
			System.out.printf("수학: %d\n", math);

			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}

	static void inputList(ExamList list) {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력    │");
		System.out.println("└──────────────────┘");
		System.out.println();

		int kor, eng, math;

		do {
			System.out.printf("국어: ");
			kor = scan.nextInt();

			if (kor < 0 || 100 < kor) {
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (kor < 0 || 100 < kor);

		do {
			System.out.printf("영어: ");
			eng = scan.nextInt();

			if (eng < 0 || 100 < eng) {
				System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (eng < 0 || 100 < eng);

		do {
			System.out.printf("수학: ");
			math = scan.nextInt();

			if (math < 0 || 100 < math) {
				System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (math < 0 || 100 < math);

		Exam exam = new Exam();
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;

//		if(exams의 공간이 없다면) {
//			공간을 늘려주기
//		}

		Exam[] exams = list.exams;
		int size = list.current;

		// 만약에 공간이 모자라면
		if (exams.length == size) {
			// 1. 크기가 더 큰 새로운 배열을 생성하시오.
			Exam[] temp = new Exam[exams.length + 5];

			// 2. 값을 이주시키기
			for (int i = 0; i < size; i++) {
				temp[i] = exams[i];
			}
			
			// 3. list.exams가 새로만든 temp 배열을 참조하도록 한다.
			exams = temp;

		}

		exams[list.current] = exam;
		list.current++;

	}

}
