package swingTest;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame{
	JTabbedPane tp = new JTabbedPane();
	
	ImageIcon ii1 = new ImageIcon("img/2.png");
	ImageIcon ii2 = new ImageIcon("icon/save01.gif");
	ImageIcon ii3 = new ImageIcon("icon/open01.gif");
	ImageIcon ii4 = new ImageIcon("icon/new01.gif");
	
	JLabel lbl = new JLabel(ii1);
	
	Calculator cal = new Calculator();
	CalendarSwing calendar = new CalendarSwing();
	DigitalClock clock = new DigitalClock();
	PackMan packMan = new PackMan();
	public JTabbedPaneTest() {
		add(tp);//tp가 센터에 들어감
		
		//탭패널에 컴퍼넌트 추가
		tp.addTab("라벨", lbl);
		
		//계산기
		tp.addTab("계산기", ii2, cal, "Calculator");
		//달력
		tp.addTab("달력", ii2, calendar, "Calendar");
		//시계
		tp.addTab("시계", ii3, clock, "Clock");
		//팩맨
		tp.addTab("팩맨", ii4, packMan, "PackMan");
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//시계 스레드 시작
		Thread clockThread = new Thread(clock);
		clockThread.start();
		
		//팩맨 스레드 시작
		//캔버스 크기 다시 세팅하기
		packMan.getPackManSize();
		Thread packManthread = new Thread(packMan);
		packManthread.start();
		
		try {//3초 뒤에 버튼 탭이 들어가를 보여주려는 퍼포먼스용 3초 스레드 
			Thread.sleep(3000);
		}catch(Exception e) {}
		//중간에 tabMenu추가 하기
		tp.insertTab("버튼", ii2, new JButton("버튼"), "TabPane테스트중", 2);
		
		//활성화 비활성화하기
		// true : 활성화
		// false : 비활성화(모든 탭이 비활성화 된다.)
		//tp.setEnabled(false);
		
		tp.setEnabledAt(2, false);
		
		//탭메뉴 삭제
		//tp.removeTabAt(3);
		
		//탭메뉴 위치 이동 (상하좌우 위치)
		tp.setTabPlacement(JTabbedPane.LEFT);
		
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();
	}

}
