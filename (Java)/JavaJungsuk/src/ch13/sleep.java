package ch13;

public class sleep {
	public static void main(String[] args) {
		Thread th1 = new Thread(new tt());
		
		th1.start();
		
		th1.interrupt();
	}

}


class tt implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("충분히자고 깸");
		} catch (InterruptedException e) {
			System.out.println("누가날깨운거야?");
		}
		
		System.out.println("실행되나");
		
	}
	
	
}