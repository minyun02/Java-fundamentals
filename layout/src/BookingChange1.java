import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookingChange1 extends JFrame{
	Font fnt = new Font("굴림체", Font.BOLD, 14);
	Font fnt1 = new Font("굴림체", Font.BOLD, 20);
	
	JLabel numLbl1 = new JLabel("예약번호");
	JLabel numLbl2 = new JLabel("AB1C57");
	JLabel dateLbl1 = new JLabel("출발일시");
	JLabel dateLbl2 = new JLabel("2021-01-31");
	JLabel dateLbl3 = new JLabel(" ");
	
	JLabel depLbl = new JLabel("로스엔젤레스");
	JLabel depALbl = new JLabel("GMP");
	JLabel depTimeLbl = new JLabel("15:00");
	
	ImageIcon ii1 = new ImageIcon("img/arrow.png");
	Image img = ii1.getImage();
	Image changeImg = img.getScaledInstance(80, 40, img.SCALE_SMOOTH);
	ImageIcon changeIcon = new ImageIcon(changeImg);
	JLabel arrowLbl = new JLabel(changeIcon);
	
	JLabel flightNumLbl = new JLabel("KK512");
	
	JLabel desLbl = new JLabel("산타마리아고메즈");
	JLabel desALbl = new JLabel("CJU");
	JLabel arrTimeLbl = new JLabel("16:00");

	JButton changeBtn = new JButton("예약변경");
	JButton cancelBtn = new JButton("예약취소");
	
	///table
	String booking[] = {"예약번호", "출발일시", "항공편명", "출발지", "출발공항", "출발시간", "도착지", "도착공항", "도착시간"};
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	public BookingChange1() {
		setLayout(null);
		setBackground(Color.white);
		
		add(numLbl1).setBounds(420,90, 50, 25);
			numLbl1.setFont(fnt);
		add(numLbl2).setBounds(510, 90, 100, 25);
			numLbl2.setFont(fnt);
		add(dateLbl1).setBounds(420, 110, 50, 25);
			dateLbl1.setFont(fnt);
		add(dateLbl2).setBounds(510, 110, 100, 25);
			dateLbl2.setFont(fnt);
//		add(dateLbl3).setBounds(520, 120, 100, 25);
//			dateLbl3.setFont(fnt);
			
		add(depLbl).setBounds(345, 150, 100, 25);
			depLbl.setFont(fnt);
		add(depALbl).setBounds(345,170, 60, 25);
			depALbl.setFont(fnt1);
		add(depTimeLbl).setBounds(345, 190, 60, 25);	
			depTimeLbl.setFont(fnt);
			
		add(arrowLbl).setBounds(465, 165, 80, 40);
		add(flightNumLbl).setBounds(480, 195, 60, 25);
			flightNumLbl.setFont(fnt);
			
		add(desLbl).setBounds(610, 150, 100, 25);
			desLbl.setFont(fnt);
		add(desALbl).setBounds(610, 170, 60, 25);
			desALbl.setFont(fnt1);
		add(arrTimeLbl).setBounds(610, 190, 60, 25);
			arrTimeLbl.setFont(fnt);
			
		add(changeBtn).setBounds(400, 230, 70, 35);
			changeBtn.setFont(fnt);
		add(cancelBtn).setBounds(530, 230, 70, 35);
			cancelBtn.setFont(fnt);
			
		////table
		model = new DefaultTableModel(booking, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		add(sp).setBounds(200, 300, 600, 300);
			
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BookingChange1();

	}

}
