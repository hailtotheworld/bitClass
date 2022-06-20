package ch13;

class Ex13_8 {
	public static void main(String args[]) {
		ThreadEx8_1 th1 = new ThreadEx8_1();
		ThreadEx8_2 th2 = new ThreadEx8_2();
		th1.start();
		th2.start();

//		try {
////			th1.sleep(2000); // th1을 2초동안 잠자게?? 아니다. static메서드라 자는건 main쓰레드였어.
//			Thread.sleep(2000);
//		} catch(InterruptedException e) {}

		delay(2000);

		System.out.print("<<main 종료>>");
	} // main

	
	
	
	static void delay(long millis) {
		try {
//			th1.sleep(2000); // th1을 2초동안 잠자게?? 아니다. static메서드라 자는건 main쓰레드였어.
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}



class ThreadEx8_1 extends Thread {
	public void run() {
//		try {
//			ThreadEx8_1.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//		}
		for (int i = 0; i < 300; i++)
			System.out.print("-");
		System.out.print("<<th1종료>>");
	} // run()
}



class ThreadEx8_2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++)
			System.out.print("|");
		System.out.print("<<th2 종료>>");
	} // run()
}