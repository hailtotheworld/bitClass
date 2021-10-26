package ch06;

public class ex63 {
	public static void main(String[] args) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println(s.getTotal());
		System.out.println(s.getAverage());
		
		
	}
	

}


class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public Student() {
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
	
	public int getTotal() {
		return kor+eng+math;
	}
	
	public float getAverage() {
		return (int) ((kor+eng+math)/3f*10+0.5)/10f;
		
	}
	
	

}







