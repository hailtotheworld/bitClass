class A {
	public void method(I i) { // 인터페이스 I를 구현한 클래스만 매개변수로 들어올 수 있다.
		i.method();
	}
}


// 선언. 선언과 구현을 분리
interface I {
	public abstract void method();
}

// 구현. 선언과 구현을 분리
class B implements I {
	public void method() {
		System.out.println("B클래스의 메서드");
	}
}

// 구현. 선언과 구현을 분리
class C implements I {
	public void method() {
		System.out.println("C클래스의 메서드");
	}
}




public class InterfaceTest {

	public static void main(String[] args) {
		A a = new A();
		a.method(new C()); // A가 B를 사용(A가 B에 의존하고 있다.
	}

}
