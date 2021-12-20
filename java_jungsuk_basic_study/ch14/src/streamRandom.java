import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamRandom {
	public static void main(String[] args) {
		IntStream intStream = new Random().ints();
		intStream.limit(5).forEach(System.out::println);
	
		System.out.println("============");
		
		IntStream intStream2 = new Random().ints(1,46);
		intStream2.limit(6).forEach(System.out::println);
		
		Stream<Integer> intStream4 = Stream.iterate(2, n -> n+2);
		intStream4.limit(10).forEach(System.out::println);
		
		IntStream df = new Random().ints();
		
	}

}
