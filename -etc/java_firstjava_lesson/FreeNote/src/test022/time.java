package test022;

import java.sql.Timestamp;
import java.util.Calendar;

import oracle.sql.TIMESTAMP;

public class time {

	public static void main(String[] args) {
		
	
		String now = "2009-03-20 10:20:30.0"; // 형식을 지켜야 함
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);

		System.out.println(t);
		
		Calendar cal = Calendar.getInstance( );


	    String s = String.format("%04d-%02d-%02d %02d:%02d:%02d",
	                                 cal.get(Calendar.YEAR),
	                                 (cal.get(Calendar.MONTH) + 1),
	                                 cal.get(Calendar.DAY_OF_MONTH),

	                                 cal.get(Calendar.HOUR_OF_DAY),
	                                 cal.get(Calendar.MINUTE),
	                                 cal.get(Calendar.SECOND)
	                             );

	    System.out.println(s);

	  

}
}
