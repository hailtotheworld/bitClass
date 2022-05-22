package ch11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class arrayTest {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();

		Queue q = new LinkedList();
		Collection c = new LinkedList();
		List l = new LinkedList();
		
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
//		for(int i=0;i<list.size();i++) {
//			list.remove(i);
//		}
		
		System.out.println(list.size());
		
		for(int i=list.size()-1;i>=0;i--) {
			list.remove(i);
		}
		
		
		System.out.println(list);
		
		

	
		
	}
}
	

