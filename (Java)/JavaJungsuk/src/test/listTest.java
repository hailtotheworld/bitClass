package test;

import java.util.ArrayList;
import java.util.List;

public class listTest {
	
	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add(1);
		list.add("문자");
		list.add(true);
		
		list.stream().forEach(t -> System.out.println(t));
		
	}

}
