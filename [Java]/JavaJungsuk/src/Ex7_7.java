class Ex7_7 {
	public static void main(String args[]) {
		Car c = new Car();
		FireEngine fe = (FireEngine) c; // 형변환 실행 에러 java.lang.ClassCastException
		fe.water(); // 컴파일 오케이 (컴파일러는 실제 실행했을때 어떻게 되는지 확인을 못하기 때문이다.)
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Car car = null;
//		FireEngine fe = new FireEngine(); // 형변환할때 실제 인스턴스가 무엇인지가 중요.
//
//		// 객체가 없는데도 형변환에는 아무 문제가 없다..!
//		FireEngine fe2 = (FireEngine) car;
//		Car car2 = fe2;
//		car2.drive(); // 객체가 없으니까 NullPointerException 발생.
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//		FireEngine fe = new FireEngine();
//		FireEngine fe2 = null;
//
//		fe.water();
//		car = fe; // car = (Car)fe;에서 형변환이 생략됨
////		car.water();
//		fe2 = (FireEngine) car; // 자손타입 ← 조상타입. 형변환 생략 불가 
//		fe2.water();
	}
}

class Car {
	String color;
	int door;

	void drive() { // 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() { // 멈추는 기능
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car { // 소방차
	void water() { // 물을 뿌리는 기능
		System.out.println("water!!!");
	}
}