package ch04;

public class ex44 {
	public static void main(String[] args) {
		
		int sum=0;
		int count=0;
		int s = 1;
		
		for(int i=1;true;i++,s=-s) {
			count++;
			sum +=i*s;
			
			if(sum>=100) {
				System.out.println(count);
				break;
			}
		}
		
		
	}

}
