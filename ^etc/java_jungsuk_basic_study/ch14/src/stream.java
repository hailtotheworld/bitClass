import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class stream {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> intStream = list.stream(); // list를 Stream으로 변환
		intStream.forEach(System.out::print); // forEach()최종연산. 최종연산이후 스트림닫힌다.
		
		// 스트림은 1회용. 스트림에 대해 최종연산을 수행하면 스트림이 닫힌다.
		intStream = list.stream(); // list로 부터 stream을 생성
		intStream.forEach(System.out::print);

		///////
				
//		Stream<String> strStream = Stream.of("a","b","c");		
//		Stream<String> strStream = Stream.of(new String[] {"a","b","c"});	
		
		String[] strArr = {"a", "b", "c", "d"};
//		Stream<String> strStream = Stream.of(strArr);	
		
		Stream<String> strStream = Arrays.stream(strArr);
		
		strStream.forEach(System.out::println);
	}

}
