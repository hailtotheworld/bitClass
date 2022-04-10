package com.newlecture.app.util;

public class Program {

	public static void main(String[] args) {
		GList<Integer> list = new GList<>();

		list.add(3);
		list.add(5);
		int size = list.size();
		System.out.printf("size : %d\n", size);
		
		list.clear();
		size = list.size();
		System.out.printf("size : %d\n", size);
		
		list.add(7);
		int num = list.get(0);
		// Object형을 반환되고 있으니까 형변환해줘야지
		// Integer로 형변환하면 AutoUnboxing되서 Int로 바뀐다.
		System.out.printf("num : %d\n", num);
//		num = (Integer) list.get(1);


	}

}
 