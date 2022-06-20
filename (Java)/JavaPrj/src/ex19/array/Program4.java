package ex19.array;


public class Program4 {

	public static void main(String[] args) {

		int[] nums = { 2,3,6,4,1,5 };
		
		int temp = nums[0];
		nums[0]=nums[1];
		nums[1]=temp;
		
		for(int i=0;i<nums.length;i++) {
			System.out.printf("%d ", nums[i]);
		}


		
		
		
	}

}
