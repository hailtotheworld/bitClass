package part2.ex3.데이터구조화;

import java.util.Scanner;

public class ExamProgram {
	public static void main(String[] args) {
		
		Exam exam = new Exam(); // 실제 공간은 new Exam();을 해야지 만들어지는구나.(생성되는구나)
		
		input(exam);
		
		print(exam);
		
	}

	private static void print(Exam exam) {
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		
		// 이렇게 임시변수에 담지 않으면, 매변수마다 exam.kor 작성해야한다.
		// 코드의 가독성이 떨어지기도하고 쳐야할 코드양도 많아지지.
		int kor = exam.kor; 
		int eng = exam.eng;
		int math = exam.math;
		
		int total = kor+eng+math;
		float avg = (float) total / 3;
		
		
		System.out.printf("국어: %d\n", kor);
		System.out.printf("영어: %d\n", eng);
		System.out.printf("수학: %d\n", math);
		
		System.out.printf("총점 : %3d\n", total);
		System.out.printf("평균 : %6.2f\n", avg);
		System.out.println("────────────────────────");
		
	}

	private static void input(Exam exam) {
		Scanner scan = new Scanner(System.in);

		int kor,eng,math;

		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력    │");
		System.out.println("└──────────────────┘");
		System.out.println();


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
			
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;
		
	}

}