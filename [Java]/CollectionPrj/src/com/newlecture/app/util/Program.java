package com.newlecture.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
//		GList<Integer> list = new GList<>();

		// 데이터를 배열처럼 관리하고 싶다면 가변길이의 배열을 마련하고 싶다면 ArrayList
		List<Integer> list = new ArrayList<>();
		list.add(3); // index0
		list.add(5); // index1
		list.add(6); // index2
		list.add(7); // index3
		list.add(7); // index4
		list.add(7); // index5
		System.out.println(list.get(3));
		System.out.println(list.size());

		// 데이터를 수집할 때 중복을 제거하는 데이터 수집이 필요하면 HashSet
		// 값 자체가 키가된다. 이미 있는값이 또 들어가면 받아지지 않는다.
		// 중복제거용으로 사용한다. eg)로또복권 만들때 중복값을 허용하면 안돼
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(7);
		set.add(7);
		System.out.println(set.add(7)); // 이미 있는값이 들어가니 false가 나오네
		System.out.println(set.add(8)); // 기존에 없는값이 들어가니 true가 나오제
		System.out.println(set.size());

		// 속성을 갖고 있는 개체를 클래스로 정의해서 써야하는데
		// 클래스를 정의하지 않고 속성과 값으로 구분된 데이터집합의 객체를 필요로할때 HashMap
		// Map(Key, Value) 식별자가 스스로 값을 갖고 있다.
		Map<String, Object> map = new HashMap<>();
		map.put("id", 3); // put(속성, 값)
		map.put("title", "Hello");
		map.put("hit", "12");
		System.out.println(map.get("id")); // 3 // 키값을 알려줄테니 value주세요.
		System.out.println(map.get("title"));// Hello

		System.out.println("--------------------------------");

		list.clear();
//		size = list.size();
//		System.out.printf("size : %d\n", size);

		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);

		int num = list.get(3);
		// Object형을 반환되고 있으니까 형변환해줘야지
		// Integer로 형변환하면 AutoUnboxing되서 Int로 바뀐다.
		System.out.printf("num : %d\n", num);
//		num = (Integer) list.get(1);

		System.out.println(list.size());

	}

}