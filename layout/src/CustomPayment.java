import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CustomPayment extends JFrame implements ActionListener, MouseListener, WindowListener{
	Font fnt = new Font("굴림체", Font.BOLD, 14);
	
	JLabel amountLbl1 = new JLabel("총 운임");
	JLabel amountLbl2 = new JLabel("570000");
	JLabel wonLbl = new JLabel("원");
	
	JLabel paymentLbl = new JLabel("결제수단");
	String paymentStr[] = {"카드결제", "계좌이체"};
	JComboBox<String> paymentBox;
	
	JLabel cardNumLbl = new JLabel("카드번호");
	JTextField cardNumTf= new JTextField(20);
	JLabel bankLbl = new JLabel("우리은행");
	JLabel numLbl = new JLabel("0001-010-05-0002");
	
	JLabel mileageLbl1 = new JLabel("적립 마일리지");
	JLabel mileageLbl2 = new JLabel("570");
	JLabel mileageLbl3 = new JLabel("등급명");
	JLabel mileageLbl4 = new JLabel("보유 마일리지");
	JLabel mileageLbl5 = new JLabel("3800");
	JButton mileageBtn = new JButton("사용");
	
	JLabel finalPayLbl1 = new JLabel("최종 결제금액");
	JLabel finalPayLbl2 = new JLabel("551200");
	
	JLabel wonLbl2 = new JLabel("원");
	
	JButton payBtn = new JButton("결제");
	JButton cancelBtn = new JButton("취소");
	
	public CustomPayment() {
		setLayout(null);
		this.setBackground(Color.white);
		
		
		add(amountLbl1).setBounds(60,100, 80, 25); amountLbl1.setFont(fnt); 
		add(amountLbl2).setBounds(200, 100, 100, 25);amountLbl2.setFont(fnt); 
		add(wonLbl).setBounds(270,100, 20,25);	wonLbl.setFont(fnt);
			
		add(paymentLbl).setBounds(60, 130, 80, 25); paymentLbl.setFont(fnt);
		paymentBox = new JComboBox<String>(paymentStr);
		add(paymentBox).setBounds(200, 130, 100, 25); paymentBox.setFont(fnt);
			paymentBox.setBackground(Color.white);
			
		add(cardNumLbl).setBounds(60, 160, 80, 25); cardNumLbl.setFont(fnt);
		add(cardNumTf).setBounds(200,160, 160, 25);	cardNumTf.setFont(fnt); cardNumTf.setBackground(Color.white);
		add(bankLbl).setBounds(60, 160, 80, 25); bankLbl.setFont(fnt); bankLbl.setVisible(false);
		add(numLbl).setBounds(200,160, 160, 25);numLbl.setFont(fnt); numLbl.setVisible(false);
			
		add(mileageLbl1).setBounds(60,190, 100,25); mileageLbl1.setFont(fnt);
		add(mileageLbl2).setBounds(200,190, 60,25); mileageLbl2.setFont(fnt);
		add(mileageLbl3).setBounds(270,190, 60, 25); mileageLbl3.setFont(fnt);
		
		add(mileageLbl4).setBounds(60,220, 100,25); mileageLbl4.setFont(fnt);
		add(mileageLbl5).setBounds(200,220, 80,25); mileageLbl5.setFont(fnt);
		add(mileageBtn).setBounds(270,220, 65,25); mileageBtn.setFont(fnt);
			mileageBtn.setBackground(new Color(0,130,255));
			mileageBtn.setForeground(Color.white);
		
		add(finalPayLbl1).setBounds(60,250, 100,25); finalPayLbl1.setFont(fnt);
		add(finalPayLbl2).setBounds(200,250, 100,25); finalPayLbl2.setFont(fnt);
		add(wonLbl2).setBounds(270,250, 20,25); wonLbl2.setFont(fnt);
		add(payBtn).setBounds(75,320, 100, 30); payBtn.setFont(fnt);
			payBtn.setBackground(new Color(0,130,255));
			payBtn.setForeground(Color.white);
		add(cancelBtn).setBounds(220,320, 100,30); cancelBtn.setFont(fnt);
			cancelBtn.setBackground(new Color(0,130,255));
			cancelBtn.setForeground(Color.white);
			
		setSize(400, 450);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트
		paymentBox.addActionListener(this);
		payBtn.addMouseListener(this);
		cancelBtn.addMouseListener(this);
		addWindowListener(this);
	}

	public static void main(String[] args) {
		new CustomPayment();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj instanceof JComboBox) {
			String comboItem = (String)paymentBox.getSelectedItem();
			System.out.println(comboItem);
			
			if(comboItem.equals("계좌이체")) {
				cardNumLbl.setVisible(false);
				bankLbl.setVisible(true);
				cardNumTf.setVisible(false);
				numLbl.setVisible(true);
			}else if(comboItem.equals("카드결제")) {
				bankLbl.setVisible(false);
				cardNumLbl.setVisible(true);
				numLbl.setVisible(false);
				cardNumTf.setVisible(true);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		Object obj = me.getSource();
		if(obj instanceof JButton) {
			String btnName = ((JButton) obj).getText();
			if(btnName.equals("결제")) {
				JOptionPane.showMessageDialog(this, "결제가 완료되었습니다");
				this.setVisible(false);
				paymentState = 1; // 1이면 결제를 했다는 뜻이니까 cbc4로 화면 전환 가자!!
				System.out.println(paymentState);
				CustomFrame.bookingChange3.setVisible(false);
				CustomFrame.bookingChange4.setVisible(true);
				CustomFrame.centerPane.add(CustomFrame.bookingChange4);
			}
		}
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		paymentWindowState = 1;
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		paymentWindowState = 0;
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
