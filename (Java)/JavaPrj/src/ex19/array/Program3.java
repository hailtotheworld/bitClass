package ex19.array;

import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {

		// nums 배열에서 숫자 1을 찾고 그 위치 인덱스를 출력하시오.

		Scanner scan = new Scanner(System.in);

		int[] nums = { 5, 2, 7, 4, 6, 1, 3 };

		int index = -1;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==1) {
				index = i;
				break;
			}
		}
		
		System.out.printf("index is %d\n",index+1);

		
	}

}
