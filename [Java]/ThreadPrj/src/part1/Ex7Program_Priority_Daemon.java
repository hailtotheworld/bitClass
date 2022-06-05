package part1;

public class Ex7Program_Priority_Daemon {

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

		th2.setPriority(Thread.MIN_PRIORITY);
		th2.setDaemon(true); //
		
		th1.start();
		th2.start();

		Thread th = Thread.currentThread();
		th.setName("Main3");
		print();
		
		System.out.println("============Exit============");
	}

	private static void print() {
		for (int i = 0; i < 100; i++) {
			Thread th = Thread.currentThread();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (th.getName().equals("Main3")) 
				System.out.printf("<%s[%d]: %d>\n", th.getName(), th.getId(), i + 1);
			else
				System.out.printf("%s[%d]: %d\n", th.getName(), th.getId(), i + 1);
		}
	}

}
