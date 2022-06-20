class Ex4_8 {
	public static void main(String args[]) {
		
//		for (int i = 1; i <= 3; i++) { // 괄호{}안의 문장을 3번 반복
//			System.out.printf("%s%d%n","Hello",i);
//		}
		
//		for (int i = 1; i <= 3; i=i+1) { // 1 2 3
//			System.out.printf("%s%d%n","Hello",i);
//		}
		
//		for (int i = 1; i <= 10; i=i+2) { // 1 3 5 7
//			System.out.printf("%s%d%n","Hello",i);
//		}
		
//		for (int i = 1; i <= 10; i=i*2) { // 1 2 4 8
//			System.out.printf("%s%d%n","Hello",i);
//		}
		
//		for (int i = 10; i >= 1; i--) { // 10 9 8 7 6 5 4 3 2 1
//		System.out.printf("%d%n",i);
//		}
		
		// i하고 j가 같은타입이여야지 같이 쓸 수 있다.
		for (int i = 1,j=10,k=3; i <= 10; i++,j--) {
		System.out.println("i="+i+",j="+j);
		}		

//				i=1,j=10
//				i=2,j=9
//				i=3,j=8
//				i=4,j=7
//				i=5,j=6
//				i=6,j=5
//				i=7,j=4
//				i=8,j=3
//				i=9,j=2
//				i=10,j=1

		// 변수 i의 scope(범위)가 더 넓어졌다
//		int i;
//		
//		for (i = 1; i <= 10; i++) { 
//		System.out.println(i);
//		}
//		
//		System.out.println(i); // 11
		
		int i=1;
		
		for (; i <= 10; i++) { 
		System.out.println(i);
		}
		
		System.out.println(i); // 11


		
		
		
	}
}