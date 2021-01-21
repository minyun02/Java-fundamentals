import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
// 21/1/13

public class WindowAdapterInnetTest extends JFrame {
	
	JLabel lbl = new JLabel("windowAdapter 테스트중..");
	
	public WindowAdapterInnetTest() {
		add(lbl);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		AdapterInner ai = new AdapterInner();
		addWindowListener(ai);
		

		
	}

	//내부 클래스에서 윈도우이벤트 처리하기
	class AdapterInner extends WindowAdapter{
		//다시 오버라이딩
		public void windowClosing(WindowEvent we) {
			lbl.setText("윈도우 이벤트 처리됨.");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new WindowAdapterInnetTest();
	}

}
