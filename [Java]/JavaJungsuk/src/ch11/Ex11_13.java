package ch11;
import java.util.*;

class Ex11_13 {
	public static void main(String[] args) {
		// java.lang.ClassCastException
//		Set set = new TreeSet();    
		Set set = new TreeSet(Comparator.naturalOrder());    
//		Set set = new TreeSet(Collections.reverseOrder());    
//		Set set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
//		Set set = new TreeSet(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

		set.add(new Test());
		set.add(new Test());
		set.add(new Test());

		System.out.println(set);
	}
}

class Test {}















//class TestComp implements Comparator {
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//}