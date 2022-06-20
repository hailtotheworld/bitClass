package ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Ex11_17 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("김자바", 90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);

//		Set<Entry<String, Integer>> set = map.entrySet();
//		Iterator<Entry<String, Integer>> it = set.iterator();
		
		Set<String> s = map.keySet();
		Iterator<String> it = s.iterator();
		
//		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}		
		System.out.println();
		
		
		
		
		Iterator<Integer> it2 = map.values().iterator();
		
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println();

		
		
		
//		Set set = map.entrySet();
//		Iterator it3 = set.iterator();
		Iterator it3 = map.entrySet().iterator();
		
		while(it3.hasNext()) {
			Map.Entry e = (Entry) it3.next();
			System.out.println(e);
		}
		
//		Set<Entry<String, Integer>> set1 = map.entrySet();
//		Iterator<Entry<String, Integer>> it4 = set1.iterator();
		
		Iterator<Entry<String, Integer>> it4 = map.entrySet().iterator();
		
		while(it4.hasNext()) {
			Map.Entry e = it4.next();
			System.out.println(e);
		}
		
		
//		Iterator<Entry<String, Integer>> it3 = map.entrySet().iterator();
		
//		while(it3.hasNext()) {
//			Map.Entry<String, Integer> e = it3.next();
//			
//		}
		
		
//		while(it.hasNext()) {
//			Map.Entry e = (Map.Entry) it.next();
//			System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
//		}

		
		
//		set = map.keySet();
//		System.out.println("참가자 명단 : " + set);
//
//		Collection values = map.values();
//		it = values.iterator();
//
//		int total = 0;
//		
//		while(it.hasNext()) {
//			int i = (int)it.next();
//			total += i;
//		}
//
//		System.out.println("총점 : " + total);
//		System.out.println("평균 : " + (float)total/set.size());
//		System.out.println("최고점수 : " + Collections.max(values));
//		System.out.println("최저점수 : " + Collections.min(values));
	}
}