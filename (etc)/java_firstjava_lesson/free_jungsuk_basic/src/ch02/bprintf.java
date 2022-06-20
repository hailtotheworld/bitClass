package ch02;

public class bprintf {
	
	public static void main(String[] args) {
		String a = "12345678901234567890";
		
		System.out.printf("%-30s\n",a); // String 값보다 큰 숫자가 빈칸을 데리고 다니는구나. -가 왼쪽부터 채운다
		System.out.printf("%30s\n",a); 	// + 오른쪽부터 채운다
		System.out.printf("%6s\n",a);   // String 보다 작은 자릿수 printf는 의미없음.
		System.out.printf("%.6s\n",a); 	// 소숫점으로 짜른다!!!

		
		System.out.println("================");
		
		double c = 1.23456789;
		
		System.out.printf("%14.10f\n",c);
		
		System.out.println("================");

		// ex  소숫점3자리까지 나오게 해봐라
		
		double ex1 = 3.144592;
		
		System.out.printf("%4.2f\n",ex1);   // %총자리수.소숫점자리수f (반올림한다)


		
		
	}

}
