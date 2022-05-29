package part1;

public class Test {
	public static void main(String[] args) {
		Thread th = Thread.currentThread();
		th.setName("hi");
		System.out.println(th);
	}

}
