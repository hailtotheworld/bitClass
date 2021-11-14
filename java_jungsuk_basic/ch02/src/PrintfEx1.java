
public class PrintfEx1 {

	public static void main(String[] args) {
		System.out.println(10.0/3);
		
		System.out.printf("%d%n", 15);
		System.out.printf("%o%n", 15);
		System.out.printf("%x%n", 15);
		System.out.println();
		System.out.printf("%d%n", 15);
		System.out.printf("%#o%n", 15);
		System.out.printf("%#x%n", 15);
		
		System.out.printf("%s%n", Integer.toBinaryString(15)); // 2진법 표시하는 방법!!!
		System.out.println();
		
		float f = 123.456789f;
		System.out.printf("%f%n", f); // 123.456787 float은 정밀도가 7자리, 그 뒤는 의미없음.
		System.out.printf("%e%n", f);
		System.out.printf("%g%n", f);
		System.out.println();
		
		Double d = 123.456789; 
		System.out.printf("%f%n", d); // 123.456789 double은 정밀도가 15자리
		System.out.println();

		System.out.printf("[%5d]%n", 10);
		System.out.printf("[%5d]%n", 1234567); // 값이 안짤리고 다 출력되네
		System.out.printf("[%-5d]%n", 10);
		System.out.printf("[%05d]%n", 10);
		System.out.println();
		
		double dd = 1.23456789;
		System.out.printf("%14.10f%n", dd);
		System.out.printf("%14.6f%n", dd);
		System.out.printf("%.6f%n", dd);
		System.out.println();

		System.out.printf("[%s]%n", "www.codechobo.com");
		System.out.printf("[%20s]%n", "www.codechobo.com");
		System.out.printf("[%-20s]%n", "www.codechobo.com");
		System.out.printf("[%.4s]%n", "www.codechobo.com");
		
		
		
	}

}
