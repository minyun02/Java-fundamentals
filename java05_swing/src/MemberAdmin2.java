import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberAdmin2 extends JFrame{
	
	//상단 패널
	JPanel topPane = new JPanel();
		JPanel fieldPane = new JPanel(new GridLayout(6,2));
			JLabel lbl;
			JTextField num, name, tel, email, addr, writeDate;
		//버튼 패널
		JPanel btnPane = new JPanel(new GridLayout(1,7,0,0));
			JButton btn;
			String btnData[] = {"추가", "수정", "삭제", "지우기", "종료", "엑셀로저장", "엑셀불러오기"};
	//하단패널 
	JPanel bottomPane = new JPanel();		
		//JTable 부분 
		JPanel tablePane = new JPanel(new GridLayout(1,1));
			JTable table;
			JScrollPane scroll;
				String memData[] = {"번호", "이름", "전화번호", "이메일", "주소", "등록일"};
				String records[][];
		//검색부분 
	public MemberAdmin2() {
		super("회원관리");
		
		//상단 추가
		setFieldPane();
		setButton();
		add("North", topPane);
		
		//하단추가 
		setTable();
		add("Center", bottomPane);
		
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setTable() {
		DefaultTableModel model = new DefaultTableModel(records, memData);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		tablePane.add(scroll);
		bottomPane.add(tablePane);
	}
	public void setButton() {
		for(int i=0; i<btnData.length; i++) {
			btn = new JButton(btnData[i]);
			btnPane.add(btn);
		}
		topPane.add(BorderLayout.SOUTH, btnPane);
	}
	public void setFieldPane() {
		fieldPane.add(new JLabel("번호", JLabel.LEFT));
		num = new JTextField(5);
		fieldPane.add(num);
		
		fieldPane.add(new JLabel("이름", JLabel.LEFT));
		name = new JTextField(10);
		fieldPane.add(name);
		
		fieldPane.add(new JLabel("전화번호", JLabel.LEFT));
		tel = new JTextField(15);
		fieldPane.add(tel);
		
		fieldPane.add(new JLabel("이메일", JLabel.LEFT));
		email = new JTextField(15);
		fieldPane.add(email);
		
		fieldPane.add(new JLabel("주소", JLabel.LEFT));
		addr = new JTextField(30);
		fieldPane.add(addr);
		
		fieldPane.add(new JLabel("등록일", JLabel.LEFT));
		writeDate = new JTextField(30);
		fieldPane.add(writeDate);
		
		topPane.add(BorderLayout.CENTER, fieldPane);

	}
	public static void main(String[] args) {
		new MemberAdmin2();

	}

}
