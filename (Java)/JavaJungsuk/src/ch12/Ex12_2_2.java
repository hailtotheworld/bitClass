package ch12;

import java.util.*;

class Ex12_2_2 {
	public static void main(String[] args) {
		HashMap<String, Student1> map = new HashMap();
		
		map.put("자바왕", new Student1("자바왕",1,1,100,100,100));
		map.put("자바왕1", new Student1("자바왕",2,2,200,200,200));
		
		// public V get(Object key)
		// public Student1 get(String key)
		Student1 s = map.get("자바왕1");
		
		System.out.println(s.ban);
		
	} // main
}



class Student1 {
	String name = "";
	int ban;
	int no;
	int kor;
	int eng;
	int math;	

	public Student1(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}



	public Student1() {

	}



	@Override
	public String toString() {
		return "Student1 [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}
	
	
	
	
}