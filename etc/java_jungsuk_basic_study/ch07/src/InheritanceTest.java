class Mypoint {
	int x;
	int y;
}

//class Circle extends Mypoint { //상속
//	int r;
//}

class Circle {
	Mypoint p = new Mypoint();
	int r;
}


public class InheritanceTest {

	public static void main(String[] args) {
		Circle c = new Circle();
//		c.x=1;
//		c.y=2;
		c.p.x=1;
		c.p.y=2;
		c.r=3;
		System.out.println("c.p.x="+c.p.x);
		System.out.println("c.p.y="+c.p.y);
		System.out.println("c.r="+c.r);

	}

}
