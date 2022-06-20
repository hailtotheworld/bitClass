package ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class starTest {
	public static void main(String[] args) {

				
		/*
		 * *1
		 * **2
		 * ***3
		 * ****4
		 * *****5
		 * *7
		 */
		
		int[] arr = new int[] {1,10,2,6,4,5,7};
		
		
		// char[arr[1]] 1
		// char[arr[2]] 10개짜리 char배열생성
		// char[] chi = new char[];
		
		
		
		
		
		
		
		for(int i : arr) {
			char[] chi = new char[i];
			Arrays.fill(chi, '*');
			System.out.println(chi);
		}
		

	}

}
