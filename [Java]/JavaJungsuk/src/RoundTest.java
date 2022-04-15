
public class RoundTest {
	public static void main(String[] args) {

//		for (double d = 0.0; d <= 2.0; d += 0.1) {
//			double d1 = Math.round(d);
//			double d2 = Math.rint(d);
//			
//			System.out.printf("%4.1f %4.1f %4.1f\n", d, d1, d2);
//		}
		
		double sum = 0;
		double sum1 = 0;
		double sum2 = 0;
		
		for (double d = 1.5; d <= 10.5; d++) {
			double d1 = Math.round(d);
			double d2 = Math.rint(d);
			
			System.out.printf("%4.1f %4.1f %4.1f\n", d, d1, d2);
			
			sum += d;
			sum1 += d1;
			sum2 += d2;
		}
		
		System.out.println("-------------");

		System.out.printf("%4.1f %4.1f %4.1f\n", sum, sum1, sum2);

	}

}
