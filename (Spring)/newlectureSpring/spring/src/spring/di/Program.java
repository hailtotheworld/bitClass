package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		Exam exam = new NewlecExam();
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		*/
		
		// Exam exam = new NewlecExam();
		// Exam 인터페이스, NewlecExam 데이터구현객체
						
		// ExamConsole console = new InlineExamConsole(exam); // InlineExamConsole객체가 exam객체를 조립하고 있다. 이작업이 DI다.
		
		// ExamConsole console = new GridExamConsole();
		// 객체를 생성하는 부분을 비워두고 이 부분을 Spring이 대신 해줄수있도록 설정을 빼고 조립시키는 도움을 받으면,
		// 소스코드 수정없이 InlineExamConsole,GridExamConsole 바꿔낄수있게된다.
		// 바뀌는거라면 정적으로 코드로 박아놓는것보다는 설정으로 빼는게 바람직하다.


		
		ExamConsole console;
		// 부품을 생성하고 조립해서 나에게 던져주는게 스프링이다.
		
		console.print();
		
		
	}

}
