package test022;

public class ttt {
	public static void main(String[] args) {
		Student s = new Student("이름", 1, 1, 100, 60, 76);
		
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
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String info() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+(kor+eng+math)+","+(int) ((kor+eng+math)/3f*10+0.5)/10f;
		
	}
	
	
	
	
	
	
}
