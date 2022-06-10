package ch14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex14_0 {
	public static void main(String[] args) {

//		Object obj = (a, b) -> a > b ? a:b; // 람다식. 익명객체

		MyFunction f = new MyFunction() {
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		

		MyFunction f2 = (a, b) -> a > b ? a : b;

		int value = f.max(3, 5); // Object타입의 리모콘 obj에는 max()라는 메서드가 없어서 에러.
		System.out.println("value=" + value);
		
		List<String> list = new ArrayList<String>();
		
		Collections.addAll(list, "abc","ccc","kkk","aaa");
		
//		Collections.sort(list, (s1,s2)->s2.compareTo(s1)); // [kkk, ccc, abc, aaa]
		Collections.sort(list, (s1,s2)->s1.compareTo(s2)); // [aaa, abc, ccc, kkk]

		
		System.out.println(list); 

	}

}

@FunctionalInterface // @FunctionalInterface을 붙혀야 추상메서드가 2개면 에러로 알려준다.
interface MyFunction {
	public abstract int max(int a, int b);
//	public abstract int max1 (int a, int b);
}
