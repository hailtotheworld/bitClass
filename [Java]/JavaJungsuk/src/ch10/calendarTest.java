package ch10;

import java.util.Calendar;

public class calendarTest {
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		
		
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(today.YEAR));
		System.out.println(today.YEAR);
		System.out.println(Calendar.YEAR);
		
		ss s1 = new ss();
		ss s2 = new ss();
		
		System.out.println(s1.k);
		
		
		
		
		
	}

} 

class ss {
	final static int X = 10;
	final int k=15;
	int v;
}
