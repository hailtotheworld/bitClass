package ch14_FP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class forEachTest {
	public static void main(String[] args) {
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Collections.addAll(list, 1,2,3,4,5,6,7,8,9);
		list.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		list.removeIf(x->x%2==0);
		list.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		map.put(1,1);
		map.put(2,2);
		map.put(1,4);
		map.put(1,0);
		
		map.forEach((k,v)->System.out.printf("%d,%d\n",k,v));
		
	}

}
