import java.util.function.Function;
import java.util.function.Supplier;

public class Ex14_methodreference {
	public static void main(String[] args) {
//		Function<String,Integer> f = (String s) -> Integer.parseInt(s);
//		Function<String,Integer> f = 클래스이름::메서드이름
//		Function<String,Integer> f = Integer::parseInt;
		Function<String,Integer> f = (String s) -> Integer.parseInt(s);
		System.out.println(f.apply("100")+200);
		
		// Supplier는 입력x, 출력o
//		Supplier<Myclass> s = () -> new Myclass();
//		Supplier<Myclass> s = 클래스이름::메서드이름
		Supplier<Myclass> s = Myclass::new;
		Myclass mc = s.get();
		System.out.println(mc);
		System.out.println(s.get());
		
//		Function<Integer, int[]> f2 = (i) -> new int[i];
		Function<Integer, int[]> f2 = int[]::new;
	}
	


}


class Myclass {}