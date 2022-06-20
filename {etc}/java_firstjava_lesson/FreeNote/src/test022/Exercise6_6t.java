package test022;

public class Exercise6_6t {
	int x; // 인스턴스 변수
	int y; // 인스턴스 변수

	Exercise6_6t(int x, int y) {
	this.x = x;
	this.y = y;
	}

	double getDistance(int x1, int y1) {
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
	

}

class Exercise6_6tt {
	
	public static void main(String args[]) {
		Exercise6_6t p = new Exercise6_6t(1, 1);
		// p (2,2) . 와 의 거리를 구한다
		System.out.println(p.getDistance(2, 2));
}

	}
