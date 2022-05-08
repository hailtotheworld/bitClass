import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
		System.out.println(arr[0]);
		System.out.println(arr[0].toString()); // 주소가 나온다.
		System.out.println(Arrays.toString(arr[0])); // [1, 2, 3]


		int[] arr2 = new int[] { 1, 2, 3, 7 };
		System.out.println(arr2.toString());
		System.out.println(Arrays.toString(arr2));

	}
}