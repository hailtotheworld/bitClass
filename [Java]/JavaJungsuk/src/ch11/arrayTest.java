package ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class arrayTest {
	public static void main(String[] args) {
		
//		ArrayList list = new ArrayList();
//
//		Queue q = new LinkedList();
//		Collection c = new LinkedList();
//		List l = new LinkedList();
//		
//		list.add(0);
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		
////		for(int i=0;i<list.size();i++) {
////			list.remove(i);
////		}
//		
//		System.out.println(list.size());
//		
//		for(int i=list.size()-1;i>=0;i--) {
//			list.remove(i);
//		}
//		
//		
//		System.out.println(list);
		
		///////////////////////////////////////////////
		
//		int[] arr = {0,1,2,3,4,5};
//				
//		System.out.println(Arrays.toString(arr));
//		
//		List list = new ArrayList(Arrays.asList(arr)); // 이렇게하면 Object[]배열에 주소값이 들어와서 안돼
////		List list = new ArrayList(Arrays.asList(1,2,3,4,5));
//		
//		System.out.println(list.get(1));
//		
//		Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//			Object obj = it.next();
//			System.out.println(obj);
//			
//		}
		
		/////////////////////////////////////////////
		
		int[] arr = new int[] {1,2,3,4,5};
		
		for(int x=0;x<arr.length;x++) {
			int i = arr[x];
			char[] graph = new char[i];
			Arrays.fill(graph, '*');
			System.out.println(new String(graph)+i);
		}
		
//		for(int i : arr) {
//			char[] graph = new char[i];
//			Arrays.fill(graph, '*');
//			System.out.println(new String(graph)+i);
//		}


	
		
	}
}
	

