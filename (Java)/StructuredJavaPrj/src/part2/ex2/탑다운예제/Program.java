package part2.ex2.탑다운예제;

public class Program {

	public static void main(String[] args) {

		int[][] lottos = null;
		int menu; // 메뉴를 입력받기위한 변수
		boolean running = true;

		while (running) {
			menu = inputMenu(); // 메뉴를 입력받기위한 함수

			switch (menu) {
			case 1:
				lottos = createLottosAuto(); // create: 공간까지 만든다 / generate: 번호만 만든다
				break;
			case 2:
				lottos = createLottosManual();
				break;
			case 3:
				printLottos(lottos);
				break;
			case 4:
				running = false;
				break;
			default:
			}
		}

	}

	private static void printLottos(int[][] lottos) {
		// TODO Auto-generated method stub
		
	}

	private static int[][] createLottosManual() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[][] createLottosAuto() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int inputMenu() {

		return 0;
	}

}