package ch00;
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
		// String.join은 내부적으로 StringBuffer를 사용해서 좀더 속도를 향상시키도록 코드가 작성되어있다.
//		System.out.println(String.join("*", strVal, "+", strVal2, "=") + sum);
//		System.out.println(String.join("", strVal, "+", strVal2, "=") + sum); // 구분자가 없다는거야
		System.out.println(String.join("*", "100", "+", "200", "=") + 300);
		System.out.println(String.join("", strVal, "+", strVal2, "=") + 300); // 구분자가 없다는거야
		
//		// 100+200+300=600
//		System.out.println(String.join("+", "100","200","300") +"="+ 600);
		
		
		// 여러문자열을 더하면 객체가 만들어져서 성능이 떨어진다.
		System.out.println(strVal + "+" + strVal2 + "=" + sum2);
	}
}