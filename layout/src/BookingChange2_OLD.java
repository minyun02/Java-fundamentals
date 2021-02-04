

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BookingChange2_OLD	extends JFrame {
	//빈공간을 위한 전체 패널
	JPanel masterPane = new JPanel(new BorderLayout());
		JLabel gapN = new JLabel(" ");
		JLabel gapW = new JLabel(" ");
		JLabel gapE = new JLabel(" ");
		JLabel gapS = new JLabel(" ");
		//masterPane에 들어갈 패널
		JPanel pane = new JPanel(new BorderLayout());
		//top, north에 들어갈 northpanel
		JPanel topNorthPane = new JPanel(new BorderLayout());
	
			JPanel westPane = new JPanel();
				JLabel lbl1 = new JLabel("예약번호");
				JTextField tf1 = new JTextField();
				JLabel lbl2 = new JLabel("출발일시");
				JTextField tf2 = new JTextField();
				JLabel lbl3 = new JLabel("항공편명");
				JTextField tf3 = new JTextField();
			
			JPanel centerPane = new JPanel();
				JLabel lbl4 = new JLabel("출발지");
				JTextField tf4 = new JTextField();
				JLabel lbl5 = new JLabel("출발공항");
				JTextField tf5 = new JTextField();
				JLabel lbl6 = new JLabel("출발시간");
				JTextField tf6 = new JTextField();
			
			JPanel eastPane = new JPanel();
				JLabel lbl7 = new JLabel("도착지");
				JTextField tf7 = new JTextField();
				JLabel lbl8 = new JLabel("도착공항");
				JTextField tf8 = new JTextField();
				JLabel lbl9 = new JLabel("도착시간");
				JTextField tf9 = new JTextField();
				
			JPanel southPane = new JPanel();
				JButton changeBtn = new JButton("예약 변경");
				JButton cancelBtn = new JButton("예약 취소");
				
		/////////////////////////////
		String info[] = {"예약번호", "출발일시", "항공편명", "출발지", "출방공항","출발시간", "도착지", "도착공항", "도착시간"};
		JPanel gapPane = new JPanel(new BorderLayout());
			JLabel gapLbl1 = new JLabel(" ");
			JPanel tablePane= new JPanel(new BorderLayout());
				JTable table;
				JScrollPane sp;
				DefaultTableModel model; 
	public BookingChange2_OLD() {
		add(masterPane);
		masterPane.add("North", gapN);
			gapN.setPreferredSize(new Dimension(100,100));
		masterPane.add("West", gapW);
			gapW.setPreferredSize(new Dimension(200,100));
		masterPane.add("East", gapE);
			gapE.setPreferredSize(new Dimension(200,100));
		masterPane.add("South", gapS);
			gapS.setPreferredSize(new Dimension(100,100));
		masterPane.add("Center", pane);
		
		pane.add("North", topNorthPane);
		topNorthPane.add("West", westPane);
			westPane.setLayout(null);
			//westPane.setBackground(Color.black);
			westPane.setPreferredSize(new Dimension(185,150));
			setWestPane();
		
		topNorthPane.add("Center", centerPane);
			centerPane.setLayout(null);
			//centerPane.setBackground(Color.blue);
			setCenterPane();
			
		topNorthPane.add("East", eastPane);
			eastPane.setLayout(null);
			//eastPane.setBackground(Color.green);
			eastPane.setPreferredSize(new Dimension(185,150));
			setEastPane();
			
		topNorthPane.add("South", southPane);
			southPane.add(changeBtn);
			southPane.add(new JLabel("        "));
			southPane.add(cancelBtn);
			
		/////////////////////////////////////////테이블 세팅
		pane.add("Center", gapPane);
		gapPane.add("North", gapLbl1);
		gapPane.add("Center", tablePane);
		model = new DefaultTableModel(info, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		tablePane.add("Center", sp);
		
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}	
	public void setWestPane() {
		JLabel bookingLbl = new JLabel("예약번호");
		JTextField tf1 = new JTextField(10);
		JLabel dateLbl = new JLabel("출발일시");
		JTextField tf2 = new JTextField(10);
		JLabel flightLbl = new JLabel("항공편명");
		JTextField tf3 = new JTextField(10);
		westPane.add(bookingLbl);
			bookingLbl.setBounds(0,0, 50,20);
		westPane.add(tf1);
			tf1.setBounds(60,1, 100,20);
		westPane.add(dateLbl);
			dateLbl.setBounds(0,50, 50,20);
		westPane.add(tf2);
			tf2.setBounds(60,51, 100,20);
		westPane.add(flightLbl);
			flightLbl.setBounds(0,100, 50,20);
		westPane.add(tf3);
			tf3.setBounds(60,101, 100,20);
	}
	public void setCenterPane() {
		JLabel bookingLbl = new JLabel("출발도시");
		JTextField tf1 = new JTextField(10);
		JLabel dateLbl = new JLabel("출발공항");
		JTextField tf2 = new JTextField(10);
		JLabel flightLbl = new JLabel("출발시간");
		JTextField tf3 = new JTextField(10);
		centerPane.add(bookingLbl);
			bookingLbl.setBounds(10,0, 50,20);
		centerPane.add(tf1);
			tf1.setBounds(70,1, 100,20);
		centerPane.add(dateLbl);
			dateLbl.setBounds(10,50, 50,20);
		centerPane.add(tf2);
			tf2.setBounds(70,51, 100,20);
		centerPane.add(flightLbl);
			flightLbl.setBounds(10,100, 50,20);
		centerPane.add(tf3);
			tf3.setBounds(70,101, 100,20);
	}
	public void setEastPane() {
		JLabel bookingLbl = new JLabel("도착도시");
		JTextField tf1 = new JTextField(10);
		JLabel dateLbl = new JLabel("도착공항");
		JTextField tf2 = new JTextField(10);
		JLabel flightLbl = new JLabel("도착시간");
		JTextField tf3 = new JTextField(10);
		eastPane.add(bookingLbl);
			bookingLbl.setBounds(0,0, 50,20);
		eastPane.add(tf1);
			tf1.setBounds(60,1, 100,20);
		eastPane.add(dateLbl);
			dateLbl.setBounds(0,50, 50,20);
		eastPane.add(tf2);
			tf2.setBounds(60,51, 100,20);
		eastPane.add(flightLbl);
			flightLbl.setBounds(0,100, 50,20);
		eastPane.add(tf3);
			tf3.setBounds(60,101, 100,20);
	}
	public static void main(String[] args) {
		new BookingChange2_OLD();

	}

}
