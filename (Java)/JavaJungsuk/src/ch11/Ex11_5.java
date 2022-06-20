package ch11;

import java.util.*;

class Ex11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		
		Iterator it = list.iterator();

		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		Iterator it2 = list.iterator();
		
		while(it2.hasNext()) {
			Object obj = it2.next();
			System.out.println(obj);
		}
		
//		
//		System.out.println();
//		
//		Queue q = new LinkedList();
//		q.offer("1");
//		q.offer("2");
//		q.offer("3");
//		q.offer("4");
//		q.offer("5");
//
//		Iterator it2 = q.iterator();
//
//		while(it2.hasNext()) {
//			Object obj = it2.next();
//			System.out.println(obj);
//		}
		
//		System.out.println();
//
//		
//		Stack s = new Stack();
//		s.push("1");
//		s.push("2");
//		s.push("3");
//		s.push("4");
//		s.push("5");
		
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());

//		Iterator it3 = s.iterator();
//
//		while(it3.hasNext()) {
//			Object obj = it3.next();
//			System.out.println(obj);
//		}
//		
//		System.out.println();
		
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
		
		
	} // main
}