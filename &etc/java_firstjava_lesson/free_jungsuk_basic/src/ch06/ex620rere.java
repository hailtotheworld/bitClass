package ch06;

public class ex620rere {
	
	static int max(int[] arr) {
		if(arr==null||arr.length==0) {
			return -999999;
		}
		
		int max = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				
			}
			

		}
		return max;




		

	}
	
	public static void main(String[] args) {
		int[] data = {1,2,100,50,4,-2,5000};
		
		System.out.println(max(data));
	}

	
	
	
	
}


