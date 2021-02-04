import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;

public class EmpFrame extends JFrame implements ActionListener, MouseListener,Runnable{

	// 상단 패널
		JPanel northPane = new JPanel();
			JPanel northNPane = new JPanel(); //  1,6 BorderLayout
			JPanel northCPane = new JPanel(); // 2개 항공편 회원
			JPanel northSPane = new JPanel(); // 2개 사원정보 로그아웃
				JLabel saleLbl = new JLabel("매 출 관 리");
				JLabel resLbl = new JLabel("예 약 관 리");
				JLabel airLbl = new JLabel("항 공 편 관 리");
				JLabel userLbl = new JLabel("회 원 관 리");
				JLabel empLbl = new JLabel("사 원 정 보 관 리");
				JLabel logoutLbl = new JLabel("로 그 아 웃");
			Component[] lbl = {saleLbl,resLbl,airLbl,userLbl,empLbl,logoutLbl};
			//팝업메뉴
			JPopupMenu userInfo = new JPopupMenu(); // 회원관리 
				JMenuItem userSearch = new JMenuItem("회원조회 / 삭제");
				JMenuItem empInformationItem = new JMenuItem("블랙 리스트");
				
		String title[] = {"매출관리","예약관리","항공편관리","회원관리","사원정보관리","로그아웃"};
		
		Font fnt = new Font("굴림체",Font.BOLD,14);
		
		
	// 중앙패널 바꿔가는 패널
	  // 클래스 생길때마다 객체로 생성해서 넣어버리기	
		JPanel centerPane = new JPanel();
			AirlineSales sales = new AirlineSales(); // 매출관리
//			AirlineReservation reservation = new AirlineReservation(); //예약관리

		
		
	// 하단패널
		JPanel clockPane = new JPanel(new BorderLayout());
			JPanel reClock = new JPanel();
				JLabel koreaLbl = new JLabel("한국 :");
			JPanel clock = new JPanel();
				JLabel nationLbl = new JLabel();
		/////////////////////// 디지털 시계 /////////////////////
		DigitalClock koreaClock = new DigitalClock("Asia/Seoul");
		DigitalClock londonClock = new DigitalClock("Europe/London");
		DigitalClock parisClock = new DigitalClock("Europe/Paris");
		DigitalClock moscowClock = new DigitalClock("Europe/Moscow");
		DigitalClock dubaiClock = new DigitalClock("Asia/Dubai");
		DigitalClock jakartaClock = new DigitalClock("Asia/Jakarta");
		DigitalClock shanghaiClock = new DigitalClock("Asia/Shanghai");
		DigitalClock sydneyClock = new DigitalClock("Australia/Sydney");
		DigitalClock vancouverClock = new DigitalClock("America/Vancouver");
		DigitalClock losangelesClock = new DigitalClock("America/Los_Angeles");
		DigitalClock mexicocityClock = new DigitalClock("America/Mexico_City");
		DigitalClock newyorkClock = new DigitalClock("America/New_York");
		DigitalClock saopauloClock = new DigitalClock("America/Sao_Paulo");
		/////////////////////////////////////////////////////////
		//////////////////////시계패널//////////////////////////////

		DigitalClock[] country = {londonClock,parisClock,moscowClock,dubaiClock,jakartaClock,shanghaiClock
				,sydneyClock,vancouverClock,losangelesClock,mexicocityClock,newyorkClock,saopauloClock};
		String countryName[] = {"런던 :","파리 :","모스크바 :","두바이 :","자카르타 :","상하이 :","시드니 :","밴쿠버 :"
				,"로스앤젤레스 :","멕시코시티 :","뉴욕 :","상파울루 :"}; 
		String countryImg[] = {"flag/uk.png","flag/franch.png","flag/russia.png","flag/uae.png","flag/indonesia.png"
				, "flag/shanghai.png", "flag/sydney.png", "flag/canada.png","flag/america.png","flag/mexico.png"
				, "flag/america.png","flag/sangpaulo.png"};
		
