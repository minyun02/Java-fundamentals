import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class EmpFlightChange extends JPanel{
	Font fnt = new Font("굴림체", Font.BOLD, 14);
	
	JButton calBtn = new JButton(new ImageIcon("img/cal.png"));
	JLabel bcpLbl = new JLabel("BCP");
	JTextField tf1 = new JTextField(10);
	
	JLabel depLbl = new JLabel("출발지");
	JTextField tf2 = new JTextField(10);
	
	JLabel desLbl = new JLabel("도착지");
	JTextField tf3 = new JTextField(10);
	JButton searchBtn = new JButton("검색");
	
	////table
	String info[] = {"항공편명", "출발지", "출발시간", "도착지", "도착시간"};
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	//
	JLabel foodLbl = new JLabel("기내식");
	JComboBox<String> cb1;
	String[] food = {"볶음밥,파스타 세트", "한식", "중식", "하외이식"};
	JLabel delayLbl = new JLabel("지연");
	JCheckBox delayCheckBox = new JCheckBox("", false);
	JLabel depTimeLbl = new JLabel("출발시간");
	JTextField depTf = new JTextField(10);
	JLabel arrTimeLbl = new JLabel("~ 도착시간");
	JTextField arrTf = new JTextField(10);
	JLabel cancelLbl = new JLabel("결항");
	JComboBox<String> cancelState;
	String[] state = {"기상악화", "기장실종", "기타사유"};
	JCheckBox cancel = new JCheckBox("", false);
	
	JButton btn2 = new JButton("설정완료");
	public EmpFlightChange() {
		setLayout(null);
		this.setBackground(Color.white);
		
		add(calBtn).setBounds(200,100, 35,35);
			calBtn.setBorderPainted(false);
			calBtn.setContentAreaFilled(false);
			calBtn.setFocusPainted(false);
		add(bcpLbl).setBounds(250, 100, 50, 35);
			bcpLbl.setFont(fnt);
		add(tf1).setBounds(285, 105, 100, 25);
			tf1.setFont(fnt);
		add(depLbl).setBounds(400, 100, 50, 35);
			depLbl.setFont(fnt);
		add(tf2).setBounds(445, 105, 100, 25);
			tf2.setFont(fnt);
		add(desLbl).setBounds(560, 100, 50, 35);
			desLbl.setFont(fnt);
		add(tf3).setBounds(605, 105, 100, 25);
			tf3.setFont(fnt);
		add(searchBtn).setBounds(720, 101, 70, 30);
			searchBtn.setFont(fnt);
			searchBtn.setForeground(Color.white);
			searchBtn.setBackground(new Color(255,128,128));
			searchBtn.setBorder(new LineBorder(Color.white, 1, true));
		
		//table
		model = new DefaultTableModel(info,0);
		table = new JTable(model);
		sp  = new JScrollPane(table);
		add(sp).setBounds(200, 165, 600, 300);
			sp.getViewport().setBackground(Color.white);
		
		//기내식
		add(foodLbl).setBounds(350, 480, 60,35);
			foodLbl.setFont(fnt);
		cb1 = new JComboBox<String> (food);
		add(cb1).setBounds(450, 481, 180, 35);
			cb1.setFont(fnt);
			cb1.setBackground(Color.white);
			//cb1.setAlignmentX(CENTER_ALIGNMENT);
		
		//지연 상태
		add(delayLbl).setBounds(350, 515, 50, 35);
			delayLbl.setFont(fnt);
		add(delayCheckBox).setBounds(450, 524, 17, 17);
			delayCheckBox.setBackground(Color.white);
		add(depTimeLbl).setBounds(480,515, 60, 35);
			depTimeLbl.setFont(fnt);
		add(depTf).setBounds(545, 521, 80, 25);
			depTf.setFont(fnt);
		add(arrTimeLbl).setBounds(630, 516, 80, 35);
			arrTimeLbl.setFont(fnt);
		add(arrTf).setBounds(710, 521, 80, 25);
			arrTf.setFont(fnt);
			
		//결항 상태
		add(cancelLbl).setBounds(350, 550, 50, 35);
			cancelLbl.setFont(fnt);
		add(cancel).setBounds(450, 559, 17, 17);
			cancel.setBackground(Color.white);
		cancelState = new JComboBox<String>(state);
		add(cancelState).setBounds(480,552, 150, 30);
			cancelState.setFont(fnt);
			cancelState.setBackground(Color.white);
			
		add(btn2).setBounds(480, 600, 100,30);
			btn2.setFont(fnt);
			btn2.setForeground(Color.white);
			btn2.setBackground(new Color(255,128,128));
			btn2.setBorder(new LineBorder(Color.white, 1, true));
		
		setSize(1000, 800);
		setVisible(true);
	}

	

}
