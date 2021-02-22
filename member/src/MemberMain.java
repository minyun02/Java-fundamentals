import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class MemberMain extends JFrame implements ActionListener {
	// Top Panel - JFrame -> North -> 회원입력폼
	JPanel mainNorthPane = new JPanel(new BorderLayout());
	JPanel formLabelPane = new JPanel(new GridLayout(6, 1));// mainNortPane의 west에 들어갈 라
	String lbl[] = { "번호", "이름", "전화번호", "이메일", "주소", "등록일" };
	JPanel formCenterPane = new JPanel(new GridLayout(6, 1));
	// 번호 이름 연락 이메
	JTextField tf[] = { new JTextField(4), new JTextField(10), new JTextField(20), new JTextField(30),
			// 주소 등록
			new JTextField(50), new JTextField(15) };

	// JFrame - Center - buttons, JTable, searchbox
	JPanel mainCenterPane = new JPanel(new BorderLayout());
	// Buttons
	JPanel buttonPane = new JPanel(new GridLayout(1, 0));
	String btnLbl[] = { "전체목록", "추가", "수정", "삭제", "지우기", "종료", "엑셀로쓰기", "엑셀에서 가져오기" };
	// JTable
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	// JFrame - South - 검색
	JPanel searchPane = new JPanel();
	JTextField searchTf = new JTextField(20);
	JButton searchBtn = new JButton("Search");
	
	String records[][];

	public MemberMain() {
		super("회원관리");
		add("North", mainNorthPane);
		for (int idx = 0; idx < lbl.length; idx++) {
			JLabel formLabel = new JLabel(lbl[idx]);
			formLabelPane.add(formLabel);
		}
		mainNorthPane.add("West", formLabelPane);
		
		// TextField
		for (int idx = 0; idx < tf.length; idx++) {
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			p.add(tf[idx]);
			formCenterPane.add(p);
		}
		mainNorthPane.add("Center", formCenterPane);
		// Buttons
		add("Center", mainCenterPane);
		for (int idx = 0; idx < btnLbl.length; idx++) {
			JButton btn = new JButton(btnLbl[idx]);
			buttonPane.add(btn);
			btn.setBackground(new Color(51,153,255));
			// 이벤트 등록
			btn.addActionListener(this);
		}
		mainCenterPane.add("North", buttonPane);
		// JTable
		model = new DefaultTableModel(lbl, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		mainCenterPane.add("Center", sp);
		// 검색
		add("South", searchPane);
		searchPane.add(searchTf);
		searchPane.add(searchBtn); searchBtn.setBackground(new Color(51,153,255));

		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		searchBtn.addActionListener(this);
		// mouse는 메소드가 많아서 어댑터를 이용했다.
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				// JTable에 있는 필드내용을 JTextField에 나오게
				// 이벤트 발생 버튼이 마우스 왼쪽(1)이면
				if (me.getButton() == 1) {
					// 선택된 행번호 가져오기
					int row = table.getSelectedRow();
					int col = table.getColumnCount();
					for (int c = 0; c < col; c++) {
						if (c == 0) {// 숫자일때
							tf[c].setText(String.valueOf(model.getValueAt(row, c)));
						} else {// 문자일때
							tf[c].setText((String) model.getValueAt(row, c));// 원래 문자열이지만 object에 들어있어서 변환
						}
					}
				}
			}
		});

		// 초기화면에 회언전체 목록 보여야 함.
		getMemberAll();
	}

	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if (eventBtn.equals("Search")) {// 검색
			memberSearch();
		} else if (eventBtn.equals("전체목록")) {
			getMemberAll();
		} else if (eventBtn.equals("추가")) {
			setMember();
		} else if (eventBtn.equals("지우기")) {
			setFormClear();
		} else if (eventBtn.equals("종료")) {
			System.exit(0);
			dispose();
		} else if (eventBtn.equals("수정")) {
			setMemberUpdate();
		} else if (eventBtn.equals("삭제")) {
			setMemberDelete();
		} else if (eventBtn.equals("엑셀로쓰기")) {
			setMemberExcelSave();
		}else if(eventBtn.equals("엑셀에서 가져오기")) {
			getMemberExcelOpen();
		}
	}
	// 엑셀에서 회원목록 가져오기
	public void getMemberExcelOpen() {
	//어떤 파일 가져올지 고르기 위해 파일탐색기 객체 생성
		JFileChooser fc = new JFileChooser();
		FileFilter ff = new FileNameExtensionFilter("*.xls", "xls", "XLS");//파일 확장자를 필터링해준다
		fc.setFileFilter(ff); // 필터를 파일탐색기에 설정
		
		//0:열기 1:취소 -> 파일탐색기에서 누른 버튼을 int에 담아준다
		int state = fc.showOpenDialog(this);
		
		if(state==0) {//열기 버튼을 눌렀을때 불러올 파일 정보를 받아야한다.
			try {
				//선책해 놓은 파일 정보
				File selectFileName = fc.getSelectedFile();
				//파일에서 데이터를 읽어와야하니까 인풋스트림을 만든다
				FileInputStream fis = new FileInputStream(selectFileName);
				
				//엑셀에서 파일을 사용할 수 있는 객체를 생성한다.
				POIFSFileSystem poi = new POIFSFileSystem(fis);
				
				//workbook 구하기
				HSSFWorkbook workbook = new HSSFWorkbook(poi);
				//sheet 구하기
				HSSFSheet sheet = workbook.getSheet("회원정보"); //회원정보라는 시트를 읽겠다
				//row 구하기
				int rowCount = sheet.getPhysicalNumberOfRows();//위에서 읽어온 시트 속 행의 수를 구한다 -> for문을 위해
				
				List<MemberVO> lst = new ArrayList<MemberVO>(); //읽어온 레코드를 list에 담기위해 객체 생성
				for(int row=1; row<rowCount; row++) {
					MemberVO vo = new MemberVO();
					//cell 구하기
					HSSFRow rowData = sheet.getRow(row);
					//번호
					vo.setNum((int)rowData.getCell(0).getNumericCellValue()); //cell에 담긴 numeric 데이터가 double로 담겨온다
					vo.setUsername(rowData.getCell(1).getStringCellValue()); //setUsername에 1번지 cell속에 담긴 value를 담는다.
					vo.setTel(rowData.getCell(2).getStringCellValue());
					vo.setEmail(rowData.getCell(3).getStringCellValue());
					vo.setAddr(rowData.getCell(4).getStringCellValue());
					vo.setWritedate(rowData.getCell(5).getStringCellValue());
					lst.add(vo);
				}
				setNewTableList(lst);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 엑셀 파일로 쓰기
	public void setMemberExcelSave() {
		//파일탐색기 객체 생성
		JFileChooser fc = new JFileChooser();
		//파일 필터링 만들기
		FileFilter ff = new FileNameExtensionFilter("*.xls", "xls", "XLS", "Xls");
		fc.setFileFilter(ff);
		
		int state = fc.showSaveDialog(this);
		if(state==0) {//탐색기에서 저장버튼을 선택시
			//선택한 위치와 파일명을 얻어오기
			File selFile = fc.getSelectedFile();
			
			//엑셀객체만들기
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("회원정보");
			
			//제목
			HSSFRow row = sheet.createRow(0);
			//하나씩
//			row.createCell(0).setCellValue("번호");
//			row.createCell(1).setCellValue("이름");
//			row.createCell(2).setCellValue("연락처");
			for(int i=0; i<lbl.length; i++) {
				row.createCell(i).setCellValue(lbl[i]);
			}
			//저장할 행의 숫자를 구한다 -> JTable의 행의 수
			int rowCount = table.getRowCount();
			for(int i=0; i<rowCount; i++) {//0, 1, 2 ....
				HSSFRow r = sheet.createRow(i+1); //두번째 줄이 만들어진다
				//칸수 구하기
				int c = table.getColumnCount();
				for(int j=0; j<c; j++) {
					if(j==0) {//번호
						r.createCell(j).setCellValue((int)table.getValueAt(i, j));
					}else {//번호 아닐때
						r.createCell(j).setCellValue((String)table.getValueAt(i, j));
					}
				}
			}
			////////////////for문이 끝나면 workbook이 만들어짐.
			//파일로 쓰기
			try {
				FileOutputStream fos = new FileOutputStream(selFile);
				workbook.write(fos);
				if(fos!=null) fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 회원번호 삭제
	public void setMemberDelete() {
		int num = Integer.parseInt(tf[0].getText()); // 삭제할 레코드 번호

		MemberDAO dao = new MemberDAO();
		int result = dao.memberDelete(num);
		String msg = "회원정보가 삭제되었습니다.";
		if (result > 0) {
			getMemberAll();
		} else {
			msg = "회원정보 삭제에 실패하였습니다.";
		}
		setFormClear(); // 삭제에 성공해도 폼 비우고 실패해도 비우고
		JOptionPane.showMessageDialog(this, msg);
	}

	// 회원정보 수정
	public void setMemberUpdate() {
		// 수정할 데이터를 VO에 보내는 작업
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(tf[0].getText()));// "5" -> 5로 변환
		vo.setTel(tf[2].getText());// 연락처
		vo.setEmail(tf[3].getText());// 이메일
		vo.setAddr(tf[4].getText());// 주소

		MemberDAO dao = new MemberDAO();
		int result = dao.memberUpdate(vo);
		if (result > 0) {// 수정 성공
			JOptionPane.showMessageDialog(this, "회원정보를 수정하였습니다.");
			getMemberAll();
			setFormClear();
		} else { // 수정 실패
			JOptionPane.showMessageDialog(this, "회원정보 수정 실패하였습니다.");
		}
	}
	// 폼의 값 초기화
	public void setFormClear() {
		for (int i = 0; i < tf.length; i++) {
			tf[i].setText("");
		}
	}

	// 회원 등록
	public void setMember() {
		// 폼의 데이터를 VO에 세팅
		MemberVO vo = new MemberVO(tf[1].getText(), tf[2].getText(), tf[3].getText(), tf[4].getText());

		// 이름과 연락처가 있을때 만 데이터베이스에 추가한다.
		if (vo.getUsername().equals("") || vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "이름과 연락처는 반드시 입력하여야 합니다.");
		} else if (vo.getUsername().length() > 4) {// 홍길동
			JOptionPane.showMessageDialog(this, "이름은 4글자 이하로 등록이 가능합니다");
		} else {
			MemberDAO dao = new MemberDAO();
			int result = dao.memberInsert(vo);
			if (result > 0) {// 회원등록 성공
				JOptionPane.showMessageDialog(this, "회원이 등록되었습니다.");
				getMemberAll();
				setFormClear();
			} else {// 회원등록 실패
				JOptionPane.showMessageDialog(this, "회원등록이 실패하였습니다.");
			}
		}
	}
	// 회원 검색
	public void memberSearch() {
		// 검색어에 입력된 데이터
		String searchWord = searchTf.getText();
		System.out.println(searchWord);
		if (searchWord.equals("")) {// 검색어가 없을때
			JOptionPane.showMessageDialog(this, "검색어를 입력후 검색하세요.");
		} else { // 검색어가 있을때
			MemberDAO dao = new MemberDAO();
			List<MemberVO> searchList = dao.getSearchRecord(searchWord);
			if (searchList.size() == 0) {// 검색조건의 회원이 없을 경우
				JOptionPane.showMessageDialog(this, searchWord + "의 검색 결과가 존재하지 않습니다.");
			} else {// 있을 경우
				setNewTableList(searchList);
			}
			searchTf.setText("");
		}
	}

	// 회원 전체 선택
	public void getMemberAll() {
		// 데이터베이스의 모든 회원을 선택해서 JTable에 표시한다.

		MemberDAO dao = new MemberDAO();
		List<MemberVO> lst = dao.memberAllSelect(); // 회원이 여기에 담긴다...

		setNewTableList(lst);
	}

	public void setNewTableList(List<MemberVO> lst) { //테이블을 비우고 리스트에 담긴 데이터를 불러오고 테이블에 출력하는 메소드
		model.setRowCount(0); // JTable의 모든 레코드 지우기
		for (int i = 0; i < lst.size(); i++) { // lst.size() -> 컬렉션이 몇개 들어있는지 알려주는 length같은거
			MemberVO vo = lst.get(i);
			Object[] data = { vo.getNum(), vo.getUsername(), vo.getTel(), vo.getEmail(), vo.getAddr(),
					vo.getWritedate() };
			model.addRow(data);
		}
	}

	public static void main(String[] args) {
		new MemberMain();

	}

}
