package ch12;

import java.util.ArrayList;

class Product7 {}
class Tv7 extends Product7{}
class Audio7 extends Product7 {}

public class gTest {
	public static void main(String[] args) {
		ArrayList<? extends Product7> list = new ArrayList<Tv7>();
//		ArrayList<? extends Product7> list = new ArrayList<Audio7>(); 당연하지 오류잖아.
	}

}
