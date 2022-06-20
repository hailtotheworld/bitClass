package ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortTest {
	public static void main(String[] args) {
		
//		// String배열 정렬
		String[] strArr  = new String[] {"a", "b" ,"c", "A", "B", "C"};
		

		
		
		 // 대문자오름차순 -> 소문자오름차순 [A, B, C, a, b, c]
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		Arrays.sort(strArr,Comparator.naturalOrder());
		System.out.println(Arrays.toString(strArr));
		System.out.println();
		
		
		// 소문자내림차순 -> 대문자내림차순 [c, b, a, C, B, A]
		Arrays.sort(strArr, Collections.reverseOrder());
		System.out.println(Arrays.toString(strArr));	
		Arrays.sort(strArr, Comparator.reverseOrder());
		System.out.println(Arrays.toString(strArr));	
		System.out.println();


		// 대소문자구분안하고오름차순 [A, a, B, b, C, c]
		Arrays.sort(strArr,String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArr));
		System.out.println();
		
	

		// 대소문자구분안하고 내림차순 [c, C, b, B, a, A]
		Arrays.sort(strArr,Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		System.out.println(Arrays.toString(strArr));	
		System.out.println();
		
		
		
		// int배열 정렬
		Integer[] arr = new Integer[] {3,2,1,4,5};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr)); // 오름차순
		
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr)); // 내림차순
		
		// 컬렉션정렬
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Collections.addAll(list, 3,5,2,1,4);
		
		Collections.sort(list); // 오름차순정렬 [1, 2, 3, 4, 5]
		System.out.println(list); 
		Collections.sort(list, Collections.reverseOrder());  // 내림차순정렬 [5, 4, 3, 2, 1]
		Collections.sort(new ArrayList<Integer>(), Collections.reverseOrder());  // 내림차순정렬 [5, 4, 3, 2, 1]
		System.out.println(list);
		
		
		
		
		
		ArrayList<pie> pie1 = new ArrayList<pie>();
		
		pie1.add(new pie());
		pie1.add(new pie());
		
		Collections.sort(pie1);
		Collections.sort(pie1, Collections.reverseOrder());
		System.out.println(pie1);

		
		
	}
	

}


class jo<T> implements Comparable<T>{

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class pie extends jo{

	
}




