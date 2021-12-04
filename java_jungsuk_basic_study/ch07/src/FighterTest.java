abstract class Unit2 {
	int x, y;
	abstract void move(int x, int y);
	void stop() {System.out.println("멈춥니다");}
}

interface Fightable {
	public abstract void move(int x, int y); //public abstract가 생략됨
	void attack(Fightable f);  //public abstract가 생략됨
}

class Fighter extends Unit2 implements Fightable  {
	public void move(int x, int y) { // 오버라이딩 규칙: 조상보다 접근제어자가 좁으면 안된다. public 붙혀야 해.
		System.out.println("["+x+","+y+"]로이동");
	} //public abstract가 생략됨
	public void attack(Fightable f) {
		System.out.println(f+"로 공격");
	}  //public abstract가 생략됨
	
	// 싸울 수 있는 상대를 불러온다.
	Fightable getFightable() {
		Fighter f = new Fighter(); //Fighter를 생성해서 반환
		return (Fightable)f;
	}
}

public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		Fightable f2 = f.getFightable();
		
		Unit2 u = new Fighter(); 
		u.move(100, 200);
//		u.attack(new Fighter()); // Unit2에는 attack()이 없어서 호출불가
		u.stop();
		
		
		Fightable f1 = new Fighter(); // 인터페이스에 들어가있는 move,attack만 사용가능.
		f1.move(100, 200);
		f1.attack(new Fighter());
//		f.stop(); // Fightable에는 stop()이 없어서 호출불가

	}

}
