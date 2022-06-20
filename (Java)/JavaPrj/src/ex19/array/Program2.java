package ex19.array;

public class Program2 {

	public static void main(String[] args) {

		// 배열 합치기////////////////////////////////////////////////////////////
		int[] num1 = { 1, 2, 3, 4, 5 };
		int[] num2 = { 6, 7, 8, 9 };
		int[] nums = new int[9];
		
		
		for (int i=0;i<num1.length;i++)
			nums[i]=num1[i];
		
		for(int i=0;i<num2.length;i++)
			nums[i+num1.length]=num2[i];

		for (int i = 0; i < nums.length; i++)
			System.out.printf("%d ", nums[i]);

	}

}
