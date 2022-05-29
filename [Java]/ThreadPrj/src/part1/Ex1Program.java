package part1;

public class Ex1Program {

	public static void main(String[] args) {
//		print("sub1");
//		print("sub2");
//		print("main");
		
		print1();
		print2();
		for(int i=0;i<100;i++) {
			System.out.printf("%s: %3d\n", "main", i+1);
		}
	}
	
	

	
	
	private static void print(String s) {
		for(int i=0;i<100;i++) {
			System.out.printf("%s: %3d\n", s, i+1);
		}
	}
	
	private static void print1() {
		for(int i=0;i<100;i++) {
			System.out.printf("sub1: %d\n", i+1);
		}
	}

	private static void print2() {
		for(int i=0;i<100;i++) {
			System.out.printf("sub2: %d\n", i+1);
		}		
	}

}
