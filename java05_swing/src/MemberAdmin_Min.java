import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberAdmin_Min extends JFrame {
	//필드 입력 부분
	JPanel pane1 = new JPanel();
	JPanel pane2 = new JPanel();
	JPanel pane3 = new JPanel();
	JPanel pane4 = new JPanel();
	JPanel pane5 = new JPanel();
	
//		String fieldData[] = {"번호", "이름", "전화번호", "이메일", "주소", "등록일"};
	
		JLabel numLbl = new JLabel("번호");
		JLabel nameLbl = new JLabel("이름");
		JLabel telLbl = new JLabel("전화번호");
		JLabel emailLbl = new JLabel("이메일");
		JLabel addrLbl = new JLabel("주소");
		JLabel writedateLbl = new JLabel("등록일");
		
	public MemberAdmin_Min() {
		super("회원관리");
		add(BorderLayout.NORTH, pane);
		
//		insertData();
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void insertData() {
//		for(int i=0; i<fieldData.length; i++) {
//			JLabel fieldLbl = new JLabel(fieldData[i], JLabel.CENTER);
//			JTextField tf = new JTextField();
//			pane.add(fieldLbl);
//			pane.add(tf);
//			
//		}
		
	}
	public static void main(String[] args) {
		new MemberAdmin_Min();
	}

}
