package ch00;

public class enhancedFor {
	
	public static void main(String[] args) {
		int arr[] = new int[10];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
		}
		
		int sum=0;
		for(int tmp:arr) {
			System.out.println(tmp);
			sum+=tmp;
		}
		
		System.out.println(sum);
		
	}

}
