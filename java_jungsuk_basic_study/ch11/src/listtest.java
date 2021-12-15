import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class listtest {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		LinkedList link = new LinkedList();
		
		link.add(6);
		link.add(7);
		link.add(8);
		link.add(9);
		link.add(10);
		
		System.out.println(link);
		
	}

}
