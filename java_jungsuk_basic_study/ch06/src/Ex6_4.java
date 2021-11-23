class Ex6_4 {
	public static void main(String args[]) {
		MyMath mm = new MyMath();
		
		mm.printGugudan(3);
		mm.printGugudan(12);
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L);

		System.out.println("add(5L, 3L) = " + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = " + result4);
		
		long max = mm.max(-50, 9);
		System.out.println(max);
	}
 }

 class MyMath {
	 void printGugudan (int dan) {
		 if(!(2<=dan && dan <=9)) {
			 return; // 입력받은 단(dan)이 2~9가 아니면, 메서드 종료하고 돌아가기
		 }
		 for(int i=1;i<=9;i++) {
			 System.out.printf("%d * %d = %d%n", dan, i, dan*i);
		 }
	 }
	 
	 
	long add(long a, long b) {
		long result = a + b;
		return result;
	//	return a + b;	// 위의 두 줄을 이와 같이 한 줄로 간단히 할 수 있다.
	}
	long subtract(long a, long b) { return a - b; }
	long multiply(long a, long b) { return a * b; }
	double divide(double a, double b) {
		return a / b;
	}
	
	long max(long a, long b) {
		return a>b?a:b;

	}
	
 }
