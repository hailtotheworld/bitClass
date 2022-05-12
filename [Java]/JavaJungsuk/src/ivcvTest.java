
public class ivcvTest {

		int x=1;
		static int s = 3;
		
		void method() {
			
//			static ind k = 9;
//			final static int I = 30; // 인스턴스 메서드 내에 static변수, static메서드 선언할 수는 없다.
			
			s = 5; // 인스턴스 메서드 내에 클래스에 선언되어있는 static변수, static메서드가 들어올 수 있다.
			method2();

		}
		
		static void method2() {
			System.out.println(s);
		}
	
}
