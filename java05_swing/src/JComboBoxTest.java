import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JComboBoxTest extends JFrame implements ItemListener {
	// >> Action, Item, PopupMenu.. event 발생
	JComboBox<String> cb1, cb2, cb3;
	Vector<String> v = new Vector<String>();
	//		index num [0]		[1]			[2]			[3]			[4]
	Color[] color = {Color.red, Color.blue, Color.pink, Color.cyan, Color.gray};
	//		index num 		[0]		[1]		[2]		[3]		[4] .. 인덱스 넘보를 호출
	String colorName[] = {"red", "blue", "pink", "cyan", "gray"};
	
	// combobox의 데이터를 가지는 객체
	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	
	
	JPanel pane = new JPanel();
	
	JTextArea ta = new JTextArea();

	public JComboBoxTest() {
		add(ta); // 센터에 text area 생성
		
		//comboBox 1..
		v.add("홍길동");
		v.add("김유신");
		v.add("세종대왕");
		v.add("신사임당");
		v.add("이순신");
		
		cb1 = new JComboBox<String>(v);
		pane.add(cb1);
		add(BorderLayout.NORTH, pane);
		
		//comboBox 2.. 배경색 지정
		cb2 = new JComboBox<String>(colorName);
		pane.add(cb2);
		
		//ComboBoxModel을 이용한 예.. 데이터 출력
		model.addElement("Java");
		model.addElement("Oracle");
		model.addElement("Spring");
		model.addElement("MyBatis");
		
		cb3 = new JComboBox<String>(model);
		pane.add(cb3);
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		
		cb1.addItemListener(this);
		
		//아이템 추가, index [2]에 JSP 추가
		cb3.insertItemAt("JSP", 2);
	}
	
	// 인터페이스 over riding
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource(); //발생한 이벤트를 받아오는 작업 수행
		if(obj == cb3) {
			String str = (String)cb3.getSelectedItem();
			ta.append(str+"\n");
		}else if(obj == cb2) {
			int idx = cb2.getSelectedIndex();
			ta.setBackground(color[idx]);
		}else if(obj == cb1) {
			String vec = (String)cb1.getSelectedItem();
			ta.append("cb1: "+vec+"\n");
		}
		
	}
	

	public static void main(String[] args) {
		new JComboBoxTest();

	}

}
