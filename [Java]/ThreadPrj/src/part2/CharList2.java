package part2;

import java.util.concurrent.locks.ReentrantLock;

public class CharList2 {
	private char[] list;
	private int index;
//	private Object indexLock = new Object();
	private ReentrantLock indexLock;
	
	public CharList2() {
		indexLock = new ReentrantLock();
		list = new char[240];
		for (int i = 0; i < list.length; i++) {
			list[i] = (char) i;
		}
		index = 0;
	}

	
	
	public void printNext() {
		Thread th = Thread.currentThread();

		char ch = list[index];
		


			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				System.err.println("자다가 깨서 스레드를 종료함");
				return;
			}

		
		
		if(indexLock.tryLock()) {
//		indexLock.lock();
//		synchronized (indexLock) {			
			System.out.printf("%s[%d]: index:%d, char:%c\n",
					th.getName(), th.getId(), index, list[index]);
			
			index++;
			indexLock.unlock();
//		}
		} else {
			System.out.printf("%s[%d]: alternate...\n",
					th.getName(), th.getId());
			
		}
		
		



	}

}
