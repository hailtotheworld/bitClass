package part1;

public class Ex8Program_thread_group {

	public static void main(String[] args) {

		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				print();
			}
		};
		
		ThreadGroup thGroup = new ThreadGroup("print main group");
		ThreadGroup thGroup1 = new ThreadGroup(thGroup,"print sub group1");
		ThreadGroup thGroup2 = new ThreadGroup(thGroup,"print sub group2");

		Thread th1 = new Thread(thGroup1, subMain);
		th1.setName("sub1");
		Thread th2 = new Thread(thGroup1, subMain);
		th2.setName("sub2");
		Thread th3 = new Thread(thGroup1, subMain);
		th3.setName("sub3");
		Thread th4 = new Thread(thGroup2, subMain);
		th4.setName("sub4");
		Thread th5 = new Thread(thGroup2, subMain);
		th5.setName("sub5");
		Thread th6 = new Thread(thGroup2, subMain);
		th6.setName("sub6");

		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();

		Thread th = Thread.currentThread();
		th.setName("Main3");
//		print();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		thGroup.list();
		thGroup.interrupt();
		
		
		System.out.println("============Exit============");
	}

	private static void print() {
		Thread th = Thread.currentThread();
		for (int i = 0; i < 100; i++) {
			
			if(th.isInterrupted()) {
				System.err.println("요청이 들어와서 종료함");
				return;
			}

//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
////				e.printStackTrace();
//				System.err.println("자다가 깨서 스레드를 종료함");
//				break;
//			}

			if (th.getName().equals("Main3")) 
				System.out.printf("<%s[%d]: %d>\n", th.getName(), th.getId(), i + 1);
			else
				System.out.printf("%s[%d]: %d\n", th.getName(), th.getId(), i + 1);
		}
		
		System.err.println("나갔다~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
