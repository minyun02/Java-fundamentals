import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarMain02 extends JFrame implements ItemListener{
	int year, week, month, lastDay;
	
	JPanel pane1 = new JPanel();
	JPanel centerPane = new JPanel();
	JPanel dayPane = new JPanel(new GridLayout(1,7));
	JPanel pane2 = new JPanel(new GridLayout(0,7));
	
	JComboBox cb1, cb2;
	DefaultComboBoxModel model1 = new DefaultComboBoxModel();
	DefaultComboBoxModel model2 = new DefaultComboBoxModel();
	
	
	String[] date = {"일", "월", "화", "수", "목", "금", "토"};
	public CalendarMain02() {
		super("카렌다");
		
		Calendar now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH)+1;
	
		
		add("North", pane1);
		pane1.setBackground(Color.GREEN);
		
		JButton btn1 = new JButton("◀");
		JButton btn2 = new JButton("▶");
		JLabel lbl1 = new JLabel("년");
		JLabel lbl2 = new JLabel("월");
		for(int i=year-50; i<=year+100; i++) {
			model1.addElement(i);
		}
		
		cb1 = new JComboBox(model1);
		cb1.setSelectedItem(year);
		for(int i=1; i<=12; i++) {
			model2.addElement(i);
		}
		cb2 = new JComboBox(model2);
		cb2.setSelectedItem(month);
		
		pane1.add(btn1);
		pane1.add(cb1);
		pane1.add(lbl1);
		pane1.add(cb2);
		pane1.add(lbl2);
		pane1.add(btn2);
	
		//================================================
		add("Center", centerPane);
		
		for(int i=0; i<date.length; i++) {
			JLabel dateLbl = new JLabel(date[i]);
			if(i==0) {
				dateLbl.setForeground(Color.red);
			}else if(i == 6) {
				dateLbl.setForeground(Color.blue);
			}
			dayPane.add(dateLbl);
		}
		centerPane.add("North", dayPane);
		
		
		
//		for(int i=0; i<date.length; i++) {
//			JLabel dateLabel1 = new JLabel(date[i], Label.CENTER);
//			dayPane.add(dateLabel1);
//			if(i==0) {
//				dateLabel1.setForeground(Color.red);
//			}else if(i==6) {
//				dateLabel1.setForeground(Color.BLUE);
//			}
//		}
//		centerPane.add("North", dayPane);
		
		
		//dayPrint(year, month);
//		for(int i=1; i<6; i++) {
//			JLabel dateLabel2 = new JLabel(" ", Label.LEFT);
//			pane2.add(dateLabel2);
//		}
//		for(int i=1; i<=31; i++) {
//			String day = Integer.toString(i);
//			JLabel dateLabel3 = new JLabel(day, Label.LEFT);
//			pane2.add(dateLabel3);
//		}
		
		//이벤트 등록하기
		btn1.addItemListener(this);
		btn2.addItemListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		
		//기본세팅
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		int yy = (Integer)cb1.getSelectedItem();
		int mm = (Integer)cb2.getSelectedItem();
		if(obj instanceof JComboBox) {
			dayPrint(yy, mm);
		}
		
	}
	public void dayPrint(int y, int m) {
		pane2.removeAll();
		
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_WEEK);
		
		for(int i=1; i<week; i++) {
			pane2.add(new JLabel(" "));
		}
		for(int i=1; i<=lastDay; i++) {
			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
		}
	}
	public static void main(String[] args) {
		new CalendarMain02();

	}

}
