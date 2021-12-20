
public class Ex14_0 {
	public static void main(String[] args) {
//		Object obj = (a, b) -> a > b ? a : b; // 람다식. 익명객체
		MyFunction2 f = new MyFunction2() {
			 public int max(int a, int b) { // 오버라이딩 규칙 - 접근제어자는 좁게 못바꾼다.
				return a>b?a:b;
			}
		};
		
		// 람다식(익명객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
		MyFunction2 f2 = (a, b) -> a > b ? a : b; // 람다식. 익명객체
		
		
		int value = f.max(3,5);
		System.out.println("value="+value);
		
		// obj의 리모콘에는 max라는 버튼이 없다..
		// 그래서 함수형 인터페이스가 필요하다.
		
		
	}

}

@FunctionalInterface	// 함수형 인터페이스틑 단 하나의 추상 메서드만 가져야 함.
interface MyFunction2 {
	int max(int x, int y); // public abstract가 생략되어있는것이다.!! 인터페이스의 메서드니까.
//	public abstract int max2(int x, int y);
}