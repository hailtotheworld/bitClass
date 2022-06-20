
public class Ex5_4tmp {
	public static void main(String[] args) {
		int[] arr = new int[10];
		System.out.println("arr.length="+arr.length);
		
		for (int i=0;i<11;i++) { //java.lang.ArrayIndexOutOfBoundsException: index범위를 벗어나서 에러
			System.out.println("arr["+i+"]="+arr[i]);
		}
		
	}

}
