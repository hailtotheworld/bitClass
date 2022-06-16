package ch14_2_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class collectTest {
	public static void main(String[] args) {
		
		Student11[] stuArr = {
				new Student11("나자바", true,  1, 1, 300),	
				new Student11("김지미", false, 1, 1, 250),	
				new Student11("김자바", true,  1, 1, 200),	
				new Student11("이지미", false, 1, 2, 150),	
				new Student11("남자바", true,  1, 2, 100),	
				new Student11("안지미", false, 1, 2,  50),	
				new Student11("황지미", false, 1, 3, 100),	
				new Student11("강지미", false, 1, 3, 150),	
				new Student11("이자바", true,  1, 3, 200),	
				new Student11("나자바", true,  2, 1, 300),	
				new Student11("김지미", false, 2, 1, 250),	
				new Student11("김자바", true,  2, 1, 200),	
				new Student11("이지미", false, 2, 2, 150),	
				new Student11("남자바", true,  2, 2, 100),	
				new Student11("안지미", false, 2, 2,  50),	
				new Student11("황지미", false, 2, 3, 100),	
				new Student11("강지미", false, 2, 3, 150),	
				new Student11("이자바", true,  2, 3, 200)	
			};
		
		Stream<Student11> sts = Stream.of(stuArr);
				
		List<String> list = sts.map(Student11::getName).collect(Collectors.toList());
		list.forEach(System.out::println);
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////
		
		Stream<Student11> sts1 = Stream.of(stuArr);
		
		Set<String> set = sts1.map(Student11::getName).collect(Collectors.toSet());
		set.forEach(System.out::println);
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts3 = Stream.of(stuArr);

		ArrayList<String> alist = sts3.map(Student11::getName).collect(Collectors.toCollection((ArrayList::new)));
		alist.forEach(System.out::println);
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////
		
		Stream<Student11> sts11 = Stream.of(stuArr);

		Object[] ss = sts11.toArray();
		System.out.println(ss[0]);
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		
		Stream<Student11> sts17 = Stream.of(stuArr);
		
		long count = sts17.collect(Collectors.counting());
		System.out.println(count);
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts18 = Stream.of(stuArr);
		int tt = sts18.collect(Collectors.summingInt(Student11::getScore));
		System.out.println(tt);
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////
		Stream<Student11> sts19 = Stream.of(stuArr);
		int sum = sts19.mapToInt(Student11::getScore).sum();
		System.out.println(sum);
		
	}

}


class Student11 {
	String name;
	boolean isMale; // 성별
	int hak;        // 학년
	int ban;        // 반
	int score;

	Student11(String name, boolean isMale, int hak, int ban, int score) { 
		this.name	= name;
		this.isMale	= isMale;
		this.hak	= hak;
		this.ban	= ban;
		this.score  = score;
	}
	String	getName()    { return name;	}
	boolean  isMale()     { return isMale;	}
	int      getHak()     { return hak;	}
	int      getBan()     { return ban;	}
	int      getScore()   { return score;	}

	public String toString() { 
		return String.format("[%s, %s, %d학년 %d반, %3d점]",
			name, isMale ? "남":"여", hak, ban, score); 
	}

}