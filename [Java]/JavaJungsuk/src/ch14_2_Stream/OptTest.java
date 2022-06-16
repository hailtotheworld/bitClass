package ch14_2_Stream;

import java.util.Optional;
import java.util.stream.Stream;

public class OptTest {
	public static void main(String[] args) {
		
//		int[] arr = null; // (△) NullPointerException발생
     	int[] arr = {};
//		int[] arr = new int[0];
		
		System.out.println("arr.length=" + arr.length);
		System.out.println();
		
		//////////////////////////////////////////////////////////////////////////
		
//		Optional<String> opt = null; // (△) NullPointerException발생
		
		Optional<String> opt = Optional.empty();
//		Optional<String> opt = Optional.ofNullable();
		System.out.println("opt="+opt);
		
		//////////////////////////////////////////////////////////////////////////

		String str = "";
		
		try {
			str = opt.get();
		} catch (Exception e) {
			str=""; // 예외가 발생하면 빈문자열("")로 초기화
		}
		
		System.out.println("str="+str);
		
		//////////////////////////////////////////////////////////////////////////
		
//		str = opt.orElse("EMPTY"); // Optinal에 저장된 값이 null이면 ""반환
		str = opt.orElseGet(()->"비어있어"); // Optinal에 저장된 값이 null이면 ""반환
		
		System.out.println("str="+str);

		
		Stream<Integer> st = Stream.iterate(2, (i)->i*2);
		st.limit(5).forEach(System.out::println);
		
		
	}
}











