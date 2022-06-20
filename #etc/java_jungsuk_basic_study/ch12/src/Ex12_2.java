import java.util.HashMap;

public class Ex12_2 {
	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<>();
		map.put("자바왕", new Student("자바왕", 1, 1, 100, 100, 100));
		
		Student s = map.get("자바왕");
		
		System.out.println(map);
		
		System.out.println(map.get("자바왕").name);
		
		
	}

}


class Student {
	String name ="";
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	
	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}





	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
}
