import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookingChange3 extends JFrame {
	Font fnt = new Font("굴림체", Font.BOLD, 14);
	Font titleFnt = new Font("굴림체", Font.BOLD, 32);
	
	JLabel titleLbl1 = new JLabel("선택 항공 내역");
	String flightStr[] = {"출발지", "도착지", "출발일", "도착일", "촐발시간", "도착시간", "항공편명", "좌석", "운임"};
	JTable table1;
	JScrollPane sp1;
	DefaultTableModel model1;
	JCheckBox check1 = new JCheckBox("", false);
	JLabel lbl1 = new JLabel("상기 내용을 확인하고 변경을 진행합니다.");
	
	JLabel titleLbl2 = new JLabel("탑승자 정보");
	String passengerStr[] = {"성명(한)", "성명(영)", "여권번호", "여권만료일", "발행국가", "생년월일", "연락처", "이메일"};
	JTable table2;
	JScrollPane sp2;
	DefaultTableModel model2;
	JCheckBox check2 = new JCheckBox("", false);
	JLabel lbl2 = new JLabel("해당 정보를 확인하세요. 위 내용은 예약 완료 후 변경이 불가합니다.");
	
	JLabel titleLbl3 = new JLabel("결제 정보");
	String paymentStr[] = {"구분", "변경 전", "변경 후", "결제예정금액"};
	JTable table3;
	JScrollPane sp3;
	DefaultTableModel model3;
	JCheckBox check3 = new JCheckBox("", false);
	JLabel lbl3 = new JLabel("상기 내용을 확인하고 결제를 진행합니다.");
	
	JButton payBtn = new JButton("결제");
	JButton cancelBtn = new JButton("취소");
	public BookingChange3() {
		setLayout(null);
		
		//table1
		add(titleLbl1).setBounds(410, 60, 200, 50);
			titleLbl1.setFont(titleFnt);
		model1 = new DefaultTableModel(flightStr, 0);
		table1 = new JTable(model1);
		sp1 = new JScrollPane(table1);
		add(sp1).setBounds(100,110, 800,100);
		add(check1).setBounds(93, 200, 50, 50);
		add(lbl1).setBounds(120, 213, 400, 25);
			lbl1.setFont(fnt);
		
		//table2
		add(titleLbl2).setBounds(430, 230, 200, 50);
			titleLbl2.setFont(titleFnt);
		model2  = new DefaultTableModel(passengerStr, 0);
		table2 = new JTable(model2);
		sp2 = new JScrollPane(table2);
		add(sp2).setBounds(100,280, 800, 100);
		add(check2).setBounds(93, 370, 50,50);
		add(lbl2).setBounds(120, 383, 400, 25);
			lbl2.setFont(fnt);
		
		//table3
		add(titleLbl3).setBounds(440, 410, 200, 50);
			titleLbl3.setFont(titleFnt);
		model3 = new DefaultTableModel(paymentStr,0);
		table3 = new JTable(model3);
		sp3 = new JScrollPane(table3);
		add(sp3).setBounds(300,460, 400, 100);
		add(check3).setBounds(370, 550, 50, 50); //283
		add(lbl3).setBounds(402, 561, 400, 27); //310
			lbl3.setFont(fnt);
			
		//buttons
		add(payBtn).setBounds(370, 610, 100, 35);
			payBtn.setFont(fnt);
		add(cancelBtn).setBounds(530, 610, 100, 35);
			cancelBtn.setFont(fnt);
		
		
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BookingChange3();

	}

}
