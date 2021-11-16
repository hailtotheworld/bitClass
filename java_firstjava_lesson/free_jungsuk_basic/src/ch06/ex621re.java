package ch06;

public class ex621re {
	
	static int abs(int value) {
		if(value>0) {
			return value;
		} else if(value<0) {
			return  -value;
		} else {
			return  0;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(abs(-5));
		System.out.println(abs(0));
	}
	
	

}
