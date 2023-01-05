package com.newlecture.web;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class random {

	public static void main(String[] args) {
		/*
		 * Set<Integer> set = new HashSet<Integer>();
		 * 
		 * Scanner scan = new Scanner(System.in); System.out.println(">"); int count =
		 * scan.nextInt();
		 * 
		 * while (set.size() < 10) { int num = (int) (Math.random() * count + 1);
		 * set.add(num); }
		 * 
		 * System.out.println(set);
		 */
		
		Set<Integer> set = new HashSet<Integer>();

		Scanner scan = new Scanner(System.in);
		System.out.println("(작은숫자)이숫자보다큰숫자들을담아봐>");
		int from = scan.nextInt();
		System.out.println("(큰숫자)이숫자보자작은숫자들을담아봐>");
		int to = scan.nextInt();

		int diff = to - from + 1;

		while_true:
		while (true) {
			int num = (int) (Math.random() * diff + from);
			set.add(num);

			if (diff >= 10) {

				if (set.size() >= 10)
					break;
			} else {
				if (set.size() == diff)
					break while_true;
			}
		}

		System.out.println(set);
		if(10-diff > 0) {
			System.out.printf("%d개 부족해", 10-diff);
		}

		

	}
}