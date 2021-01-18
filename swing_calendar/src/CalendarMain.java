

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalendarMain extends JFrame implements ItemListener{
	int calYear, calMonth;
	//년,월 버튼을 담을 위 패널
	JPanel paneNorth = new JPanel(new GridLayout(1,4));
	//ComboBox
	JComboBox cbYear, cbMonth;
	DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<Integer>();
	//년도를 담을 배열 
	String[] year = new String[100];
	
	
	
	//요일을 담을 아래 패널 
	JPanel paneCenter = new JPanel(new GridLayout(0,7));
	String dayName[] = {"일", "월", "화", "수", "목", "금", "토"};
	
	
	public CalendarMain() {
		super("카렌다");
		
		add("North", paneNorth);
		paneNorth.setBackground(Color.BLUE);
		paneNorth.add(new Button("<<"));
		//년도 콤보박스에 넣기 
		for(int i=0; i<100; i++) {
			int putYear = i + 2021;
			year[i] = Integer.toString(putYear);
			cbYear = new JComboBox<String> (year);
		}
		paneNorth.add(cbYear);
		
		//월 콤보박스에 넣기
		for(int i =1; i<=12; i++) {
			model.addElement(i);
		}
		cbMonth = new JComboBox<Integer>(model);
		paneNorth.add(cbMonth);
		
		paneNorth.add(new Button(">>")); 
		
		//===========================================
		add("Center", paneCenter);
		//요일 버튼 만들어 넣기
		for(int i=0; i<dayName.length; i++) {
			JButton btn = new JButton(dayName[i]);
			paneCenter.add(btn);
			btn.setEnabled(false);
			if(i==0) {
				btn.setForeground(Color.RED);
			}else if(i==6) {
				btn.setForeground(Color.BLUE);
			}
		}
		//날짜 세팅하기
		int year = calYear;
		int month = calMonth;
		Calendar modifyCalendar = getCalendar(year, month);
		int week = modifyCalendar.get(Calendar.DAY_OF_WEEK);
		int lastDay = modifyCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//공백을 버튼에 넣기
		for(int i=0; i<week; i++) {
			JButton btn = new JButton(" ");
			paneCenter.add(btn);
		}
		//날짜를 버튼에 넣기
		for(int i =1; i<=lastDay; i++) {
			String date = Integer.toString(i);
			JButton btnDate = new JButton(date);
			paneCenter.add(btnDate);
			if((i+week-1)%7==0) {
				btnDate.setForeground(Color.RED);
			}else if((i+week-7)%7==0) {
				btnDate.setForeground(Color.BLUE);
			}
		}
		//기본 세팅 
		setSize(400,350);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록하기
		cbYear.addItemListener(this);
		cbMonth.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(obj == cbYear) {
			String year = (String)cbYear.getSelectedItem();
			calYear= Integer.parseInt(year);
			System.out.println(calYear);
		}else if(obj == cbMonth) {
			int month = cbMonth.getSelectedIndex();
			calMonth = month;
			System.out.println(calMonth);
		}
	}
	public Calendar getCalendar(int y, int m) {
		Calendar now = Calendar.getInstance();
		now.set(y,  m, 1);
		return now;
	}
	public static void main(String[] args) {
		new CalendarMain();

	}

}
