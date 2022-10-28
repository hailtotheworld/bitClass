package ch00;
abstract class Player { // 추상클래스(미완성 클래스, 미완성 설계도)
	abstract void play(int pos); // 추상메서드(미완성 메서드: 선언부만 있고 구현부{}가 없는 메서드)

	abstract void stop();
}

// 추상 클래스는 상속을 통해 완성해야 객체 생성가능
class AudioPlayer extends Player {

	@Override
	void play(int pos) {
		System.out.printf("%d번째 곡을 재생합니다\n", pos);

	}

	@Override
	void stop() {
		System.out.println("정지합니다\n");
	}

}

// 조상으로부터 상속받은 추상메서드 중 하나라도 구현하지 않았다면, 자손클래스 역시 추상클래스로 지정해줘야 한다.
abstract class DvdPlayer extends Player {
	@Override
	void play(int pos) {}
}

public class PlayerTest {

	public static void main(String[] args) {
//		Player p = new Player(); // 추상 클래스는 객체 생성 불가능!
		AudioPlayer ap = new AudioPlayer();
		Player p = new AudioPlayer(); // 다형성

		p.play(3);
		p.stop();

		ap.play(2);
		ap.stop();
	}

}
