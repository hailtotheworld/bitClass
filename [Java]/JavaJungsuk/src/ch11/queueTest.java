package ch11;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class queueTest {
	public static void main(String[] args) {
		
		
		Queue q = new LinkedList();
		
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		
			

		
		Iterator it = q.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}


		
	}

}
