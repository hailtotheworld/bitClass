package ch13;

public class this_super {
	public static void main(String[] args) {

	}
}

class Car extends jo {
	String color;
	int door;

	Car(String color, int door) {
		this.color = color;
		color = "d";
		this.door = door;
	}

	Car() {
		color = "green";
		door = 12;
	}

	@Override
	void jojo() {
		jojo();
	}

}

class jo {
	void jojo() {
	};
}