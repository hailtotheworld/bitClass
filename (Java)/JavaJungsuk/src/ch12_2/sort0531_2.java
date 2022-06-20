package ch12_2;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class sort0531_2 {
	public static void main(String[] args) {
		Set<Object> ss = new TreeSet<Object>(Collections.reverseOrder());
		
		ss.add(new Test2()); // TreeSet의 add()메서드는 비교하면서 저장하는데 Test객체에 비교기준이 없어서 형변환애러발생한거야.
		ss.add(10);
		ss.add(9);
		ss.add(-1);
		
		Iterator<Object> it2 = ss.iterator();
		
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
	}

}

class Test2 implements Comparable{

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
