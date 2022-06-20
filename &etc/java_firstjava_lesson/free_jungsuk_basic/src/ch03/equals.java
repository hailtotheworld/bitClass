package ch03;

public class equals {
	public static void main(String[] args) {
		String str = "abs";
		String str2 = new String("aBs");
		
		boolean result = str.equals(str2);
		System.out.println(result);
		
		System.out.printf("%b",str.equalsIgnoreCase(str2));
		
		
		// str.equals(str2)


	}

}
