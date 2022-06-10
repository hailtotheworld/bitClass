package ch14;

public class Ex14_0 {
	public static void main(String[] args) {
		
		
//		Object obj = (a, b) -> a > b ? a:b; // 람다식. 익명객체

		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a:b;
			}
		};
		
//		int value = obj.max(3,5); // Object타입의 리모콘 obj에는 max()라는 메서드가 없어서 에러.
		
		
		
	
	}

}



@FunctionalInterface // @FunctionalInterface을 붙혀야 추상메서드가 2개면 에러로 알려준다.
interface MyFunction {
	public abstract int max (int a, int b);
//	public abstract int max1 (int a, int b);
}
