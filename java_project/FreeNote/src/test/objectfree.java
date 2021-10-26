package test;

public class objectfree {

	public static void main(String[] args) {
		Student s = new Student("이룸:", 1, 1, 100, 76, 60);
		
		String str = s.info();
		System.out.println(str);
	}

}

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String info() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + (kor + eng + math) + ","
				+ ((int) ((kor + eng + math) / 3f * 10 + 0.5f) / 10f);

	}

}
