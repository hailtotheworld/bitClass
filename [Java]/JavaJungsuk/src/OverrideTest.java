class Point {
	int x;
	int y;

//	String getLocation() {
//		return "x="+x+",y="+y;
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x=" + x + ",y=" + y;
	}

//	void getLocation1() {
//		System.out.printf("x=%d,y=%d",x,y);
//	}
}

class Point3D extends Point {
	int z;

//	@Override
//	String getLocation() {
//		return super.getLocation()+",z="+z;
//	}

//	String getLocation() {
//		return "x="+x+",y="+y+",z="+z;
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ",z=" + z;
	}

}

public class OverrideTest {

	public static void main(String[] args) {

		Point3D p = new Point3D();
		p.x = 7;
		p.y = 9;
		p.z = 11;

//		System.out.println(p.getLocation());
		System.out.println(p);
		System.out.println(p.toString());

	}

}
