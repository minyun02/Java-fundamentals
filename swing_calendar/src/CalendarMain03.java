import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarMain03 extends JFrame implements ItemListener {
	//TOP
	JPanel topPane = new JPanel();
		JButton btnBack = new JButton("◀");
		JButton btnNext = new JButton("▶");
		JLabel yearLbl = new JLabel("년");
		JLabel monthLbl = new JLabel("월");
		
		JComboBox comboYear = new JComboBox();
			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
		JComboBox comboMonth = new JComboBox();
			DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
			
		Calendar now;
		int year, month, date;
		
		//CENTER
		JPanel centerPane = new JPanel(new BorderLayout());
			JPanel titlePane = new JPanel(new GridLayout(1,7));
				String day[] = {"일", "월", "화", "수", "목", "금", "토"};
			JPanel datePane = new JPanel(new GridLayout(0,7));
		
	public CalendarMain03() {
		add("North", topPane);
		topPane.add(btnBack);
		
		//년 콤보박스 
		now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH);
		date = now.get(Calendar.DATE);
		
		for(int i=year-70; i<=year+70; i++) {
			yearModel.addElement(i);
		}
		comboYear.setModel(yearModel);
		comboYear.setSelectedItem(year);
		topPane.add(comboYear);
		
		//년 라벨 붙이기
		topPane.add(yearLbl);
		
		//월 콤보박스 넣기 
		for(int i=1;i<=12;i++) {
			monthModel.addElement(i);
		}
		comboMonth.setModel(monthModel);
		comboMonth.setSelectedItem(month);
		topPane.add(comboMonth);
		
		//월 라벨 붙이기
		topPane.add(monthLbl);
		
		topPane.add(btnNext);
		
		//배경색 설정하기
		topPane.setBackground(Color.gray);
		
		//===================================Center Panel
		
		add("Center", centerPane);
		
		for(int i=0; i<day.length; i++) {
			JLabel lbl = new JLabel(day[i], JLabel.CENTER);
			if(i == 0) {
				lbl.setForeground(Color.red);
			}else if(i == 6) {
				lbl.setForeground(Color.blue);
			}
			titlePane.add(lbl);
		}
		centerPane.add("North", titlePane);
		
		//==================================날짜 출력
		dayPrint(year, month);
		centerPane.add(datePane, "Center");
		
		
		//====================================이벤트 등록하기 
		btnBack.addItemListener(this);
		btnNext.addItemListener(this);
		comboYear.addItemListener(this);
		comboMonth.addItemListener(this);
		
		//기본 세팅
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(obj instanceof JButton) {
//			JButton eventBtn = (JButton)obj;
			int y = (Integer)comboYear.getSelectedItem();
			int m = (Integer)comboMonth.getSelectedItem();
			if(obj ==btnBack) {
				if(m==1) {
					y--; m=12;
				}else {
					m--;
				}
				
			}else if(obj == btnNext) {
				if(m==12) {
					y++; m=1;
				}else {
					m++;
				}
			}
			comboYear.setSelectedItem(y);
			comboMonth.setSelectedItem(m);
		}else if(obj instanceof JComboBox ) {
			dayStart();
		}
		
	}
	public void dayStart() {
		datePane.setVisible(false);
		datePane.removeAll();
		dayPrint((Integer)comboYear.getSelectedItem(), 
				(Integer)comboMonth.getSelectedItem());
		datePane.setVisible(true);
	}
	public void dayPrint(int y, int m ) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//공백 출력하기 
		for(int i=1; i<week; i++) {
			datePane.add(new JLabel(" "));
		}
		//날짜 출력하기 
		for(int i=1; i<=lastDate; i++) {
			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
			if((i+week-1)%7==0) {
				lbl.setForeground(Color.blue);
			}else if((i+week-2)%7==0) {
				lbl.setForeground(Color.red);
			}
			datePane.add(lbl);
		}
		
	}
	public static void main(String[] args) {
		new CalendarMain03();

	}

}
