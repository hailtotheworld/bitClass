class Parent {
	void parentMethod() { }
}

class Child extends Parent {
//	@Override
	void parentmethod() { } // 조상 메서드의 이름을 잘못 적었음. 
	
	@Deprecated
	void depre() {} // 이렇게 표시가된다. 사용은 가능하지.
}

@FunctionalInterface // 함수형 인터페이스는 하나의 추상 메서드만 가능
interface Testable {
//	void test(); // 추상메서드
	void check(); // 추상메서드
}

class Ex12_7 {
	public static void main(String[] args) {
		Child c = new Child();
		c.parentmethod();
	}
}