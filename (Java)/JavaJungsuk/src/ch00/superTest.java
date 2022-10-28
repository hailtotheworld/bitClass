package ch00;
abstract class Vehicle {
	String name;

	abstract public String getName(String val);

	public String getName() {
		return "Vehicle name:" + name;
	}
}

class Car1 extends Vehicle {
	String name;

	public Car1(String val) {
		name = super.name = val;
	}

	public String getName(String val) {
		return "Car name:" + val;
	}

	public String getName(byte val[]) {
		return "Car name:" + val;
	}

}

public class superTest {
	public static void main(String args[]) {
		Vehicle obj = new Car1("Spark");
		System.out.print(obj.getName());

		
	}
}
