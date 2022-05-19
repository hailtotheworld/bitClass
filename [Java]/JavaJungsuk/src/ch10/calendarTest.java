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
		
		ss.X=15;
		
		
	}

}

class ss {
	static int X = 10;
	int v;
}
