package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		// Exam 인터페이스
		// NewlecExam 데이터구현객체
		Exam exam = new NewlecExam();
		
		// ExamConsole console = new InlineExamConsole(exam); // InlineExamConsole객체가 exam객체를 조립하고 있다. 이작업이 DI다.
		
		ExamConsole console = new GridExamConsole(exam);
		// 객체를 생성하는 부분을 비워두고 이 부분을 Spring이 대신 해줄수있도록 설정을 빼고 조립시키는 도움을 받으면,
		// 소스코드 수정없이 InlineExamConsole,GridExamConsole 바꿔낄수있게된다.
		
		console.print();
		
		
	}

}
