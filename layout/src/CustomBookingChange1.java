import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomBookingChange1 extends JFrame implements ActionListener, MouseListener {
	Font fnt = new Font("굴림체", Font.BOLD, 14);
	Font fnt1 = new Font("굴림체", Font.BOLD, 20);
	
	JLabel numLbl1 = new JLabel("예약번호");
	JLabel numLbl2 = new JLabel("AB1C57");
	JLabel dateLbl1 = new JLabel("출발일시");
	JLabel dateLbl2 = new JLabel("2021-01-31");
	JLabel dateLbl3 = new JLabel(" ");
	
	JLabel depLbl = new JLabel("로스엔젤레스");
	JLabel depALbl = new JLabel("GMP");
	JLabel depTimeLbl = new JLabel("15:00");
	
	ImageIcon ii1 = new ImageIcon("img/arrow.png");
	Image img = ii1.getImage();
	Image changeImg = img.getScaledInstance(80, 40, img.SCALE_SMOOTH);
	ImageIcon changeIcon = new ImageIcon(changeImg);
	JLabel arrowLbl = new JLabel(changeIcon);
	
	JLabel flightNumLbl = new JLabel("KK512");
	
	JLabel desLbl = new JLabel("산타마리아고메즈");
	JLabel desALbl = new JLabel("CJU");
	JLabel arrTimeLbl = new JLabel("16:00");

	JButton changeBtn = new JButton("예약변경");
	JButton cancelBtn = new JButton("예약취소");
	
	///table
	Object booking[] = {"예약번호", "출발일시", "항공편명", "출발지", "출발공항", "출발시간", "도착지", "도착공항", "도착시간"};
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	//이벤트용 변수
	int row = 0;
	
	
	public CustomBookingChange1() {
		setLayout(null);
		this.getContentPane().setBackground(Color.white);
		
		add(numLbl1).setBounds(420,90, 60, 25);
			numLbl1.setFont(fnt);
		add(numLbl2).setBounds(510, 90, 100, 25);
			numLbl2.setFont(fnt);
		add(dateLbl1).setBounds(420, 110, 60, 25);
			dateLbl1.setFont(fnt);
		add(dateLbl2).setBounds(510, 110, 100, 25);
			dateLbl2.setFont(fnt);
//		add(dateLbl3).setBounds(520, 120, 100, 25);
//			dateLbl3.setFont(fnt);
			
		add(depLbl).setBounds(345, 150, 100, 25);
			depLbl.setFont(fnt);
		add(depALbl).setBounds(345,170, 60, 25);
			depALbl.setFont(fnt1);
		add(depTimeLbl).setBounds(345, 190, 60, 25);	
			depTimeLbl.setFont(fnt);
			
		add(arrowLbl).setBounds(465, 165, 80, 40);
		add(flightNumLbl).setBounds(485, 195, 60, 25);
			flightNumLbl.setFont(fnt);
			
		add(desLbl).setBounds(610, 150, 120, 25);
			desLbl.setFont(fnt);
		add(desALbl).setBounds(610, 170, 60, 25);
			desALbl.setFont(fnt1);
		add(arrTimeLbl).setBounds(610, 190, 60, 25);
			arrTimeLbl.setFont(fnt);
			
		add(changeBtn).setBounds(370, 240, 100, 30);
			changeBtn.setFont(fnt);
			changeBtn.setBackground(new Color(0,130,255));
			changeBtn.setForeground(Color.white);
		add(cancelBtn).setBounds(530, 240, 100, 30);
			cancelBtn.setFont(fnt);
			cancelBtn.setBackground(new Color(0,130,255));
			cancelBtn.setForeground(Color.white);
			
		////table
		String test[][] = {
					{"서울","호놀룰루","20210202","20210228","BCP0836","190000","190","3800","111"},
					{"서울","호놀룰루","20210202","20210228","BCP0836","190000","190","3800","111"}
		};
		model = new DefaultTableModel(test,booking);
		table = new JTable(model);
		sp = new JScrollPane(table);
		add(sp).setBounds(200, 300, 600, 300);
			sp.getViewport().setBackground(Color.white);
			
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		table.addMouseListener(this);
		
		changeBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	public static void main(String[] args) {
		new CustomBookingChange1();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JButton) {
			String btnStr = ((JButton) obj).getText();
			if(btnStr.equals("예약변경")) {
				System.out.println("1111");
				if(row==0) {
					JOptionPane.showMessageDialog(this, "변경할 예약정보를 선택해주세요.");
				}else {
					JOptionPane.showMessageDialog(this, "136줄로 가서 이벤트 끝내라");
					//this.setVisible(false);
					//CustomFrame.bookingChange2.setVisible(true);
					//CustomFrame.centerPane.add(CustomFrame.bookingChange2);
				}
			}else if(btnStr.equals("예약취소")) {
				JOptionPane.showMessageDialog(this, "142줄로 가서 이벤트 끝내라");
				//this.setVisible(false);
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getButton()==1) {
			if(table.getSelectedRowCount() != 1) {
				System.out.println("@22");
				JOptionPane.showMessageDialog(this, "1개의 예약정보만 선택해주세요.");
			}else {
				row = table.getSelectedRow()+1;
				System.out.println(row);
			}
		}
		
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