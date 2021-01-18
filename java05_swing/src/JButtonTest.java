import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame {
	
	ImageIcon ii1 = new ImageIcon("img/movie01.png");
	ImageIcon ii2 = new ImageIcon("img/movie07.png");
	ImageIcon ii3 = new ImageIcon("img/movie09.png");
	ImageIcon ii4 = new ImageIcon("img/movie11.png");
	ImageIcon ii5 = new ImageIcon("img/movie14.png");
	

	public JButtonTest() {
		super("JButton Test");
		
		setLayout(new GridLayout(0, 3, 10, 10)); // layout change
		JButton btn1 = new JButton(ii1);
		add(btn1);
		
		JButton btn2 = new JButton("확인", ii2);
		add(btn2);
		
		// 속성 setting : 마우스를 올리면 아이콘이 ii3으로 변경
		btn2.setRolloverIcon(ii3);
		// 마우스 누른 상태일때, 아이콘 ii4로 변경
		btn2.setPressedIcon(ii4);
		
		// 버튼 비활성화
		btn1.setEnabled(false); // 비활성화 메소드를 true 활성화하겠다 false 비활성화
		
		
		// JRadioButton 만들기 : 선택 할 여러개의 component 필요 > panel 개수에 맞춰서 더 필요, GridLayout
		JPanel pane = new JPanel(new GridLayout(3,1));
		JRadioButton rb1 = new JRadioButton("One");
		JRadioButton rb2 = new JRadioButton("Two");
		JRadioButton rb3 = new JRadioButton("Three, true"); //선택
		
		//JRdioButton의 Group화 : ButtonGroup > 한 개를 선택하면 다른 것 선택 x
		//객체를 만들어서 등록

		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1); 
		bg.add(rb2); 
		bg.add(rb3);

		//ToggleButton 두 가지 작업, 버튼 선택
		JToggleButton tb1 = new JToggleButton("ToggleButton");
		JToggleButton tb2 = new JToggleButton(ii5, true); //처음부터 선택된 상태
		//tb1.setVisible(false);
		tb2.setRolloverSelectedIcon(ii4); //선택됐을때 이미지가 변경됨
		add(tb2); add(tb1);
		
		//setBackground(); setting compoment or container의 background colour 
		btn2.setBackground(Color.lightGray);
		//
		Color clr1 = new Color(150, 200, 50);
		rb1.setBackground(clr1);
		Color clr2 = new Color(50, 100, 150);
		tb1.setBackground(clr2);

		//setForeground(); 글자색
		tb1.setForeground(Color.orange);
		
		//JLabel : 입력칸에 해당하는 설명(label Component)
		JLabel lbl1 = new JLabel(ii3);
		JLabel lbl2 = new JLabel("라벨", JLabel.CENTER);
		add(lbl1);  add(lbl2);
		
		// 라벨의 배경색 : 칠 할 수 없다.. 투명처리되어있기 때문에!, 투명을 해제
		lbl2.setOpaque(true); // true: 투명해제, false: 투명ㄴ
		Color clr3 = new Color(70, 100,170);
		lbl2.setBackground(clr3);
		
		btn2.setToolTipText("버튼 연습 중!"); // 상세정보 pop-up됨
		
		
		pane.add(rb1);
		pane.add(rb2);
		pane.add(rb3);
		add(pane);
		
		
		setSize(500, 400);
		
		setVisible(true);
		
	}

	






	public static void main(String[] args) {
		new JButtonTest();
		
	}

}
