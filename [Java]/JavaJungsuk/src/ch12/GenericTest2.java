package ch12;

import java.util.ArrayList;


class Tv {}
class Audio {}

public class GenericTest2 {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList(); // Tv타입의 객체만 저장가능
//		ArrayList<Tv> list = new ArrayList<Tv>(); // Tv타입의 객체만 저장가능
		
		list.add(new Tv());
//		list.add(new Audio());
		
		
		Tv t = (Tv) list.get(0);
	}

}
