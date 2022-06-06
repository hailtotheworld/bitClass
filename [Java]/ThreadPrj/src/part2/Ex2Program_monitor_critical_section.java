package part2;

public class Ex2Program_monitor_critical_section {

	public static void main(String[] args) {

		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				print();
			}
		};

		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		Thread th2 = new Thread(subMain);
		th2.setName("sub2");
		Thread th3 = new Thread(subMain);
		th3.setName("sub3");

		th1.start();
		th2.start();
		th3.start();

		Thread th = Thread.currentThread();
		th.setName("Main3");
//		print();

//		thGroup.interrupt();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("============Exit============");
	}

	
	static Object lockIndex = new Object();
	static int gIndex = 0; // 데이터/정적. 모든스레드가 공유하는변수

	private static void print() {

		int index = 0; // 스택

		Thread th = Thread.currentThread();
		for (int i = 0; i < 100; i++) {

			if (th.isInterrupted()) {
				System.err.println("요청이 들어와서 종료함");
				return;
			}

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
//				e.printStackTrace();
				System.err.println("자다가 깨서 스레드를 종료함");
				return;
			}

			// lock으로 잠금을 해야하는 상황
			synchronized (lockIndex) { // lockIndex를 소유하고 있는 스레드가 임계영역에 들어올 수 있는거야	
				
				index++;
				gIndex++;
				
				System.out.printf("%s[%d]: %d, index:%d, gIndex:%d\n", th.getName(), th.getId(), i + 1, index, gIndex);
			}
			
		}

		System.err.println("나갔다~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
