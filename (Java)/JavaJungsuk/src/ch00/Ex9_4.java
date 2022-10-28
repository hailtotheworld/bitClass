package ch00;
import java.util.Objects;

class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	// equals() 오버라이딩
	public boolean equals(Object obj) {
		if (!(obj instanceof Card))
			return false;

		Card c = (Card) obj;
		return kind.equals(c.kind) && number == c.number;

	}

	// equals 오버라이딩하면 hashCode도 오버라이딩해야한다.
	public int hashCode() {
		return Objects.hash(kind, number);
	}

	// Object클래스의 toString()을 오버라이딩
	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}

}

class Ex9_4 {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();

		System.out.println(c1.equals(c2));

		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());

		System.out.println(c1.toString());
		System.out.println(c2.toString());

	}
}