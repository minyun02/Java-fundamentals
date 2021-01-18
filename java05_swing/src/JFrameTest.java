import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame{

	public JFrameTest() {
		
		super("Swing Testing...");
		
		JButton btn = new JButton("swing 버튼");
		add(BorderLayout.NORTH, btn);

		setSize(500,500);
		
		// 테두리가 없는 container : JPanel , default : flowLayout
		JPanel pane = new JPanel();
		//							 row, col  hGap, vGap
		pane.setLayout(new GridLayout(0, 2,  20, 20)); //바툭판식 레이아웃, 행열 구분 + 행열 사이의 gap
		JButton btn2 = new JButton("버튼 1");
		JButton btn3 = new JButton("버튼 4");
		pane.add(btn2);
		pane.add(new JButton("버튼 2"));
		pane.add(new JButton("버튼 3"));
		pane.add(btn3);
		pane.add(new JButton("버튼 5")); // GridLayout(2, 2) 추가 시 col이 늘어난다.. GridLayout(0, 2) row가 늘어난다..
		pane.add(new JButton("버튼 6"));
		pane.add(new JButton("버튼 7"));
		
		add(BorderLayout.CENTER, pane);
		
		
		setVisible(true);
		
		// 프로그램 종료 시, 자원 해제 시키는 기능 설정(프로그램 완전 종료)
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE = 2
	}
	
	public static void main(String a[]) {
		new JFrameTest();
		
	}

}
