
public class Ex5_2test {
	public static void main(String[] args) {
		
		int[] score = {100,88,100,100,90};
		
		int sum = 0;
		
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		
		System.out.println(sum);
		
		float avg = sum/(float) score.length;
		
		System.out.println(avg);
		
	}

}
