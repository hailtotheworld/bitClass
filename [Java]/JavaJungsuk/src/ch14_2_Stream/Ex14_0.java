package ch14_2_Stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ex14_0 {
	public static void main(String[] args) {

//		List<Integer> list = Arrays.asList(1,2,3,4,5);
//		Stream<Integer> intStream = list.stream(); // list를 데이터소스로 하는 새로운 스트림을 생성
//		
//		 // forEach()는 최종연산이다. 최종연산을 하면 스트림이 닫힌다.
//		intStream.forEach((i)->System.out.println(i));
//		
//		// Stream은 1회용.
//		intStream = list.stream();
//		intStream.forEach(System.out::print);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		Stream<String> strString = Stream.of("a","b","c");
//		Stream<String> strString2 = Stream.of(new String[] {"a","b","c","d"});
//		strString.forEach(System.out::println);
//		strString2.forEach(System.out::println);
//		
//		String[] strArr = new String[] {"e","f","g"};
//		Stream<String> strString3 = Stream.of(strArr);
//		
//		Stream<String> strString4 = Arrays.stream(strArr);
//		
//		int[] intArr = {1,2,3,4,5};
//		IntStream intStream = Arrays.stream(intArr);
////		intStream.forEach(System.out::print);
////		System.out.println("count="+intStream.count());
////		System.out.println("count="+intStream.sum());
//		System.out.println("count="+intStream.average());
//		
//		Integer[] intArr2 = new Integer[] {6,7,8,9,10};
//		Stream<Integer> intStream2 = Arrays.stream(intArr2);
//		intStream2.forEach(System.out::print);

		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		IntStream intStream = new Random().ints(); // 무한스트림
//		intStream
//		.limit(5) // 5개만 자르기
//		.forEach(System.out::println);
//		
//		IntStream intStream2 = new Random().ints(5); 
//		intStream2
//		.forEach(System.out::println);
//		
//		IntStream intStream3 = new Random().ints(1,46); 
//		intStream3
//		.limit(6)
//		.distinct()
//		.forEach(System.out::println);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		IntStream intStream = IntStream.range(1, 5);
//		intStream.forEach(System.out::println);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// iterate(T seed, UnaryOperator f)
		//          초기값   단항연산자. 하나를 넣으면 결과가 하나 나오는거야
		Stream<Integer> intStream = Stream.iterate(2, n->n*2); // 무한스트림
		intStream.limit(10).forEach(i-> System.out.print(i+" "));

		// generate(Supplier s): 주기만 하는것 입력x, 출력o
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(10).forEach(System.out::println);
		
		
	
	
	
	
	 
	}

}
