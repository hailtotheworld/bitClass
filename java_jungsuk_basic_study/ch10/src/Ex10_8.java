import java.util.*;
import java.text.*;

class Ex10_8 {
	public static void main(String[] args) throws ParseException {
		Date birth = new Date(119, 9, 29);
		
		

		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;

		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

		sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
		sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
		sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
		sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");

		System.out.println(sdf1.format(birth));	// format(Date d)
		System.out.println(sdf2.format(birth));
		System.out.println(sdf3.format(birth));
		System.out.println(sdf4.format(birth));
		System.out.println();
		System.out.println(sdf5.format(birth));
		System.out.println(sdf6.format(birth));
		System.out.println(sdf7.format(birth));
		System.out.println(sdf8.format(birth));
		System.out.println(sdf9.format(birth));
		
		//2020년11월30일 => 2020.11.30
		
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy년MM월dd일");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
		
		
		Date date = sf1.parse("2020년11월30일");
		
		System.out.println(sf.format(date));
		
		
//		Date date1 = sf.format(date);
		
		
		
		
	}
}