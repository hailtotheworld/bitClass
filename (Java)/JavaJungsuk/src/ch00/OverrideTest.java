package ch00;
class Point {
	int x;
	int y;

	@Override
	public String toString() {
		return "x=" + x + ",y=" + y;
	}

}

class Point3D extends Point {
	int z;

	public Point3D() {
	}

	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return super.toString() + ",z=" + z;
	}

}

public class OverrideTest {

	public static void main(String[] args) {

		Point3D p = new Point3D(7, 9, 11);

		System.out.println(p);

	}

}
