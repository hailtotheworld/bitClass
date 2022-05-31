package ch11;

import java.util.*;

public class Ex11_13_3 {
	public static void main(String[] args) {
		Set set = new TreeSet(Collections.reverseOrder());
		
			set.add(new Test());
			

		System.out.println(set);
	}
}

class Test {

}
