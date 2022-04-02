package part3.ex4.UI코드분리하기;

import java.util.Scanner;

public class ExamConsole {
	
	// Compositon Has A 일체형
//	private ExamList list = new ExamList();
	
	private ExamList list;
	
	public ExamConsole() {
		list = new ExamList();
	}

	public void printList() { //
		// size 넣지 않았을때 전부 출력해달라고하는 의미였어
//		printList(current);

		printList(list.size());
	}

	public void printList(int size) {
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();

		// int size = list.current;

		// 이렇게 임시변수에 담지 않으면, 매변수마다 exam.kor 작성해야한다.
		// 코드의 가독성이 떨어지기도하고 쳐야할 코드양도 많아지지.
		for (int i = 0; i < size; i++) {
			Exam exam = list.get(i);// ;

			int kor = exam.getKor(); // int kor = exam.kor;
			int eng = exam.getEng();
			int math = exam.getMath();

			int total = exam.total(); // int total = kor + eng + math;
			float avg = exam.avg(); // float avg = (float) total / 3;

			System.out.printf("국어: %d\n", kor);
			System.out.printf("영어: %d\n", eng);
			System.out.printf("수학: %d\n", math);

			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}

	public void inputList() {
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

		/*
		 * Exam exam = new Exam(); exam.setKor(kor);//exam.kor = kor;
		 * exam.setEng(eng);//exam.eng = eng; exam.setMath(math);//exam.math = math;
		 */

		Exam exam = new Exam(kor, eng, math);

		//////// add//////////////////////////////////////////////////////////////////////////////////////

		list.add(exam);

	}

}
