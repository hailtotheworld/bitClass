import java.util.Arrays;

public class Ex5_6tmp {
	public static void main(String[] args) {
		int[] iArr = {100,95,80,70,60}; // 길이가 5인 int배열
//		System.out.println(iArr); // 주소값이 나옴, 이렇게 하면 안되.
		
		for (int i=0;i<iArr.length;i++) {
			System.out.println(iArr[i]);
		}
		
		System.out.println(Arrays.toString(iArr));
		

	}

}
