package layout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BookingChange extends JFrame{
	//빈공간 채울 라벨
	JLabel lbl1 = new JLabel("위");
	JLabel lbl2 = new JLabel("                                                                 왼쪽");
	JLabel lbl3 = new JLabel("오른                                                                 ");
	//모든 나의 예약정보가 들어갈 패널
	JPanel pane1 = new JPanel(new BorderLayout());
		JPanel pane2 = new JPanel();
		JScrollPane sp = new JScrollPane(pane2);
	public BookingChange() {
		add(pane1);
		pane1.add("Center", sp);
		pane1.add("North", lbl1);
		pane1.add("West", lbl2);
		pane1.add("East", lbl3);
		pane2.setBackground(Color.lightGray);
		
		pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
		
		setMyBooking();
		
		
		
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setMyBooking() {
		for(int i=0; i<30; i++) {
			
			
		}
	}
	public static void main(String[] args) {
		new BookingChange();

	}

}
