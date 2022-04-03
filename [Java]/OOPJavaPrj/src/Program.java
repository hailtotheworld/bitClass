import part3.ex4.UI코드분리하기.Exam;

public class Program {

	public static void main(String[] args) {
		
		NewlecExam exam = new NewlecExam(10,10,10,10);
		Exam exam2 = new NewlecExam(1,1,1,1);
		
		System.out.println(exam.total());
		System.out.println(exam.avg());
		System.out.println(exam2.total());
		
	}
 
}