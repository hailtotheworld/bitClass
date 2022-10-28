package ch00;
class Data3 { int x; }

class Ex6_8 {
	public static void main(String[] args) {
		Data3 d = new Data3();
		d.x = 10;

//		Data3 d2 = Ex6_8.copy(d); 
		Data3 d2 = copy(d); // 같은 클래스 내에 있는 static메서드를 불러올때는 참조변수를 적지 않아도 된다.
		System.out.println("d.x ="+d.x);
		System.out.println("d2.x="+d2.x);
	}

	static Data3 copy(Data3 d) {
		Data3 tmp = new Data3();    // 새로운 객체 tmp를 생성한다.

		tmp.x = d.x;  // d.x의 값을 tmp.x에 복사한다.

		return tmp;   // 복사한 객체의 주소를 반환한다.
	}
}