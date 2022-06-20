package ch03;

public class fecdegree {
	public static void main(String[] args) {
		
		
		int fe = 100;
		
		float c = (float) (5/9f*(fe-32)*100+0.5);
		
		// 1. 5/9f*(fe-32) = 37.77778
		// 2. 5/9f*(fe-32)*100 = 3777.7788
		// 3. 5/9f*(fe-32)*100+0.5 ★왜 계산이 안되는거지??? f+0.5
		// 4. (int) (5/9f*(fe-32)*100+0.5) = 3778.0
		// 5. (int) (5/9f*(fe-32)*100+0.5)/100f
		
		
		
		System.out.println(fe);
		
		System.out.println(c);
	
		
		
		
	}
	

}
