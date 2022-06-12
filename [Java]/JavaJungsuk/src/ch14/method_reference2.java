package ch14;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class method_reference2 {
	public static void main(String[] args) {
		// Supplier는 입력X, 출력O
//		Supplier<MyClass> s = () -> new MyClass();
		Supplier<MyClass> s = MyClass::new; // 클래스이름::메서드이름, 클래스이름::new연산자

		MyClass mc = s.get();
		System.out.println(mc);

		System.out.println(s.get());

//////////////////////////////////////////////////////////////////////////////////////////////
	
//		Function<Integer,MyClass> f = i -> new MyClass(i);
		Function<Integer,MyClass> f = MyClass::new;
		
		System.out.println(f.apply(10));
		System.out.println(f.apply(50).iv);
	
//////////////////////////////////////////////////////////////////////////////////////////////

//		Function<Integer, int[]> arr = i -> new int[i];
		Function<Integer, int[]> fi = int[]::new;
		
		int[] arr = fi.apply(10);
		
		System.out.println(arr.length);
		

		
		
	}
}


class MyClass {
	int iv;

	public MyClass() {
	}

	public MyClass(int iv) {
		this.iv = iv;
	}
	
}