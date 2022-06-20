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

	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

//	public boolean equals(Object obj) {
//		if (!(obj instanceof Card)) {
//			return false;
//		} else {
//			Card c = (Card) obj;
//			return this.kind.equals(c.kind) && this.number == c.number;
//		}
//	}
//
//	// equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야한다.
//	public int hashCode() {
//		return Objects.hash(kind, number);
//		// 매개변수가 가변인자(Object...)라서 호출시 지정하는 값의 개수가 정해져있지 않다.
//
//		// Objects클래스는 객체와 관련된 유용한 메스드를 제공하는 유틸 클래스
//
//	}
	
	
	

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