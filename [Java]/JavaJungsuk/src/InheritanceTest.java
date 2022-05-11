class MyPoint extends Object {
	int x;
	int y;
}

//class Circle extends MyPoint { // 상속
//	int r;
//
//	@Override
//	public String toString() {
//		return "Circle [r=" + r + ", x=" + x + ", y=" + y + "]";
//	}
//	
//}

class Circle { // 포함
	MyPoint p = new MyPoint();
	int r;
	
	
}

public class InheritanceTest {

	public static void main(String[] args) {
		Circle c = new Circle();
//		c.x = 1;
//		c.y = 2;
//		c.r = 3;
//		System.out.println(c.toString());

		c.p.x = 7;
		c.p.y = 8;
		c.r = 9;
		System.out.println("x="+c.p.x+",y="+c.p.y+",r="+c.r);

	}

}
