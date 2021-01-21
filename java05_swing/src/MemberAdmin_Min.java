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

public class MemberAdmin_Min extends JFrame {
	//상단 필 입력 부분
	JPanel topPane = new JPanel(new GridLayout(6,2,5,10));
	JTextField num, name, tel, email, addr, writeDate;
	//아래패
	JPanel bottomPane = new JPanel();//new GridLayout(3,0)
	//버튼 부분
	JPanel btnPan = new JPanel(new GridLayout(1,7));
		String btnData[] = {"추가", "수정", "삭제", "지우기", "종료", "엑셀로저장", "엑셀불러오기"};
		
	//JTable 부분 
		JTable table;
		JScrollPane scroll;
			String data[] = {"번호", "이름", "전화번호", "이메일", "주소", "등록일"};
			String records[][];
	public MemberAdmin_Min() {
		super("회원관리");
		
		setField();
		add(BorderLayout.NORTH, topPane);
		
		setBtn();
		add(BorderLayout.CENTER, bottomPane);
		//
		setTable();
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setTable() {
		DefaultTableModel model = new DefaultTableModel(records, data);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		bottomPane.add("Center", scroll);
		
	}
	public void setBtn() {
		for(int i=0; i<btnData.length; i++) {
			JButton btn = new JButton(btnData[i]);
			btnPan.add(BorderLayout.NORTH, btn);
		}
		bottomPane.add(btnPan);
	}	
	public void setField() {
		topPane.add(new JLabel("번호", JLabel.LEFT));
		num = new JTextField(5);
		topPane.add(num);
		
		topPane.add(new JLabel("이름", JLabel.LEFT));
		name = new JTextField(10);
		topPane.add(name);
		
		topPane.add(new JLabel("전화번호", JLabel.LEFT));
		tel = new JTextField(15);
		topPane.add(tel);
		
		topPane.add(new JLabel("이메일", JLabel.LEFT));
		email = new JTextField(15);
		topPane.add(email);
		
		topPane.add(new JLabel("주소", JLabel.LEFT));
		addr = new JTextField(30);
		topPane.add(addr);
		
		topPane.add(new JLabel("등록일", JLabel.LEFT));
		writeDate = new JTextField(30);
		topPane.add(writeDate);
	}
	public static void main(String[] args) {
		new MemberAdmin_Min();
	}

}
