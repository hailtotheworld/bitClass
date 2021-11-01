package ch06;

public class ex621 {
	
	static int abs(int value) {
		
		if(value < 0) {
			return -value;
		} else {
			return value;
		}
	}
	
	
		public static void main(String[] args) {
			
			int value = -5;
			
			System.out.println(abs(value));
			
			
		}

}
