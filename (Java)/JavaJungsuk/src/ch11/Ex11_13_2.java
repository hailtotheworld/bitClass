package ch11;

import java.util.*;

class Ex11_13_2 {
	public static void main(String[] args) {
//		Set set = new TreeSet(); // 정렬기준이 없어서 오류
//		Set set = new HashSet(); // 정렬기준 필요없어서 오류 안남
		Set set = new LinkedHashSet(); // 정렬기준 필요없어서 오류 안남
		
		for (int i = 0; set.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(new rTest());
		}

		System.out.println(set);
	}
}

class rTest {}