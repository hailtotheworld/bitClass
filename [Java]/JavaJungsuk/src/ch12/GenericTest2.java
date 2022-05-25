package ch12;

import java.util.ArrayList;


class Tv {}
class Audio {}

public class GenericTest2 {
	public static void main(String[] args) {
		ArrayList<Tv> list = new ArrayList<Tv>();
		
		list.add(new Tv());
//		list.add(new Audio());
	}

}
