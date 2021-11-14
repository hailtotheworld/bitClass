
public class VarEx3 {

	public static void main(String[] args) {
		final int score = 100;
//		score = 200; // 상수는 한번 값을 저장하면 다른 값으로 변경할 수 없다!!
		// The final local variable score cannot be assigned. It must be blank and not using a compound assignment.
		
		int sss; // 선언
		sss = 20; // 초기화
		int kkk = 500; // 선언과 초기화 동시에!
		
		System.out.println(score);
		System.out.println(sss);
		
		////////////////////////
		boolean power = false;
		System.out.println(power);
		
		byte b = 127; // -128~127
		
		int bina = 0b10; //2진수, 2진수로 2
		int oct = 010;  // 8진수, 10진수로 8
		int hex = 0x10; // 16진수, 10진수로 16
		System.out.println(bina);
		System.out.println(oct);
		System.out.println(hex);
		
//		long l = 10_000_000_000; 에러발생!! int타입은 20억까지만이야.
		long l = 10_000_000_000L; // 접미사 L붙이면 long타입으로 전환되서 해결
		System.out.println(l);
		
		float f = 3.14f;
		double d = 3.14;
		
		
		char ch = 'A';
		int i = 'A';
		System.out.println(ch);
		System.out.println(i);
		
		String str = "";
		String str2 = "ABCD";
		String str3 = "123";
		String str4 = str2 + str3;
		System.out.println(str4);
		
		

	}

}
