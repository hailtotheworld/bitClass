package ch14_2_Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class comTest {
	public static void main(String[] args) {
		
		List<company> com = new ArrayList<company>();
		
	
		com.add(new company(1,100000));
		com.add(new company(2,600));
		com.add(new company(7,700));
		com.add(new company(1,900));
		com.add(new company(1,4000));
		com.add(new company(1,9000));
		com.add(new company(1,6000));
		com.add(new company(1,9000));
		com.add(new company(5,10000));
		com.add(new company(6,100));
		com.add(new company(3,1090));

		
		Stream<company> st = com.stream();
		
		st.sorted(
			Comparator.comparing((company c) -> c.getBan())
			          .thenComparing(company::getSal)
			)
			.forEach(System.out::println);
		
	}

}

class company implements Comparable<company>{
	int ban;
	int sal;
	
	
	
	public int getBan() {
		return ban;
	}


	public void setBan(int ban) {
		this.ban = ban;
	}


	public int getSal() {
		return sal;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}


	public company() {
	}


	public company(int ban, int sal) {
		this.ban = ban;
		this.sal = sal;
	}


	@Override
	public String toString() {
		return "company [ban=" + ban + ", sal=" + sal + "]";
	}


	@Override
	public int compareTo(company c) {
		return this.ban - c.ban;
	}
	
	
}
