
public class Program {

	public static void main(String[] args)  { // 메인함수마저 예외를 던져버리는 무책임한 행동이 일어났다.

		Calculator calc = new Calculator();
		int result = 0;
		
		
		result = Calculator.add(3, 10000);
		System.out.printf("add: %d\n", result);
		result = Calculator.sub(3, 1);
		System.out.printf("sub: %d\n", result);
		
//		try {
//			result = Calculator.add(3, 4);
//			System.out.printf("add: %d\n", result);
//			result = Calculator.sub(3, 1);
//			System.out.printf("sub: %d\n", result);
//		
//		}
//		catch(천을_넘는_예외 e) {
//			System.out.println("특화된 처리");
//		}
//		catch(Exception e) {
//			System.out.println("음수처리");
//		}
//		finally {
//			System.out.println("입력값에 오류가 있습니다.");
//
//		}
		
		result = Calculator.multi(3, 4);
		System.out.printf("multi: %d\n", result);
		result = Calculator.div(3, 4);
		System.out.printf("div: %d\n", result);

	}

}
