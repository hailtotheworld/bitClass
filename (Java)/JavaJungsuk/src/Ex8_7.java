class Ex8_7 {
	public static void main(String[] args) {

		// checked에러라서 컴파일러가 예외처리여부를 체크한다.
		// 예외처리 안하면 빨간줄뜨면서 실행조차 안됨 <- 컴파일에러 발생했다는 의미이다.
//		throw new Exception();
		
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("예외처리1");
		}

		// unchecked에러라서 컴파일러가 예외처리여부를 체크안한다.
		// 실행은 되는데 실행하면 런타임에러발생함.

		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("예외처리2");
		}
	}
}