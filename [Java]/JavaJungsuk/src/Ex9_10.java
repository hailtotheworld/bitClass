class Ex9_10 {
	public static void main(String[] args) {
		int iVal = 100;
		String strVal = String.valueOf(iVal); // int를 String으로 변환한다.
//		String strVal = iVal+"";

		double dVal = 200.0;
		String strVal2 = String.valueOf(dVal);
//		String strVal2 = dVal + ""; // int를 String으로 변환하는 또 다른 방법

		
		// 위 아래 같은 문장이다.
		double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);
		
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);

		
		// join("*" <- 구분자를 준거야.)
		// String.join은 내부적으로 스트링버퍼를 사용해서 좀더 속도를 향상시키도록 코드가 작성되어있다.
		System.out.println(String.join("*", strVal, "+", strVal2, "=") + sum);
		
		// 여러문자열을 더하는건 성능이 떨어질수 있다.
		System.out.println(strVal + "+" + strVal2 + "=" + sum2);
	}
}