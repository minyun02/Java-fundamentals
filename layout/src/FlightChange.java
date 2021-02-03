

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FlightChange extends JFrame {
	//상단패널
	JPanel topPane = new JPanel(new BorderLayout());
		JLabel lbl1 = new JLabel("");
		JLabel lbl2 = new JLabel("");
		JLabel lbl3 = new JLabel("");
		JLabel lbl4 = new JLabel("");
		
		JPanel bcpPane = new JPanel();
			ImageIcon ii1 = new ImageIcon("img/cal.png");
			JButton calBtn = new JButton(ii1);
			String lbl[] = {"         BCP ", "|     출발지", "→     도착지"};
			
		//String data[] = {"항공편명", "인천", "뉴욕"};
	public FlightChange() {
		add("North", topPane);
		topPane.add("North", lbl1);
			lbl1.setPreferredSize(new Dimension(0, 120));
		topPane.add("West", lbl2);
			lbl2.setPreferredSize(new Dimension(100, 50));
		topPane.add("East", lbl3);
			lbl3.setPreferredSize(new Dimension(100, 50));
		topPane.add("South", lbl4);
			lbl4.setPreferredSize(new Dimension(0, 120));
		topPane.add("Center", bcpPane);
			LineBorder border = new LineBorder(Color.blue);
			bcpPane.setBorder(border);
			bcpPane.setBackground(Color.LIGHT_GRAY);

		bcpPane.add(calBtn);
		for(int i=0; i<lbl.length; i++) {
			JLabel dataLbl = new JLabel(lbl[i]);
			bcpPane.add(dataLbl);
			bcpPane.add(new JTextField(10));
		}
		bcpPane.add(new JButton("검색"));
		
		
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FlightChange();

	}

}
