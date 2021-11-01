package ch06;

public class ex66 {
	int x; // 인스턴스 변수
	int y; // 인스턴스 변수

	ex66(int x, int y) {
		this.x = x;
		this.y = y;
	}

	double getDistance(int x1, int y1) { // 인스턴스 메서드
		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1)); // x, y는 인스턴스 변수
	}
}

class Exercise6_6 {
	public static void main(String args[]) {
		ex66 p = new ex66(1, 1);
		// p (2,2) . 와 의 거리를 구한다
		System.out.println(p.getDistance(2, 2));
	}
}
