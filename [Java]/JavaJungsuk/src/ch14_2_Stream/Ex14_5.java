package ch14_2_Stream;

import java.util.*;
import java.util.stream.*;

class Ex14_5 {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
						new Student("이자바", 3, 300),
						new Student("김자바", 1, 900),
						new Student("안자바", 2, 100),
						new Student("박자바", 2, 150),
						new Student("소자바", 1, 700),
						new Student("abc자바", 1, 200),
						new Student("BBb자바", 1, 200),
						new Student("avc자바", 1, 200),
						new Student("Abc자바", 1, 200),
						new Student("AAA자바", 1, 200),
						new Student("나자바", 3, 290),
						new Student("감자바", 3, 180)
					);

		studentStream.sorted(
				Comparator.comparing(Student::getBan)
						  .thenComparing(Comparator.naturalOrder())
						  .thenComparing(Student::getName)
						  .thenComparing((Student s)->s.getName())
				)
		.forEach(System.out::println);
		
		


	}
}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;
	Student(String name, int ban, int totalScore) { 
		this.name =name;
		this.ban =ban;
		this.totalScore =totalScore;
	}

	public String toString() { 
	   return String.format("[%s, %d, %d]", name, ban, totalScore); 
	}

	String getName()     { return name;}
	int getBan()         { return ban;}
	int getTotalScore()  { return totalScore;}

	public int compareTo(Student s) { 
		return s.totalScore - this.totalScore;
	}

}