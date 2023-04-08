package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 
		Exam exam = new NewlecExam();
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		*/
		
		// Exam exam = new NewlecExam();
		// Exam 인터페이스, NewlecExam 데이터구현객체
						
		// ExamConsole console = new InlineExamConsole(exam); // InlineExamConsole가 exam객체를 조립하고 있다. 이작업이 DI다.
		// ExamConsole console = new GridExamConsole();
		// 객체를 생성하는 부분을 비워두고 이 부분을 Spring이 대신 해줄수있도록 설정을 빼고 조립시키는 도움을 받으면,
		// 소스코드 수정없이 InlineExamConsole,GridExamConsole 바꿔낄수있게된다.
		// 바뀌는거라면 정적으로 코드로 박아놓는것보다는 설정으로 빼는게 바람직하다.

		
		
		////// 스프링에게 지시하는 방법으로 코드를 변경
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		// 스프링라이브러리를 받기위해서 Maven프로젝트로 변경해준다.(프로젝트 우클릭-configure-Convert to Maven Project)
		ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		
//		ExamConsole console = (ExamConsole) context.getBean("console");
		// 부품을 생성하고 조립해서 나에게 던져주는게 스프링이다.
		// 이름을 가지고 꺼내면 이름에 해당하는 객체가 어떤건지 알수없기 때문에 형변환을 해줘야한다.
		
//		Exam exam = context.getBean(Exam.class);
//		System.out.println(exam.toString());

		ExamConsole console = context.getBean(ExamConsole.class);
		// 자료형명으로도 꺼낼수 있다.
		// ExamConsole.class  인터페이스형식에참조될수있는.클래스를 찾아달라는거다
		// 만일 인터페이스를 구현한 객체가 여러개있다면 애매해지겠지. 그걸 구분할수있는 방법이 따로있어.
		// 자료형으로 꺼내는게 이름을가지고 꺼내는거보다 더 선호되는 방식이다. 형변환을 할 필요가 없고 클래스명을 깔끔하게 설정할수있기 때문이다.
		console.print();
		
		///////////////////
        // List<Exam> exams = new ArrayList<>();
//		List<Exam> exams = (List<Exam>) context.getBean("exams");
//		List<Exam> exams = (List<Exam>) context.getBean(ArrayList.class);
		
//		List<Exam> madeExams = (List<Exam>) context.getBean("madeExams");

		
		// exams.add(new NewlecExam(1,1,1,1));
		
//		for(Exam e: madeExams) {
//			System.out.println(e);
//		}
		
	}

}
