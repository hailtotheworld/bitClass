package ch05;

import java.util.Scanner;

public class freeeeeeeeeeeeee {
	public static void main(String[] args) {
	
		
		
		String[] words = {"television", "computer", "mouse", "phone"};
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0;i<words.length;i++) {
			char[] question = words[i].toCharArray();
			
			for(int j=0;j<question.length;j++) {
				int idx = (int) (Math.random()*question.length);
				
				char temp = question[i];
				question[i] = question[idx];
				question[idx] = temp;
			}
			
			
		}
		
		
	} 
} 