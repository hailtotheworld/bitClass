package part2;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CharList3 {
	private char[] list;
	private ReentrantReadWriteLock listLock;
	private int index;
//	private Object indexLock = new Object();
	private ReentrantLock indexLock;
	
	public CharList3() {
		listLock = new ReentrantReadWriteLock();
		indexLock = new ReentrantLock();
		list = new char[240];

		index = 0;
	}

	public void load() {
		Thread th = Thread.currentThread();
		
		listLock.writeLock().lock();
		for (int i = 0; i < 26; i++) {
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list[i] = (char) ('A'+i);
		}
		
		System.err.printf("%s[%d] : loaded\n", th.getName(), th.getId());
		
		listLock.writeLock().unlock();
		
	}
	
	public void printAll(int count) {
		Thread th = Thread.currentThread();

		listLock.readLock().lock();
		for(int i=0; i < count; i++) {
			StringBuilder builder = new StringBuilder();
			builder.append(list);
			
			builder.toString();
			
			System.out.printf("%s[%d-%d]: %s\n",
					th.getName(), th.getId(), ++index, builder.toString());
		}
		listLock.readLock().unlock();

		
		
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
