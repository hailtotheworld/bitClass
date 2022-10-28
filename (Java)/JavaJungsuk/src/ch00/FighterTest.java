package ch00;
abstract class Unit2 {
	int x, y;

	abstract void move(int x, int y);

	void stop() {
		System.out.println("멈춥니다");
	}

}

// 인터페이스는 추상메서드 집합이다.
interface Fightable {

//	public abstract void move(int x, int y);
	void move(int x, int y); // public abstract가 생략됨

	void attack(Fightable f); // public abstract가 생략됨

}

class Fighter extends Unit2 implements Fightable {

	// 오버라이딩 규칙: 조상보다 접근제어자가 좁으면 안된다.
	@Override
	public void attack(Fightable f) {
		System.out.println(f + "를 공격");

	}

	@Override
	public void move(int x, int y) {
		System.out.println("[" + x + "," + y + "]로 이동");
	}

	Fightable getFightable() {
		Fighter f = new Fighter(); // Fighter을 생성해서 반환
		return f;

	}

}

public class FighterTest {
	public static void main(String[] args) {
		Unit2 u = new Fighter();
		u.move(100, 200);
		u.stop();
//		u.attack(new Fighter()); // Unit2에는 attack()이 없어서 호출불가

		Fightable f = new Fighter();
		f.move(100, 200);
//		f.stop();
		f.attack(new Fighter());
		
		Fighter ff = new Fighter();
		Fightable f2 = ff.getFightable();

	}

}
