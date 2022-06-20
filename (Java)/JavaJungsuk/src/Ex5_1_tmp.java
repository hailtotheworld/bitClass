import java.util.Arrays;

public class Ex5_1_tmp {
	public static void main(String[] args) {
		
		
		// 값보기
		int[] arr = {0,1,2,3,4};
		int[][] arr2D = {{11,12},{21,22}};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr2D));
		
		// 값 똑같은지 확인하기
		String[][] str2D  = {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = {{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println(str2D==str2D2); // 주소를 비교하니까 false
		System.out.println(str2D.equals(str2D2)); // Object클래스의 equals니까 주소비교해서 false
		System.out.println(Arrays.equals(str2D, str2D2)); // 다차원배열이니까 deepEquals() 써야지.
		System.out.println(Arrays.deepEquals(str2D, str2D2)); // 다차원배열 값비교 deepEquals()
		
		// 복사하기		
		int[] arr2 = Arrays.copyOf(arr, 7);
		int[] arr3 = Arrays.copyOfRange(arr, 2, 4);
		
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println();
		
		// 정렬하기
		int[] arr4 = {4,5,1,2,8,0};
		
		System.out.println(Arrays.toString(arr4));
		Arrays.sort(arr4); // 배열을 오름차순으로 정렬
		System.out.println(Arrays.toString(arr4));


		
		
	}

}
