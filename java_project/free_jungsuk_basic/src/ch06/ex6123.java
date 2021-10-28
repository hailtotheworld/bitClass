package ch06;

public class ex6123 {

	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 76, 60);
		
		String str = s.info();
		System.out.println(str);
		
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
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
		
	public String info() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+(kor+eng+math)+","+
	(int)((kor+eng+math)/3f*10+0.5)/10f;
		
	}
	
	public int getTotal() {
		return (kor+eng+math);
		
	}
	
	public float getAverage() {
		return (int) ((kor+eng+math)/3f*100+0.5)/100f;
		
	}
	
	
}
