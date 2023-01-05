package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {

	@Autowired
//	@Autowired(required = false)
//	@Qualifier("exam1")
	private Exam exam;

	public InlineExamConsole() {
		System.out.println("기본생성자");
	}

	public InlineExamConsole(Exam exam) {
		System.out.println("오버로드생성자");
		this.exam = exam;
	}

	public void print() {
		if (exam == null) {
			System.out.printf("Exam이 Null 입니다. total is %d, avg is %f\n", 0, 0.0);

		} else {
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
		}
	}

	public void setExam(Exam exam) {
		System.out.println("setter함수");
		this.exam = exam;

	}

}
