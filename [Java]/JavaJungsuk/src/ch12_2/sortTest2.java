package ch12_2;

import java.util.ArrayList;
import java.util.Collections;

public class sortTest2 {
	public static void main(String[] args) {
		
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		Collections.addAll(intlist, 4,1,7,2,5);
		Collections.sort(intlist);
		System.out.println(intlist);
		
		ArrayList<String> strlist = new ArrayList<String>();
		Collections.addAll(strlist, "4","1","7","2","5");
		Collections.sort(strlist);
		System.out.println(strlist);
		
		ArrayList<tt> ttlist = new ArrayList<tt>();
		Collections.addAll(ttlist, new tt(), new tt());
//		Collections.sort(ttlist);
//		System.out.println(ttlist);
		Collections.sort(ttlist,Collections.reverseOrder());
		System.out.println(ttlist);
		

		
		
		
		
	}

}



class jo<T> implements Comparable<T>
{

	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}}

class tt extends jo
{}

class jk {}