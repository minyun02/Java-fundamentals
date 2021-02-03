

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BookingChange extends JFrame{
	//빈공간 채울 라벨
	JLabel lbl1 = new JLabel();
		
	JLabel lbl2 = new JLabel();	//("                                                                 왼쪽");
	JLabel lbl3 = new JLabel();	//("오른                                                                 ");
	//모든 나의 예약정보가 들어갈 패널
	JPanel pane1 = new JPanel(new BorderLayout());
		JPanel pane2 = new JPanel();
		JScrollPane sp = new JScrollPane(pane2);
	//예약정보 1개 들어갈 뼈대 패널
	JPanel pane3 = new JPanel(new BorderLayout()); //예약정보 1개 들어갈 패널
		JLabel westLbl = new JLabel("");
		JLabel eastLbl = new JLabel("");
		JPanel pane4 = new JPanel(new BorderLayout()); //3패널 북쪽에 들어갈 패널
			JPanel pane5 = new JPanel(new GridLayout(3,1));	//4패널 서쪽에 들어가고 예약번호,출발일시,항공편명 라벨을 넣을 패널
			JPanel pane6 = new JPanel(new GridLayout(3,1));	//4패널 중앙에 들어가고 예약번호 등 정보 라벨을 담을 패널
		JPanel pane7 = new JPanel(new BorderLayout());		//3패널 중앙에 들어갈 패
			JPanel pane8 = new JPanel(new GridLayout(3,1));	//7패널 서쪽에 서울(김포),  GMP, 15:00 라벨 넣을 패널
			JPanel pane9 = new JPanel(new GridLayout(3,1));	//7패널 동쪽에 도착정보라벨을 넣을 패널
		JPanel pane10 = new JPanel();	//3패널 남쪽에 예약변경, 예약취소 버튼 넣을 패널
			JButton btn1 = new JButton("예약변경");
			JButton btn2 = new JButton("예약취소");
	public BookingChange() {
		add(pane1);
		pane1.add("Center", sp);
		pane1.add("North", lbl1);
			lbl1.setPreferredSize(new Dimension(0, 130));
		pane1.add("West", lbl2);
			lbl2.setPreferredSize(new Dimension(150, 500));
		pane1.add("East", lbl3);
			lbl3.setPreferredSize(new Dimension(150, 500));
		
		pane2.setBackground(Color.lightGray);
		pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
		pane2.add(pane3);
			pane3.setPreferredSize(new Dimension(100,100));
		pane3.add("North", pane4);
		pane3.add("Center", pane7);
			pane7.setBackground(Color.black);
			
		pane3.add("West", westLbl);
			westLbl.setPreferredSize(new Dimension(200,0));
		pane3.add("East", eastLbl);
			eastLbl.setPreferredSize(new Dimension(200,0));
		
		pane3.add("South", pane10);
			pane10.setBackground(Color.black);
			
		setMyBooking();
		
		
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setMyBooking() {
		pane4.add("West", pane5);
		pane5.setPreferredSize(new Dimension(100, 100));
		pane5.setBackground(Color.lightGray);
		
		pane4.add("Center", pane6);
		
		pane7.add("West", pane8);
		pane7.add("East", pane9);
		
		pane3.add("South", pane10);
			pane10.add(btn1);
			pane10.add(btn2);
		
		String lblData[] = {"예약번호", "출발일시", "항공편명"};
		for(int i=0; i<lblData.length; i++) {
			JLabel lbl = new JLabel(lblData[i]);
			pane5.add(lbl);
		}
		//								0							1								2					3				4			5				6			7			8
		String data[] = {"AB1C57", "2021-01-31 10:30", "KK512", "서울(김포)", "GMP", "15:00", "제주", "CJU", "16:00"};
		for(int i=0; i<data.length; i++) {
			if(i<=2) {
				JLabel dataLbl1 = new JLabel(data[i]);
				pane6.add(dataLbl1);
			}if(i>=3 && i<=5) {
				JLabel dataLbl2 = new JLabel(data[i]);
				pane8.add(dataLbl2);
			}else if(i>=5) {
				JLabel dataLbl3 = new JLabel(data[i]);
				pane9.add(dataLbl3);
			}
		}
				
	}
	public static void main(String[] args) {
		new BookingChange();

	}

}
