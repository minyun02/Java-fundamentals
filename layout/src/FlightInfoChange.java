

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FlightInfoChange extends JFrame {
	//빈공간을 위한 전체 패널
	JPanel masterPane = new JPanel(new BorderLayout());
		JLabel gapN = new JLabel("N");
		JLabel gapW = new JLabel("W");
		JLabel gapE = new JLabel("E");
		JLabel gapS = new JLabel("S");
		//masterPane에 들어갈 패널
		JPanel pane = new JPanel(new BorderLayout());
			JPanel topPane = new JPanel();
				JButton btn = new JButton(new ImageIcon("img/3.png"));
				JLabel lbl1 = new JLabel("BCP");
					JComboBox<String> cb1;
					String[] BCPName = {"0442", "0054", "0001", "0832", "0564"};
				JLabel lbl2 = new JLabel("출발지");
					JComboBox<String> cb2;
					String[] depName = {"인천", "김포", "제주", "런던", "호놀룰루", "김해"};
				JLabel lbl3 = new JLabel("도착지");
					JComboBox<String> cb3;
					String[] desName = {"인천", "김포", "제주", "런던", "호놀룰루", "김해"};
		////테이블
		String info[] = {"항공편명", "출발지", "출발시간", "도착지", "도착시간"};
		JPanel tablePane = new JPanel(new BorderLayout());
			JTable table;
			JScrollPane sp;
			DefaultTableModel model;
	
			

	public FlightInfoChange() {
		add(masterPane);
		masterPane.add("North", gapN);
			gapN.setPreferredSize(new Dimension(100,50));
		masterPane.add("West", gapW);
			gapW.setPreferredSize(new Dimension(100,100));
		masterPane.add("East", gapE);
			gapE.setPreferredSize(new Dimension(100,100));
		masterPane.add("South", gapS);
			gapS.setPreferredSize(new Dimension(100,50));
		masterPane.add("Center", pane);
		
		pane.add("North", topPane);
			topPane.setLayout(null);
			topPane.setPreferredSize(new Dimension(0,100));
			topPane.setBackground(Color.black);
			topPane.add(btn);
				btn.setBounds(10,10, 25,30);
				
		
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
			

	public static void main(String[] args) {
		new FlightInfoChange();

	}

}
