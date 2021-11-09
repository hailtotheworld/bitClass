package ch06;

public class ex618rerererere {
	
	static boolean isNumber(String str) {
		if (str==null||str.equals("")) {
			return false;
		}
		
		
		for (int i=0;i<str.length();i++) {
			if(!(str.charAt(i)>='0'&&str.charAt(i)<='9')) {
				return false;
			}
		}
		
		
		return true;
		
	}
	
	public static void main(String[] args) {
		String str = "123d";
		System.out.println(isNumber(str));
	}

}
