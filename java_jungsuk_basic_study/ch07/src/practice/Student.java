package practice;

public class Student {
	
    //멤버 변수
    String name;
    int number;
    int grade;
	
    // 메서드(함수)
    public void getGrade() {
        grade += 10;
    }
    
    public Student() {
        name = "학생";
        number = 100;
        grade = 0;

        System.out.println("학생의 이름은 " + name);
        System.out.println("학생의 번호는 " + number);
        System.out.println("학생의 성적은 " + grade);
    }
    
    
    
    

    public static void main(String[] args) {
        Student student1 = new Student(); // 객체를 생성할때는 new 연산자를 통해 생성한다.
      									// Student()는 생성자를 호출한다는 의미이다.(생성자는 좀 이따 설명)
        student1.name = "영희";
        student1.number = 1;
        student1.grade = 80;

        System.out.println("학생의 이름은 " + student1.name);
        System.out.println("학생의 번호는 " + student1.number);
        System.out.println("학생의 성적은 " + student1.grade);

        student1.getGrade();

        System.out.println("학생의 성적은 " + student1.grade);

    }
}