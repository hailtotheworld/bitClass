package ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class arrayTest {
	public static void main(String[] args) {
		

		ArrayList list = new ArrayList();
		
		list.add(10);
		list.add(50);
		list.add(70);
		list.add(80);

		list.add(1, -100);
		
		System.out.println(list);
		
		Collections.sort(list,Collections.reverseOrder());
		
		System.out.println(list);

		
		

	
		
	}
}
	

