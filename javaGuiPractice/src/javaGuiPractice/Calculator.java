package javaGuiPractice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	
	JPanel pane;
	JButton btn;
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();
	
	public Calculator() {
		super("Calculator testing...");
		
		setSize(500,300);
		
		// 1. 결과값 보여주는 창
		JPanel northPane = new JPanel();
		add(BorderLayout.NORTH, northPane);
		northPane.add(tf);
		ta.append(tf.getText()+" "); //text field의 문자를 보여줌
		tf.setText("");
		
		// 2. 기능 창
		JPanel centrePane = new JPanel();
		centrePane.setLayout(new GridLayout(1,3,1,1));
		centrePane.add(new JButton("BackSpace")); // 값 지우기
		centrePane.add(new JButton("clear")); // 값 초기화
		centrePane.add(new JButton("End")); // 종료
		
		add(BorderLayout.CENTER, centrePane);
		
		// 3. 번호 + 연산자 창
		JButton[] number = new JButton[10];
		//실제 버든 객체 생성
		for(int i=0; i<number.length; i++) {
			number[i] = new JButton(Integer.toString(i));
			
		}
		JPanel southPane = new JPanel();
		southPane.setLayout(new GridLayout(4,4,1,1));
		
		JButton operPlus = new JButton("+");
		JButton operMinus = new JButton("-");
		JButton operMulti = new JButton("*");
		JButton operDiv = new JButton("/");
		JButton operPoint = new JButton(".");
		JButton operEqual = new JButton("=");
		
		// oper에 대한 actionListener 모두 생성?
		
		southPane.add(number[7]);
		southPane.add(number[8]);
		southPane.add(number[9]);
		southPane.add(operPlus);
		
		southPane.add(number[4]);
		southPane.add(number[5]);
		southPane.add(number[6]);
		southPane.add(operMinus);
		
		southPane.add(number[1]);
		southPane.add(number[2]);
		southPane.add(number[3]);
		southPane.add(operMulti);
		
		southPane.add(number[0]);
		southPane.add(operPoint);
		southPane.add(operEqual);
		southPane.add(operDiv);
		
		add(BorderLayout.SOUTH, southPane);
		
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// 이벤트 생성
		
		
		
		
	}
	

	public static void main(String[] args) {
		new Calculator();

	}



}
