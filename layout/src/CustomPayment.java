import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CustomPayment extends JFrame{
	Font fnt = new Font("굴림체", Font.BOLD, 14);
	
	JLabel amountLbl1 = new JLabel("총 운임");
	JLabel amountLbl2 = new JLabel("570000");
	JLabel wonLbl = new JLabel("원");
	
	JLabel paymentLbl = new JLabel("결제수단");
	String paymentStr[] = {"카드결제", "계좌이체"};
	JComboBox<String> paymentBox;
	
	JLabel cardNumLbl = new JLabel("카드번호");
	JTextField cardNumTf= new JTextField(20);
	
	JLabel mileageLbl1 = new JLabel("적립 마일리지");
	JLabel mileageLbl2 = new JLabel("570");
	JLabel mileageLbl3 = new JLabel("등급명");
	JLabel mileageLbl4 = new JLabel("보유 마일리지");
	JLabel mileageLbl5 = new JLabel("3800");
	JButton mileageBtn = new JButton("사용하기");
	
	JLabel finalPayLbl1 = new JLabel("최종 결제금액");
	JLabel finalPayLbl2 = new JLabel("551200");
	
	JLabel wonLbl2 = new JLabel("원");
	
	JButton payBtn = new JButton("결제");
	JButton cancelBtn = new JButton("취소");
	
	public CustomPayment() {
		setLayout(null);
		
		add(amountLbl1).setBounds(70,100, 80, 25); amountLbl1.setFont(fnt); 
		add(amountLbl2).setBounds(200, 100, 100, 25);amountLbl2.setFont(fnt); 
		add(wonLbl).setBounds(270,100, 20,25);	wonLbl.setFont(fnt);
			
		add(paymentLbl).setBounds(70, 130, 80, 25); paymentLbl.setFont(fnt);
		paymentBox = new JComboBox<String>(paymentStr);
		add(paymentBox).setBounds(200, 130, 100, 25); paymentBox.setFont(fnt);
			
		add(cardNumLbl).setBounds(70, 160, 80, 25); cardNumLbl.setFont(fnt);
		add(cardNumTf).setBounds(200,160, 160, 25);	cardNumTf.setFont(fnt);
			
		add(mileageLbl1).setBounds(70,190, 80,25); mileageLbl1.setFont(fnt);
		add(mileageLbl2).setBounds(200,190, 60,25); mileageLbl2.setFont(fnt);
		add(mileageLbl3).setBounds(270,190, 60, 25); mileageLbl3.setFont(fnt);
		
		add(mileageLbl4).setBounds(70,220, 80,25); mileageLbl4.setFont(fnt);
		add(mileageLbl5).setBounds(200,220, 60,25); mileageLbl5.setFont(fnt);
		add(mileageBtn).setBounds(270,220, 80,25); mileageBtn.setFont(fnt);
		
		add(finalPayLbl1).setBounds(70,250, 80,25); finalPayLbl1.setFont(fnt);
		add(finalPayLbl2).setBounds(200,250, 100,25); finalPayLbl2.setFont(fnt);
		
		add(payBtn).setBounds(100,300, 80, 30); payBtn.setFont(fnt);	
		add(cancelBtn).setBounds(220,300, 80,30); cancelBtn.setFont(fnt);
			
		setSize(400, 450);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CustomPayment();

	}

}
