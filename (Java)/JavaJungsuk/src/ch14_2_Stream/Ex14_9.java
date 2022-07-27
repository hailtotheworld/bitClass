package ch14_2_Stream;

import java.util.*;
import java.util.stream.*;

class Ex14_9 {
	public static void main(String[] args) {
		String[] strArr = {
			"Inheritance", "Java", "Lambda", "stream",
			"OptionalDouble", "IntStream", "count", "sum", "super"
		};

		Stream.of(strArr)
		.parallel() // 병렬로 처리-여러스레드가 나눠서 처리해서 순서가 바뀐다
		.forEachOrdered(System.out::println); // .forEachOrdered()를 쓰면 병렬처리해도 순서유지된다.
		
		System.out.println();
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
//		Optional<String> sWord = Stream.of(strArr)
//					               .filter(s->s.charAt(0)=='s').findFirst(); // stream
		
		Optional<String> sWord = Stream.of(strArr).parallel()
	               .filter(s->s.charAt(0)=='s').findAny(); // stream 또는 sum

		System.out.println("noEmptyStr="+noEmptyStr);
		System.out.println("sWord="+ sWord.get());
		
		
		System.out.println();
		//////////////////////////////////////////////////////////////////////////////////////////////////


		// Stream<String>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		
		// reduce(초기값, BinartOperator<T> accumulator)
		// reduce(BinartOperator<T> accumulator)
		int count = intStream1.reduce(0, (a,b) -> a + 1);
		int sum   = intStream2.reduce(0, (a,b) -> a + b);
		OptionalInt max = intStream3.reduce((a,b)->Integer.max(a, b));
		OptionalInt min = intStream4.reduce(Integer::min);
		
		System.out.println("count="+count);
		System.out.println("sum="+sum);
		System.out.println("max="+ max.getAsInt());
		System.out.println("min="+ min.getAsInt());

		System.out.println(10+"5");
		
		// 자바 숫자 + 문자열 => 문자열 (+는 연결연산자)
		// 자바 숫자 - 문자열 => 오류
		
		// 자바스크립트 숫자 + 문자열 => 문자열 (+는 연결연산자)
		// 자바스크립트 숫자 - 문자열 => 숫자 (문자열이 숫자로 자동형변환되었다)
		
	}
}













