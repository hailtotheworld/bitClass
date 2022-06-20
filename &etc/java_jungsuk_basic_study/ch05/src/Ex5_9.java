class Ex5_9 {
	public static void main(String[] args) {
		 int[][] score = {
							  { 100, 100, 100}
							, { 20, 20, 20}
							, { 30, 30, 30}
							, { 40, 40, 40}
							, { 50, 50, 50}
						};
		 
		 System.out.println("번호 국어 영어 수학 총점 평균");
		 System.out.println("======================");
		 
		 int Tkor = 0,Teng=0, Tmath=0;
		 
		 for(int i=0;i<score.length;i++) {
			 System.out.printf("%3d",i+1);
			 int sum =0;
			 
			 Tkor += score[i][0];	
			 Teng += score[i][1];			 
			 Tmath += score[i][2];			 

			 
			 for(int j=0;j<score[j].length;j++) {
				 sum += score[i][j];
				 System.out.printf("%4d", score[i][j]);
			 }
			 
			 float avg = sum/(float)score[i].length;
			 System.out.printf("%4d", sum);
			 System.out.printf("%6.1f%n", avg);
			 
		 }
		 
		 System.out.println("======================");
		 System.out.printf("%5d %5d %5d", Tkor, Teng, Tmath);
		 

		 
		 
		 

	}
}