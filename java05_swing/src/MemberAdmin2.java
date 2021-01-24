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
		JLabel num, name, tel, email, addr, writedate;
		JTextField numTf, nameTf, telTf, emailTf, addrTf, writedateTf, searchTf;
		JButton add, edit, remove, delete, esc, eSave, eOpen, search;
		JTable table;
			JScrollPane scroll;
				String data[] = {"번호", "이름", "전화번호", "이메일", "주소", "등록일"};
				String records[][];
		
	public MemberAdmin2() {
		super("회원관리");
		add(topPane);
		
		topPane.setLayout(null);
				
		setField();
		setButton();
		setTable();
		setSearch();
		
		topPaneAdd();
		setBounds();
		
		setResizable(false);
		setSize(840,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setField() {
		num = new JLabel("번호", JLabel.CENTER);
		name = new JLabel("이름", JLabel.CENTER);
		tel = new JLabel("전화번호", JLabel.CENTER);
		email = new JLabel("이메일", JLabel.CENTER);
		addr = new JLabel("주소", JLabel.CENTER);
		writedate = new JLabel("등록일", JLabel.CENTER);
		
		numTf = new JTextField();
		nameTf = new JTextField();
		telTf = new JTextField();
		emailTf = new JTextField();
		addrTf = new JTextField();
		writedateTf = new JTextField();
		
	}
	public void setButton() {
		add = new JButton("추가");
		edit = new JButton("수정");
		remove = new JButton("삭제");
		delete = new JButton("지우기");
		esc = new JButton("종료");
		eSave = new JButton("엘셀로저장");
		eOpen = new JButton("엑셀불러오기");
	}
	public void setTable() {
		DefaultTableModel model = new DefaultTableModel(records, data);
		table = new JTable(model);
		scroll = new JScrollPane(table);
	}
	public void setSearch() {
		searchTf = new JTextField();
		search = new JButton("Search");
	}
	public void topPaneAdd() {
		topPane.add(num);
		topPane.add(numTf);
		topPane.add(name);
		topPane.add(nameTf);
		topPane.add(tel);
		topPane.add(telTf);
		topPane.add(email);
		topPane.add(emailTf);
		topPane.add(addr);
		topPane.add(addrTf);
		topPane.add(writedate);
		topPane.add(writedateTf);
		
		topPane.add(add);
		topPane.add(edit);
		topPane.add(remove);
		topPane.add(delete);
		topPane.add(esc);
		topPane.add(eSave);
		topPane.add(eOpen);
		
		topPane.add("Center", scroll);
		
		topPane.add(searchTf);
		topPane.add(search);
	}
	public void setBounds() {
		num.setBounds(0, 0, 50, 30);
		numTf.setBounds(50, 0, 50, 30);
		
		name.setBounds(0, 30, 50, 30);
		nameTf.setBounds(50, 30, 150, 30);
		
		tel.setBounds(0, 60, 50, 30);
		telTf.setBounds(50, 60, 300, 30);
		
		email.setBounds(0, 90, 50, 30);
		emailTf.setBounds(50, 90, 300, 30);
		
		addr.setBounds(0, 120, 60, 30);
		addrTf.setBounds(50, 120, 600, 30);
		
		writedate.setBounds(0, 150, 60, 30);
		writedateTf.setBounds(50, 150, 600, 30);
		
		add.setBounds(0, 180, 120, 35);
		edit.setBounds(120, 180, 120, 35);
		remove.setBounds(240, 180, 120, 35);
		delete.setBounds(360, 180, 120, 35);
		esc.setBounds(480, 180, 120, 35);
		eSave.setBounds(600, 180, 120, 35);
		eOpen.setBounds(720, 180, 120, 35);
		
		scroll.setBounds(0, 215, 840, 300);
		
		searchTf.setBounds(230, 530, 300, 30);
		search.setBounds(530, 525, 100, 40);
		
		
	}
	public static void main(String[] args) {
		new MemberAdmin2();

	}

}
