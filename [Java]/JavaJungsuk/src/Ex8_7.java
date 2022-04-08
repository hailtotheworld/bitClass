class Ex8_7 {
	public static void main(String[] args) {

		try {
			throw new Exception("예외처리필수"); // 컴파일에러가 발생함. 예외처리 필수야. 예외처리 안하면 실행조차 안돼.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		throw new RuntimeException(); // 컴파일에러가 없음. 예외처리 선택적이라는거지.

	}
}