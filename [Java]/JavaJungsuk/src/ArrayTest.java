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
		
		Object[] ob = new Object[6];
		ob[0]=true;
		ob[1]='c';
		ob[2]=100;
		ob[3]=10.5;
		ob[4]="string";
		ob[5]=new p();
		
		for(Object tmp:ob) {
			System.out.println(tmp);
		}
		
		
				

	}
}

class p {}