		static CardLayout card = new CardLayout();
			
		

	
	public EmpFrame() {
		setLayout(new BorderLayout());
		northPane.setLayout(new BorderLayout());
		northPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		northPane.add("North",northNPane);
		northNPane.setBackground(Color.white);
		
		northCPane.setLayout(new GridLayout(1,6));
		northPane.add("Center",northCPane);
		
		//북쪽 프레임
		northCPane.add(saleLbl);//매출관리
			saleLbl.setOpaque(true); // 라벨 배경색 설정하기 setOpaque 을 해줘야지 배경색 적용됨
			saleLbl.setBackground(Color.white);
			saleLbl.setFont(fnt);
			saleLbl.setHorizontalAlignment(JLabel.CENTER); // 라벨 가운데 정렬
//			saleLbl.setForeground(new Color(255,128,128));
			saleLbl.setForeground(new Color(255,128,64));
		northCPane.add(resLbl); //예약관리
			resLbl.setOpaque(true);
			resLbl.setFont(fnt);
			resLbl.setBackground(Color.white);
			resLbl.setHorizontalAlignment(JLabel.CENTER);
			resLbl.setForeground(new Color(255,128,64));
		northCPane.add(airLbl); // 항공편관리
			airLbl.setOpaque(true);
			airLbl.setFont(fnt); 
			airLbl.setBackground(Color.white);
			airLbl.setHorizontalAlignment(JLabel.CENTER);
			airLbl.setForeground(new Color(255,128,64));
		northCPane.add(userLbl); //회원관리
			userLbl.setOpaque(true);
			userLbl.setFont(fnt);
			userLbl.setBackground(Color.white);
			userLbl.setHorizontalAlignment(JLabel.CENTER);
			userLbl.setForeground(new Color(255,128,64));
//			userLbl.setForeground(new Color(255,128,64));
		northCPane.add(empLbl); //사원정보관리
			empLbl.setOpaque(true);
			empLbl.setFont(fnt);
			empLbl.setBackground(Color.white);
			empLbl.setHorizontalAlignment(JLabel.CENTER);
			empLbl.setForeground(new Color(255,128,64));
		northCPane.add(logoutLbl); // 로그아웃
			logoutLbl.setOpaque(true);
			logoutLbl.setFont(fnt);
			logoutLbl.setBackground(Color.white);
			logoutLbl.setHorizontalAlignment(JLabel.CENTER);
			logoutLbl.setForeground(new Color(255,0,128));
		
		northPane.add("South",northSPane);
		northSPane.setBackground(Color.white); // 으음!
		
		
		add("North",northPane);

//		중앙프레임
		centerPane.setLayout(card);
		centerPane.add(sales,"sales");
//		sales.setHorizontalAlignment();

	
		card.show(centerPane, "sales");
		add("Center",centerPane);

		//남쪽 프레임
		clockPane.setLayout(new GridLayout(0,2));
		clockPane.setBorder(new LineBorder(Color.lightGray, 1));
		clockPane.add("West",clock);
		clockPane.add("East",reClock);
		add("South",clockPane);
		
		clock.setBackground(Color.white);
		reClock.setBackground(Color.white);
		
		// 프레임 기본 설정
		setIconImage(AirlineMain.im);
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트 등록
		saleLbl.addMouseListener(this);		
		resLbl.addMouseListener(this);
		airLbl.addMouseListener(this);
		userLbl.addMouseListener(this);
		userLbl.addMouseListener(this);
		empLbl.addMouseListener(this);
		logoutLbl.addMouseListener(this);
		
	
		empInformationItem.addActionListener(this);

	}

	@Override
	public void run() {
		/////////////////시계패널///////////////////////////
		Thread t1 = new Thread(koreaClock);
		t1.start();
		/// 한국 패널
		ImageIcon icon = new ImageIcon("flag/korea.png");
		Image im = icon.getImage();
		Image korea2 = im.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(korea2);
		koreaLbl.setFont(fnt);
		
//		koreaLbl.setOpaque(true); // 라벨 배경색 설정하기 setOpaque 을 해줘야지 배경색 적용됨
		koreaClock.setBackground(Color.white);
		
		clock.add(new JLabel(icon2)); clock.add(koreaLbl); clock.add(koreaClock);
		/////////////////////////////////////////////
		
		////////////////세계 주요도시 시간/////////////////////////
		for(int i=0; i<country.length;) {
			ImageIcon c1 = new ImageIcon(countryImg[i]);
			Image c2 = c1.getImage();
			Image c3 = c2.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			ImageIcon c4 = new ImageIcon(c3);
			nationLbl.setText(countryName[i]);
			reClock.add(new JLabel(c4));
			nationLbl.setFont(fnt);
			reClock.add(nationLbl);
			reClock.add(country[i]);
			
			country[i].setBackground(Color.white);
			
			Thread t2 = new Thread(country[i]);
			t2.start();
			try{Thread.sleep(10000);}catch(Exception e) {}
			reClock.removeAll();
			reClock.repaint();
			if(i==country.length-1) {
				i=0;
				continue;
			}
			i++;
		}
			/////////////// 시계 패널 끝..////////////
		
	}
	
	// 페이지 전환 메소드
	public static void paneChange(AirlineSales change, String name) {
		card.show(change, name);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if((JLabel)obj instanceof JLabel) { // JLabel 일 경우
			JLabel click = (JLabel)e.getSource();
			String menuStr = click.getText();
			if(click instanceof JLabel) {
				if(menuStr.equals("매 출 관 리")) {
					card.show(centerPane, "sales");
				} else if(menuStr.equals("예 약 조 회")) {
					
				} else if(menuStr.equals("마 이 페 이 지")) {
					card.show(centerPane, "mypage");
					userInfo.show(userLbl, e.getX(), e.getY());
				} else if(menuStr.equals("로 그 아 웃")) {
					dispose();
					new AirlineMain();
				}
			} 
		}
	}
	
//	JLabel saleLbl = new JLabel("매 출 관 리");
//	JLabel resLbl = new JLabel("예 약 관 리");
//	JLabel airLbl = new JLabel("항 공 편 관 리");
//	JLabel userLbl = new JLabel("회 원 관 리");
//	JLabel empLbl = new JLabel("사 원 정 보 관 리");
//	JLabel logoutLbl = new JLabel("로 그 아 웃");
//		
//	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JMenuItem) {// JMenuItem 일 경우
			String click = e.getActionCommand();
			if(click.equals("회원조회 / 삭제")) {
//				card.show(centerPane, "   ");
			} else if(click.equals("블랙 리스트")) {
//				card.show(centerPane, "   ");
			} 
		}
		
	}
		
	

	public static void main(String[] args) {
		Thread t1= new Thread(new EmpFrame());
		t1.start();

	}
	
}
