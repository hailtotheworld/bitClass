package part3.ex2.메소드;

import java.util.Scanner;

public class ExamList {
	Exam[] exams;
	int current;
	
	// 캡슐화의 가장 큰 장점은 데이터구조의 변화, 오류가 캡슐 안에서만 발생한다는 것이다!

	void printList() { //
		printList(current);
	}
	
	static void printList(ExamList list) { //
		printList(list, list.current);
	}
	
	void printList(int size) {
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();

		// int size = list.current;
		Exam[] exams = this.exams;

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
	
	void inputList() {
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

		Exam[] exams = this.exams;
		int size = current;

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

		exams[current] = exam;
		current++;

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

	public void init() {
//		this.exams = new Exam[3]; //초기값을 대입하고 있다.
//		this.current = 0;
		
		// this는 무조건 받기때문에 생략이 가능하다. 지워도 되면 지워서 쓰자.
		exams = new Exam[3]; 
		current = 0;
	}

}
