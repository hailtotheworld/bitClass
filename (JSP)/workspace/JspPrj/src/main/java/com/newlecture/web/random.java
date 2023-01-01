package com.newlecture.web;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class random {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<Integer>();

		Scanner scan = new Scanner(System.in);
		System.out.println(">");
		int count = scan.nextInt();

		while (set.size() < 10) {
			int num = (int) (Math.random() * count + 1);
			set.add(num);
		}
		System.out.println(set);
	}
}

