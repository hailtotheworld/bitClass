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
