import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ActionEventTest implements ActionListener {
	//component, class는 주로 멤버영역에 만들기
	JFrame frm = new JFrame("ActionEvent");
	JButton btn = new JButton("클릭");
	JTextArea ta = new JTextArea("버튼을 클릭하세요.");
	JButton btn2 = new JButton("3단");
	JScrollPane sp = new JScrollPane(ta);
	
	public ActionEventTest() {

		frm.add(BorderLayout.NORTH, btn); //북쪽에 버튼을 위치, 
		//이벤트 발생하는 대상: 마우스 클릭 시 발생 = ActionEvent = method add"이벤트 종류"Listener
		frm.add(BorderLayout.SOUTH, btn2);
		
		frm.add(sp); // 스크롤 패널의 기능 생김, centre에 있는 ta 부분에서 스크롤 실행
		
		// *** 1. interface 상속으로 기능처리하기..
		//frm.add(ta); 센터에 버튼위치, JScrollPane에 JTextArea ta를 입력했으니까, 생략해도 됨!
		
		frm.setSize(500,500);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE); //자원해제

		// *** 3. 이벤트 등록 (마우스를 클릭 할 때마다 발생하는 event 모두 등록해야함)
		btn.addActionListener(this); 
		//구현 할 이벤트의 실행부가 같은 클래스에 있으면 (this), 다른 클래스면 (new B()) 객체..
		btn2.addActionListener(this);
		
		
		
	}

	// *** 2. interface의 추상메소드 오버라이딩
	public void actionPerformed(ActionEvent ae) { // event 발생 시, 실행부
										// 클릭된 버튼을 담아내고, 무슨 이벤트를 하는지 확인함
		// setText() : 새로운 문자로 셋팅
		// append() : 마지막에 문자추가
		// insert() : 원하는 위치(index)에 문자추가
		
		//ta.append("click\n"); //버튼 btn, btn2을 누를때마다 click이라는 text 생성 >>> 버튼의 기능 나누려면?

		// ae에 들어오는 값(이벤트)이 btn, btn2인지 알아내는 방법 1.Label 2.Label 없을때
		/*
		//1. 이벤트가 발생한 버튼 알아내기 -> getActionCommand()
		String evt = ae.getActionCommand();
		if(evt.equals("클릭")) {
			ta.append("click");
		}else if(evt.equals("3단")) {
			gugudan(3);
			
		}
		*/
		
		//2. 이벤트가 발생한 객체를 이용해서 알아내기
		Object obj = ae.getSource(); //방금 이벤트가 발생한 객체가 object으로 담김
		if(obj == btn) { // 클릭 버튼 선택 시,
			ta.append("btn 버튼을 click함 \n");
		}else if(obj == btn2) {
			gugudan(9);
		}
		
		//3. component 종류가 다른데, 같은 event 발생하는 경우 --- KeyEventTest class로
	}
	
	
	
	public void gugudan(int dan) {
		for(int i=2; i<=9; i++) {
			ta.append(dan+"*"+i+"="+(dan*i)+"\n");
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new ActionEventTest();

	}

}
