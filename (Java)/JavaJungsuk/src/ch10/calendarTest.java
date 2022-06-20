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

		Calendar t1 = Calendar.getInstance();
		Calendar t2 = Calendar.getInstance();

		t2.set(2022, 4, 20, 22, 24);

		long def = (t1.getTimeInMillis() - t2.getTimeInMillis()) / 1000;

		System.out.println(def);

		long dd = def / (60 * 60 * 24);
		System.out.println(dd);

	}

}

class ss {
	final static int X = 10;
	final int k = 15;
	int v;
}
