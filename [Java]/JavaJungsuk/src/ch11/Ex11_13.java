package ch11;
import java.util.*;

class Ex11_13 {
	public static void main(String[] args) {
		// java.lang.ClassCastException
//		Set set = new TreeSet();    
		Set set = new TreeSet(Comparator.naturalOrder());    
//		Set<Test> set = new TreeSet<Test>(new TestComp());
//		Set set = new TreeSet(Collections.reverseOrder());    
//		Set set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
//		Set set = new TreeSet(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		
//	    public TreeSet(Comparator<? super E> comparator) {
//	        this(new TreeMap<>(comparator));
//	    }

		set.add(new Test());
		set.add(new Test());
		set.add(new Test());

		System.out.println(set);
	}
}

// 요소로하는 클래스가 comparable을 구현하고 있어야. comparator비교기준으로 비교할 수 있다.
// eg) Integer클래스는 comparable을 구현하고 있지만, comparator을 구현하지는 않는다.
//     하지만 comparator 비교기준을 사용할 수 있다.

class Test<T> implements Comparable<T>, Comparator<T>{
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}





//
//class TestComp implements Comparator{
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}