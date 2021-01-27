import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//21-01-12
public class WindowEventTest extends JFrame implements WindowListener{
	JLabel lbl = new JLabel ("계산기");
	Calculator cal = new Calculator();
	
	public WindowEventTest() {
		add("North" , lbl);
		add(cal);
		
		setSize(500,300);
		setVisible (true);
//		프로그램 종료시 자원해제		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
//		창닫기 금지
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);

	}

	public static void main(String[] args) {
		new WindowEventTest();

	}

	@Override
	public void windowOpened(WindowEvent e) {	
		System.out.println("Opended()");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int state = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?","종료확인", 
					JOptionPane.YES_NO_OPTION);
		System.out.println("Closing()");
		if (state == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {	
		System.out.println("Closed()");
	}

	@Override
	public void windowIconified(WindowEvent e) {	
		System.out.println("Iconified()");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {	
		System.out.println("Deiconified()");
	}

	@Override
	public void windowActivated(WindowEvent e) {	
		System.out.println("Activated()");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated()");
	}

}
