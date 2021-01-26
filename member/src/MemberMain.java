import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberMain extends JFrame implements ActionListener{
	//Top Panel - JFrame -> North -> 회원입력폼 
	JPanel mainNorthPane = new JPanel(new BorderLayout());
		JPanel formLabelPane = new JPanel(new GridLayout(6,1));//mainNortPane의 west에 들어갈 라
			String lbl[] =  {"번호", "이름", "전화번호", "이메일", "주소", "등록일"};
		JPanel formCenterPane = new JPanel(new GridLayout(6,1));
							//								번호 								이름				연락								이메
			JTextField tf[] = {new JTextField(4), new JTextField(10), new JTextField(20), new JTextField(30),
					//				주소							등록
					new JTextField(50), new JTextField(15)};
		
	//JFrame - Center - buttons, JTable, searchbox
	JPanel mainCenterPane = new JPanel(new BorderLayout());
		//Buttons
		JPanel buttonPane = new JPanel(new GridLayout(1,0));
			String btnLbl[] = {"전체목록", "추가", "수정",  "삭제", "지우기", "종료", "엑셀로쓰기", "엑셀에서 가져오기"};
		//JTable
		JTable table;
			JScrollPane sp;
			DefaultTableModel model;
	//JFrame - South - 검색
		JPanel searchPane = new JPanel();
			JTextField searchTf = new JTextField(20);
			JButton searchBtn = new JButton("Search");
			
	public MemberMain() {
		super("회원관리");
		add("North", mainNorthPane);
			for(int idx=0; idx<lbl.length; idx++) {
				JLabel formLabel = new JLabel(lbl[idx]);
				formLabelPane.add(formLabel);
			}
			mainNorthPane.add("West", formLabelPane);
		
		//TextField
			for(int idx=0; idx<tf.length; idx++) {
				JPanel p = new JPanel();
				p.setLayout(new FlowLayout(FlowLayout.LEFT));
				p.add(tf[idx]);
				formCenterPane.add(p);
			}
			mainNorthPane.add("Center", formCenterPane);
		//Buttons
		add("Center", mainCenterPane);	
			for(int idx=0; idx<btnLbl.length; idx++) {
				JButton btn = new JButton(btnLbl[idx]);
				buttonPane.add(btn);
				
				//이벤트 등록 
				btn.addActionListener(this);
			}
			mainCenterPane.add("North", buttonPane);
		//JTable
			model = new DefaultTableModel(lbl, 0);
			table = new JTable(model);
			sp = new JScrollPane(table);
			mainCenterPane.add("Center", sp);
		//검색
		add("South", searchPane);
			searchPane.add(searchTf);
			searchPane.add(searchBtn);
			
		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		searchBtn.addActionListener(this);
		//mouse는 메소드가 많아서 어댑터를 이용했다.
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
			}
		});
		
		//초기화면에 회언전체 목록 보여야 함.
		getMemberAll();
	}
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("Search")) {//검
			memberSearch();
		}else if(eventBtn.equals("전체목록")) {
			getMemberAll();
		}else if(eventBtn.equals("추가")) {
			setMember();
		}
	}
	//회원 추가 
	public void setMember() {
		//폼의 데이터를 VO에 세팅 
		MemberVO vo = new MemberVO( tf[1].getText(), tf[2].getText(), tf[3].getText(), tf[4].getText());

		//이름과 연락처가 있을때 만 데이터베이스에 추가한다.
		if(vo.getUsername().equals("") || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "이름과 연락처는 반드시 입력하여야 합니다.");
		}else if(vo.getUsername().length()>4) {// 홍길동 
			JOptionPane.showMessageDialog(this, "이름은 4글자 이하로 등록이 가능합니다");
		}else {
		
		
	}
	//회원 검색
	public void memberSearch() {
		//검색어에 입력된 데이터
		String searchWord = searchTf.getText();
		if(searchWord.equals("")) {//검색어가 없을때
			JOptionPane.showMessageDialog(this, "검색어를 입력후 검색하세요.");
		}else { //검색어가 있을때
			MemberDAO dao = new MemberDAO();
			List<MemberVO> searchList = dao.getSearchRecord(searchWord);
			if(searchList.size()==0) {//검색조건의 회원이 없을 경우
				JOptionPane.showMessageDialog(this, searchWord+"의 검색 결과가 존재하지 않습니다.");
			}else {//있을 경우
				setNewTableList(searchList);
			}
			searchTf.setText("");
		}
	}
	//회원 전체 선택
	public void getMemberAll() {
		//데이터베이스의 모든 회원을 선택해서 JTable에 표시한다.
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> lst = dao.memberAllSelect(); //회원이 여기에 담긴다...
		
		setNewTableList(lst);
	}
	public void setNewTableList(List<MemberVO> lst) {
		model.setRowCount(0); //JTable의 모든 레코드 지우기
		for(int i=0; i<lst.size(); i++) { //lst.size() -> 컬렉션이 몇개 들어있는지 알려주는 length같은거
			MemberVO vo = lst.get(i);
			Object[] data = {vo.getNum(), vo.getUsername(), vo.getTel()
					, vo.getEmail(), vo.getAddr(), vo.getWritedate()};
			model.addRow(data);
		}
	}
	public static void main(String[] args) {
		new MemberMain();

	}

}
