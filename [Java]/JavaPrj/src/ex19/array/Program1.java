package ex19.array;

public class Program1 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ", nums[i]);
		}

		// 공간이 7개인 배열에 8번째 공간 추가해보기 -> 불가능..!
//		nums[7] = 8; // 배열인덱스범위 벗어나는 오류발생: java.lang.ArrayIndexOutOfBoundsException

		System.out.println("\n---------------------------");

		// 더 큰 방으로 이전해야 한다.///////////////////////////////////////////////

		// 1) 임시방 temp를 만든다
		int[] temp = new int[10];

		// 2) nums의 배열 내용들을 임시방으로 이동시킨다.
		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}

		// 3) 임시방의 참조변수를 nums참조변수에게 전달한다.
		nums = temp;

		nums[7] = 8;

		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ", nums[i]);
		}

		
		

	}

}
