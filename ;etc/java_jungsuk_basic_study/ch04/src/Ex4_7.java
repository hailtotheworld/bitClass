class Ex4_7 {
	public static void main(String args[]) {
		int num = 0;

		// 괄호{} 안의 내용을 5번 반복한다.
//		for (int i = 1; i <= 5; i++) {
//			num = (int) (Math.random() * 6) + 1;
//			System.out.println(num);
//		}
		
		// 퀴즈1. 1~10사이의 난수를 20개 출력하시오.
//		for (int i=0;i<20;i++) {
//			System.out.println((int)(Math.random()*10)+1);
//		}
		
		// 퀴즈2. -5~5사이ㅏ의 난수 20개를 출력하시오.
		for (int i=0;i<20;i++) {
			System.out.println((int)(Math.random()*11)-5);
		}


		
	}
}