package part2;

import java.sql.Timestamp;

public class Ex4Program_reentrantLock {

	public static void main(String[] args) {
		
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		System.out.println(time1);
		
		CharList2 list = new CharList2();

		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<80;i++)
					list.printNext();
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

		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Timestamp time2 = new Timestamp(System.currentTimeMillis());
		System.out.println(time2);
		System.out.println(time2.getTime()-time1.getTime());
		
		System.out.println("============Exit============");
		
	}

}
