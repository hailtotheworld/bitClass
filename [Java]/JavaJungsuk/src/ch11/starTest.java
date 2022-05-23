package ch11;

import java.util.Arrays;

public class starTest {
	public static void main(String[] args) {
		
		int[] arr = new int[]{3,7,8,9,10,2,1,4};
		
		/*
		 **
		 ******
		 ********
		 *****
		 ***
		 **
		 *****
		 
		 */

		
		for(int i : arr) {
			char[] c = new char[i];
			Arrays.fill(c, '*');
			System.out.println(c);
		}
		
		
		
		

	}

}
