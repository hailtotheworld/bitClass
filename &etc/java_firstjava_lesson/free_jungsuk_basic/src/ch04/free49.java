package ch04;

public class free49 {
	public static void main(String[] args) {
		
		int num = 12345;
		int sum = 0;
		
		for(int i=0;num>0;i++) {
			sum += num%10;
			num/=10;
		}
		
		System.out.println(sum);

	
	
	}
	

}
