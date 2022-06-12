package ch14_2_Stream;

public class test {
	public static void main(String[] args) {
		String[] strArr = {"aaa","bb","c","dddd","dfdfd"}; //10
		
		
		int sum = 0;
		for(int i=0 ; i < strArr.length ; i++) {
			sum += strArr[i].length();
		}
		System.out.println(sum);
	}

}
