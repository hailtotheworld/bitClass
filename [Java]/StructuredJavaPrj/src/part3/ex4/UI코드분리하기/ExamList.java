package part3.ex4.UI코드분리하기;

import java.util.Scanner;

public class ExamList {
	private Exam[] exams;
	private int current;

	// 캡슐화의 가장 큰 장점은 데이터구조의 변화, 오류가 캡슐 안에서만 발생한다는 것이다!

	public void printList() { //
		printList(current);
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
			Exam exam = this.get(i);// ;

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

	private Exam get(int i) {

		return this.exams[i];
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

		add(exam);

	}

	private void add(Exam exam) {

//		if(exams의 공간이 없다면) {
//		공간을 늘려주기
//	}
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

	// 생성자: 초기화를 위한 특별한 함수
	// 반환값이 없다.
	// 처음 만들 때 딱 한번만 호출이 가능하다.
	public ExamList() {

		// this는 무조건 받기때문에 생략이 가능하다. 지워도 되면 지워서 쓰자.
		exams = new Exam[3];
		current = 0;
	}

}
