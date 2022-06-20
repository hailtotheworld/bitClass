package ch12;

import java.util.ArrayList;


class Tv1 {}
class Audio1 {}

public class GenericTest2 {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList(); // Tv타입의 객체만 저장가능
//		ArrayList<Tv> list = new ArrayList<Tv>(); // Tv타입의 객체만 저장가능
		
		list.add(new Tv1());
//		list.add(new Audio());
		
		
		Tv1 t = (Tv1) list.get(0);
	}

}
