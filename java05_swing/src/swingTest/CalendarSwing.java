package swingTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwing extends JPanel implements ItemListener, ActionListener{
	Font fnt = new Font("굴림체", Font.BOLD, 20);
	//상단
	JPanel selectPane = new JPanel();
		JButton prevBtn = new JButton("◀");
		JButton nextBtn = new JButton("▶");
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		JLabel yearLbl = new JLabel("년");
		JLabel monthLbl = new JLabel("월");
	//가운데
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel titlePane = new JPanel(new GridLayout(1,7));
			String[] title = {"일", "월", "화", "수", "목", "금", "토"};
		JPanel dayPane = new JPanel(new GridLayout(0,7));
		
	//달력관련 데이터
	Calendar date; //2021, 1, 19
	int year;
	int month;
	public CalendarSwing() {
		//super("달력");
		setLayout(new BorderLayout());
		
		date = Calendar.getInstance();//현재의 날짜 시간 객체 생성
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH) + 1;
		//상단
		selectPane.setBackground(new Color(150, 200, 200));
		selectPane.add(prevBtn); prevBtn.setFont(fnt);
		selectPane.add(yearCombo); yearCombo.setFont(fnt);
		selectPane.add(yearLbl); yearLbl.setFont(fnt);
		selectPane.add(monthCombo); monthCombo.setFont(fnt);
		selectPane.add(monthLbl); monthLbl.setFont(fnt);
		selectPane.add(nextBtn);nextBtn.setFont(fnt);
		
		add(BorderLayout.NORTH, selectPane);
		//현재 년, 월 세팅
		setYear();
		setMonth();
		
		//title 호출
		setCalendarTitle();
		centerPane.add(BorderLayout.NORTH, titlePane);
		add(centerPane);
		//날짜 만들기
		centerPane.add(dayPane);
		setDay();
		
		//setSize(400, 300);
		//setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
	}
	//오버라이딩
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		//해시코드를 비교하기때문에 ==이 가능
		if(obj == prevBtn) { //이전 월
			prevMonth();
		}else if(obj == nextBtn) {
			nextMonth();
		}
	}
	public void nextMonth() {
		if(month==12) {
			year++;
			month=1;
		}else {
			month++;
		}
		setDayReset();
	}
	public void prevMonth() {
		if(month==1) {
			year--;
			month = 12;
		}else {
			month--;
		}
		setDayReset();
	}
	public void setDayReset() {
		//이벤트등록 해제 -> 여기서 이벤트를 해제 안하면 프로그램이 꼬인다.
		yearCombo.removeItemListener(this);
		monthCombo.removeItemListener(this);
		
		yearCombo.setSelectedItem(year); //itemEvent가 발생한다.	
		monthCombo.setSelectedItem(month);
		
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay(); //날짜 처리 함수 호출 
		dayPane.setVisible(true);
		
		//이벤트 다시 등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie) {
		year = (Integer)yearCombo.getSelectedItem();
		month = (Integer)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false);
		dayPane.removeAll();//원래 있는 날짜 지우기
		setDay(); //날짜 처리 함수 호출
		dayPane.setVisible(true);
	}
	//날짜 세팅
	public void setDay() {
		//1일에 대한 요일
		date.set(year, month-1, 1);
		
		int week = date.get(Calendar.DAY_OF_WEEK);
		//마지막날
		int lastDay = date.getActualMaximum(Calendar.DATE);
		
		//공백
		for(int s=1; s<week; s++) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
		//날짜 추가
		for(int day=1; day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day), JLabel.CENTER);
			lbl.setFont(fnt);
			//출력하는 날짜에 대한 요일
			date.set(Calendar.DATE, day); // 19 -> 1
			int w = date.get(Calendar.DAY_OF_WEEK);
			System.out.println(w);
			if(w==1) lbl.setForeground(Color.red);
			if(w==7) lbl.setForeground(Color.blue);
			dayPane.add(lbl);
			
		}
	}
	//년도 세팅
	public void setYear() {
		for(int i=year-50; i<year+20; i++) {
			yearCombo.addItem(i);
		}
		yearCombo.setSelectedItem(year);
	}
	//월 세팅
	public void setMonth() {
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month);
	}
	//월화수목 타이틀 세팅
	public void setCalendarTitle() {
		for(int i=0; i<title.length; i++) {
			JLabel lbl = new JLabel(title[i], JLabel.CENTER);
			lbl.setFont(fnt);
			if(i==0) lbl.setForeground(Color.red);
			if(i==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}

//	public static void main(String[] args) {
//		new CalendarSwing();
//
//	}

}
