import java.util.Objects;

class Ex3_9 {
	public static void main(String args[]) {
		int a = 1_000_000; // 1,000,000 1¹é¸¸
		int b = 2_000_000; // 2,000,000 2¹é¸¸

		long c = a * b; // a * b = 2,000,000,000,000 ?
		long c1 = (long) a * b; // a * b = 2,000,000,000,000 ?

		System.out.println(c);
		System.out.println(c1);
		
		
		double d = 3.141592; // 3.14
		
		System.out.println();
		
		double d2 = Math.round(d*1000) / 1000.0;
		
		System.out.println(d2);
		

		

	}
}

