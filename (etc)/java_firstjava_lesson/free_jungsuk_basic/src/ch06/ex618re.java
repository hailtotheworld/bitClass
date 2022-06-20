package ch06;

public class ex618re {
	
	static boolean isNumber(String str) {
		if(str==null||str.equals("")) {
			return false;
		}
		
		for(int i=0;i<str.length();i++) {
			char[] ch = str.toCharArray();
			
			if(!(ch[i]>='0'&&ch[i]<='9')) {
				return false;
			}
			
		}
		return true;


		
	}
	
	
	public static void main(String[] args) {
		String str = "1254";
		System.out.println(isNumber(str));
	}
	
	
	
	

}
