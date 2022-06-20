import java.util.Arrays;

public class Ex5_5test {
	public static void main(String[] args) {
		int[] ball = new int[45];
		
		for(int i=0;i<ball.length;i++) {
			ball[i]=i+1;
		}
		
		for(int i=0;i<6;i++) {
			int tmp;
			int ran = (int) (Math.random()*45);
			tmp = ball[i];
			ball[i] = ball[ran];
			ball[ran] = tmp;
		}
		
		System.out.println(Arrays.toString(ball));
		
		for(int i=0;i<6;i++) {
			System.out.println(ball[i]);
		}
		
	}

	}


