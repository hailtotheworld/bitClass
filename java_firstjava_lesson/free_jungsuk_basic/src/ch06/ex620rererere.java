package ch06;

public class ex620rererere {
	
	static int max(int[] arr) {
		if(arr==null||arr.length==0) {
			return -999999;
		}
		
		
		int max = arr[0];
		for (int i =1;i<arr.length;i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
			
		}
		
		return max;
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,100,4,-10,5000};
		System.out.println(max(arr));
	}

}
