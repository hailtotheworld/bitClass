package ch00;
import java.util.ArrayList;

public class BoxTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(new Integer(10));
		list.add(Integer.valueOf(10));
		
		list.add(10); // 오토박싱
		
		System.out.println(list.get(0).intValue());
		
		System.out.println(list.get(1)); // 언박싱
		
		
	}

}
