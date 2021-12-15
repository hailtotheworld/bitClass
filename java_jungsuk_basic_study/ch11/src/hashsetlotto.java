import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class hashsetlotto {
	public static void main(String[] args) {
		
		HashSet hs = new HashSet(6);
		
		// 값을 반복해서 넣어야 한다.
		for(int i=0; hs.size()<6; i++) {
			int ran = (int) (Math.random()*45)+1;
			hs.add(new Integer(ran));
		}

		LinkedList list = new LinkedList(hs);
		Collections.sort(list);
		System.out.println(list);
		
	}
	

	
}
