package ch11;

import java.util.*;

class Ex11_10 {
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		
		for (int i = 0; set.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1;
//			set.add(new Integer(num));
			set.add(num);
		}

		
		List list = new LinkedList(set); // LinkedList(Collection c)
		Collections.sort(list, Collections.reverseOrder());          // Collections.sort(List list)
		System.out.println(list);
		
		
	}
}