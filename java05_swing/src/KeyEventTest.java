import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventTest extends JFrame implements KeyListener{

	//3. component 종류가 다른데, 같은 event 발생하는 경우
	// eg) 채팅창에서 메세지 쓰고, enter(textfield) or 보내기 click(Button)해도 msg가 전송되는 것 구현
	
	JPanel pane = new JPanel();
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	JButton btn = new JButton("보내기");
	JTextField tf = new JTextField(25); //25글자 크기의 text field가 설정됨
	
	//Font 설정
	Font fnt = new Font("궁서체", Font.BOLD + Font.ITALIC, 20);
	
	
	public KeyEventTest() {
		
		super("Key이벤트");
		
		add(sp);
		
		add(BorderLayout.SOUTH, pane);
		
		pane.add(tf);
		
		pane.add(btn);
		
		//ta에 Font 객체 setting
		ta.setFont(fnt);
		
		setSize(400, 500);
		
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//textfield, JButton 이벤트 등록 >>> 무슨 이벤트가 실행됐는지 확인
		tf.addKeyListener(this);
		// 다른 클래스에서 이벤트 처리, heap에 저장되어있는 주소값을 이용해서 값을 전달주고받음, 실행시 enter값이 뜨지 않는다
		btn.addActionListener(new SendButton(ta, tf)); //다른 클래스에서 이벤트 실행..? 객체로 만들어서 --- SendButton
	}

	// interface " KeyListener " overriding
	public void keyPressed(KeyEvent ke) { //키를 누른 상태에서 실행
		
	}
	
	public void keyReleased(KeyEvent ke) { //키를 누른 후 놓은 상태에서 실행
		//이벤트가 발생한 키정보 얻어오기
		char evtChar = ke.getKeyChar();
		int evtInt = ke.getKeyCode(); //ASCII code 값이 나옴
		System.out.println(evtChar+" -> "+evtInt);
		
		if(evtInt == KeyEvent.VK_ENTER) {
			ta.append(tf.getText()+"\n"); //textfield에 있는 문자열을 읽은 다음에 text area로 옮김
			tf.setText(""); //문자 지우기
		}else if(evtInt == KeyEvent.VK_ESCAPE) {
			// 프로그램 종료
			System.exit(0);
		}
		
	}
	
	public void keyTyped(KeyEvent ke) { //키를 누른 후 놓으면 실행
	}
	
	
	
	public static void main(String[] args) {
		new KeyEventTest();
	}

}
