package ch06;

public class ex618rererere {
	
	static boolean isNumer(String str) {
		if(str==null||str.equals("")) {
			return false;
		}
		
		
		for(int i=0;i<str.length();i++) {
		char ch = str.charAt(i);
		
		if(!(ch>='0'&&ch<='9')) {
			return false;
		}
		
				
		}
		return true;
		
		
		
	}
	
	public static void main(String[] args) {
		String str = "123d";
		System.out.println(isNumer(str));
	}

}
