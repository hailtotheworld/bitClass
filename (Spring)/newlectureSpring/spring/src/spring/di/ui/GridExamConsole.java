package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {

	private Exam exam;

	public GridExamConsole() {
		System.out.println("기본생성자");
	}

	@Autowired
	public GridExamConsole(@Qualifier("exam2") Exam exam) {
		System.out.println("오버로드생성자");
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.println("┌──────────┬──────────┐");
		System.out.println("│   total  │    avg   │");
		System.out.println("├──────────┼──────────┤");
		System.out.printf("│   %3d    │   %3.2f  │\n", exam.total(), exam.avg());
		System.out.println("└──────────┴──────────┘");
	}

	@Override
	public void setExam(Exam exam) {
		System.out.println("setter함수");
		this.exam = exam;
	}

}
