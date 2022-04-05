import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class GameFrame extends Frame implements WindowListener {

	public GameFrame() {
		addWindowListener(this);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawRect(100, 100, 200, 100);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// this는 GameFrame을 가르킨다.
		JOptionPane.showMessageDialog(this, "Good bye~");

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
