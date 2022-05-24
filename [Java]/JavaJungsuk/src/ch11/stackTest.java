package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stackTest {
	public static void main(String[] args) {
		
		Stack st = new Stack();
		
		st.push(10);
		st.push(70);
		st.push(30);
		st.push(-30);
		
		
		Collections.sort(st, Comparator.naturalOrder()); //[70, 30, 10, -30]

		
		System.out.println(st);
		

		

		
		
		

		

		
	}

}
