package ch06;

public class ex618 {

	static boolean isNumber(String str) {
		if (str == null && str.equals("")) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		String str = "d1";
		System.out.println(isNumber(str));
	}

}
