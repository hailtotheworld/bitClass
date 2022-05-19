package ch10;

import java.util.Calendar;

public class calendarTest {
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(Calendar.YEAR);
	}

}
