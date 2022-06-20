package ch02;

public class dTemp {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int z = 3;

		// 문제 시작
		int temp;
		temp = x;
		x = y;
		y = z;
		z = temp;
		
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
		}

}
