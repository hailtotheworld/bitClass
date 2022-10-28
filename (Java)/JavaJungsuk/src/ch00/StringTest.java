package ch00;
import java.util.StringJoiner;

public class StringTest {

	public static void main(String[] args) {
		
		String str1 = "abc";
		String str2 = "abc";
		
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		System.out.println(str1==str2);
		System.out.println(str3==str4);
		
		System.out.println(str1.equals(str2));
		System.out.println(str3.equals(str4));

		
		String[] str11 = {"aaa","bbb","ccc"};
		
		// [aaa,bbb,ccc]
		
		StringJoiner sj = new StringJoiner(",","[","]");
		
		sj.add("123");
		sj.add("456");
		sj.add("789");
		
		System.out.println(sj);
		
		
		
	}
}