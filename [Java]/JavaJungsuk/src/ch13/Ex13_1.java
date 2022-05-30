package ch13;

class Ex13_1 {
	public static void main(String args[]) {
		ThreadEx1_1 t1 = new ThreadEx1_1();

		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);	  // 생성자 Thread(Runnable target)

		// cf. 순차적으로 실행되는게 동기식실행
		
		t1.start();
		t2.start(); // 쓰레드는 비동기식실행
	}
}

class ThreadEx1_1 extends Thread { // Thread클래스를 상속해서 쓰레드를 구현
	public void run() { // 쓰레드가 수행할 작업을 작성
		setName("0");
		
		for(int i=0; i < 500; i++) {
			System.out.print(this.getName()); // 조상인 Thread의 getName()을 호출
//			System.out.println(Thread.currentThread().getName()); // 당연히 현재 실행중인 Thread를 반환해서도 가능
		}
	}
}

class ThreadEx1_2 implements Runnable { // Runnable인터페이스를 구현해서 쓰레드를 구현
	public void run() {
		for(int i=0; i < 500; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			Thread.currentThread().setName("1");
			System.out.print(Thread.currentThread().getName());
		}
	}
}