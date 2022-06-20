package exam;
/*
문제 1.
int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
public static int miniValue(int[] arr) { . . . . } // 최소값 반환
public static int maxValue(int[] arr) { . . . . } // 최대값 반환
​위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
두 매소드 실행을 확인인하기 위한 main 메소드 정의.
int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
임의로 결정
*/
public class ArrayTest {
	public static void main(String[] args) {
		
		// 배열 생성
		int[] arr = {100,40,100,60,150,900,-30,200};
		int[] arr2 = {100,240,200};
		
		System.out.println("최대값: " + maxValue(arr2));
		System.out.println("최소값: " + minValue(arr2));

	
	}
	
	
	// 최소값 반환
	public static int minValue(int[] arr) {
		// 최소값
		int minVal = arr[0]; // 처음값을 최소값으로 등록
		// 각 요소의 값과 최소값들을 비교 후 새로운 값이 더 작을 때 최소값을 저장
		// 전달받은 배열의 사이즈만큼 반복하면서 비교
		for (int i=0; i < arr.length; i++) {
			if(arr[i]<minVal) {
				minVal = arr[i];
			}
		}
		return minVal;
	} 
	
	
	// 최대값 반환
	public static int maxValue(int[] arr) { 
		// 최대값
		int maxVal=arr[0];
		
		for(int i=1; i < arr.length; i++) {
			if(arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}
		
		return maxVal;

		
	} 

	
}
