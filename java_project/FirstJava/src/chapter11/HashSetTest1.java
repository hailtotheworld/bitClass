package chapter11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest1 {
	public static void main(String[] args) {
		
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("1");
		hashset.add("2");
		hashset.add("3");
		hashset.add("1");
		
		System.out.println("모든 요소의 개수 : " + hashset.size());
		
		Iterator<String> itr = hashset.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// HashSet은 같은걸 저장하지는 않는구나.

		


	}

}
