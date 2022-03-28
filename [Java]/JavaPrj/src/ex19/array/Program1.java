package ex19.array;

public class Program1 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ", nums[i]);
		}

		// 공간이 7개인 배열에 8번째 공간 추가해보기 -> 불가능..!
//		nums[7] = 8; // 배열인덱스범위 벗어나는 오류발생: java.lang.ArrayIndexOutOfBoundsException

		// 더 큰 방으로 이전해야 한다.

	}

}
