package ch06;

public class ex62 {

	public static void main(String[] args) {
		Student2 s = new Student2("이룸:", 1, 1, 100, 76, 60);
		
		String str = s.info();
		System.out.println(str);
	}

}

class Student2 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public Student2(String name, int ban, int no, int kor, int eng, int math) {
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
