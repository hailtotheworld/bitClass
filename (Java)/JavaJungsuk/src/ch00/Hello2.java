package ch00;
// 하나의 소스파일에는 하나의 클래스만 작성하는 것이 바람직하다.

// 소스파일의 이름과 main메서드가 있는 클래스의 이름이 일치해야 정상적으로 실행된다.
class Hello2 {
	public static void main(String[] args) {
		System.out.println("hello");
	}
} // 소스파일의 이름은 public class 이름과 일치해야 한다.

class Hello3 {} // 하나의 소스파일에는 하나의 public class만 허용한다.
class Hello4 {}



// run configuration에서 실행할 메인메소드를 수동으로 지정해줄 수도 있다.
// 수동으로 지정하지 않으면, 소스파일의 이름과 main메서드가 있는 클래스의 이름이 일치한 메인메서드가 실행된다.