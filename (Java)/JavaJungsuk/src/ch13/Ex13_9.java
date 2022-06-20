package ch13;

import javax.swing.JOptionPane;

class Ex13_9 {
	public static void main(String[] args) throws Exception {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();

		System.out.println("isInterrupted():"+ th1.isInterrupted()); // false
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt();  // interrupt()를 호출하면, interrupted상태가 true가 된다.
		
//		System.out.println("isInterrupted():"+ th1.isInterrupted()); // true
//		System.out.println("isInterrupted():"+ th1.isInterrupted()); // true
		
		// main쓰레드가 interrupted되었는지 확인
		// static메서드라서 자기자신의 상태를 확인하는구나. th1스레드가 아니고 main스레드의 상태를 확인하는거였어
//		System.out.println("interrupted():"+ Thread.interrupted()); // false
	}
}

class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0;x<2500000000L;x++); // 시간 지연
		}
		System.out.println("isInterrupted():"+ isInterrupted()); // true
		System.out.println("interrupted():"+ Thread.interrupted()); // true
		System.out.println("isInterrupted():"+ isInterrupted()); // false
		System.out.println("카운트가 종료되었습니다.");
	} 
}