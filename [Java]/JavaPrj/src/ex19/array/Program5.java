package ex19.array;

import java.util.Random;

public class Program5 {

	public static void main(String[] args) {

//		System.out.println((int)(Math.random()*45)+1);
//		
//		int[] arr = new int[6];
//		
//		for (int i=0;i<arr.length;i++) {
//			arr[i] = (int)(Math.random()*45)+1;
//		}
//		
//		for (int i=0;i<arr.length;i++) {
//			System.out.printf("%d ",arr[i]);
//		}

		int[] lotto = new int[6];

		Random rand = new Random();

		System.out.println(rand.nextInt(45) + 1); // 1<=x<45

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rand.nextInt(45) + 1;
		}

		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("%d ", lotto[i]);
		}

	}

}
