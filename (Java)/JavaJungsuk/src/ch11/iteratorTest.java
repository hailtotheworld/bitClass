package ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class iteratorTest {
	public static void main(String[] args) {
		
		HashMap map = new HashMap();

		map.put("id1", "pw11");
		map.put("id2", "pw22");
		map.put("id3", "pw33");
		map.put("id4", "pw44");
		
		 Set set = map.entrySet();
		 
		 Iterator it = set.iterator();
		 
		 while(it.hasNext()) {
			 Entry e = (Entry) it.next();
			 System.out.println(e.getKey());
			 System.out.println(e.getValue());
		 }
		
	}

}
