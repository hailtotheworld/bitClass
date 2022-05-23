package ch11;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class testComp {
	public static void main(String[] args) {
		Set set = new TreeSet(new comp());
		
//		for (int i = 0; set.size() < 6 ; i++) {
//			int num = (int)(Math.random()*45) + 1;
//			set.add(num);  // set.add(new Integer(num)); 
////			set.add(new Test());  // 비교기준이 없어서 에러가 난다.
//		}

		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		
		System.out.println(set);
	}
}

class Test implements Comparable {

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return -1;
	}
} // 비교기준이 없다.

class comp implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}