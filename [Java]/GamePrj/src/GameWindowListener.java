import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

// 인터페이스를 구현하는데 포커스가 맞춰져있다.
// 이 클래스 자체가 하나의 완전체로써 객체의 의미를 갖고있는게 아니다.
// 이렇게 class로 만든건 좋은 방법이 아니다.
// class는 부품인데 이렇게 부품이 늘어나면 프로그램 복잡도가 높아지는거야.
public class GameWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		JOptionPane.showMessageDialog(null, "Good bye~");

// 0을 넣으면 정상종료시킨거라고 알려주는거야.
// 다른값을 넣게되면 에러가 있다고 알려주는거야.
// 프로그램을 실행하는 주체에게 알려주는거다.
// 현재는 런타임에게 알려주는거지.
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
