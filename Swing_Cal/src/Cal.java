/////////윤민///////////

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Cal extends JFrame implements ActionListener{
	JPanel pane1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JTextArea ta = new JTextArea("0");

	public Cal() {
		//숫자 보여지는 곳
		pane1.add(ta);
		add("North", pane1);
		
		
		// 버튼3개가 들어가는 곳
		JPanel pane2 = new JPanel(new GridLayout(1,3));
		JButton btnBs = new JButton("BackSpace");
		JButton btnCl = new JButton("Clear");
		JButton btnEnd = new JButton("End");
		pane2.add(btnBs); pane2.add(btnCl); pane2.add(btnEnd);
		add("Center", pane2);
		
		//숫자, 사칙연산 입력칸
		JPanel pane3 = new JPanel(new GridLayout(4,4));
		JButton btn1 = new JButton("7");
		JButton btn2 = new JButton("8");
		JButton btn3 = new JButton("9");
		JButton btn4 = new JButton("+");
		JButton btn5 = new JButton("4");
		JButton btn6 = new JButton("5");
		JButton btn7 = new JButton("6");
		JButton btn8 = new JButton("-");
		JButton btn9 = new JButton("1");
		JButton btn10 = new JButton("2");
		JButton btn11 = new JButton("3");
		JButton btn12 = new JButton("*");
		JButton btn13 = new JButton("0");
		JButton btn14 = new JButton(".");
		JButton btn15 = new JButton("=");
		JButton btn16 = new JButton("/");
		pane3.add(btn1); pane3.add(btn2); pane3.add(btn3); pane3.add(btn4);
		pane3.add(btn5); pane3.add(btn6); pane3.add(btn7); pane3.add(btn8);
		pane3.add(btn9); pane3.add(btn10); pane3.add(btn11); pane3.add(btn12);
		pane3.add(btn13); pane3.add(btn14); pane3.add(btn15); pane3.add(btn16);
		add("South", pane3);
		
		//프레임 세팅
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		//버튼3개 부분
		btnBs.addActionListener(this);
		btnCl.addActionListener(this);
		btnEnd.addActionListener(this);
		//사칙연산 부분
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		btn15.addActionListener(this);
		btn16.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생한 버튼 알아내기
		String evt = ae.getActionCommand();
		if(evt.equals("7")) {
			ta.append("7");
		}else if(evt.equals("8")) {
			ta.append("8");
		}else if(evt.equals("9")) {
			ta.append("9");
		}else if(evt.equals("+")) {
			ta.append("+");
		}else if(evt.equals("4")) {
			ta.append("4");
		}else if(evt.equals("5")) {
			ta.append("5");
		}else if(evt.equals("6")) {
			ta.append("6");
		}else if(evt.equals("-")) {
			ta.append("-");
		}else if(evt.equals("1")) {
			ta.append("1");
		}else if(evt.equals("2")) {
			ta.append("2");
		}else if(evt.equals("3")) {
			ta.append("3");
		}else if(evt.equals("*")) {
			ta.append("*");
		}else if(evt.equals("0")) {
			ta.append("0");
		}else if(evt.equals(".")) {
			ta.append(".");
		}else if(evt.equals("=")) {
			ta.append("=");
		}else if(evt.equals("/")) {
			ta.append("/");
		}else if(evt.equals("Clear")) {
			ta.setText("0");
		}else if(evt.equals("End")) {
			System.exit(0);
		}
		
		
	}
	public static void main(String[] args) {
		new Cal();
		
	}

}
