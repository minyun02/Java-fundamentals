import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendButton implements ActionListener {
	
	//KeyEventTest에서 ta, tf 값을 어떻게 받아 올 것인지..? 메소드 만들고 멤버영역에 변수선언 > 메소드 안에서 불러오기
	JTextArea ta;
	JTextField tf;
	
	// 이벤트등록하는 곳에 실행하기 위해서 현재 클래스를 객체로 만들기

	
	public SendButton() {
		
	}
	
	public SendButton(JTextArea ta, JTextField tf) {
		this.ta=ta;
		this.tf=tf;
		/* KeyEventTest 클래스에서 ta, tf 클래스에서 받은 저장값(문자 데이터)의 주소값을 전달받는 메소드
		 * this.ta/tf = super.ta/tf와 같은 주소를 쓰기 때문에 
		 * 결과적으로 사용하는 값이 같다!
		 */
	}
	
	public void actionPerformed(ActionEvent ae) { //interface over-riding...
		ta.append(tf.getText()+"\n");
		tf.setText("");
	}

}
