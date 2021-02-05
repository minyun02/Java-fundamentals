

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmpFlightInfoChange_OLD extends JFrame {
	Font fnt = new Font("굴림체", Font.BOLD, 14);
	Font titleFnt = new Font("굴림체", Font.BOLD, 32);
	
	//빈공간을 위한 전체 패널
	JPanel masterPane = new JPanel(new BorderLayout());
		JLabel gapN = new JLabel(" ");
		JLabel gapW = new JLabel(" ");
		JLabel gapE = new JLabel(" ");
		JLabel gapS = new JLabel(" ");
		//masterPane에 들어갈 패널
		JPanel pane = new JPanel(new BorderLayout());
			JPanel topPane = new JPanel();
				JButton btn = new JButton(new ImageIcon("img/2.png"));
				JLabel lbl1 = new JLabel("BCP");
				JTextField tf1 = new JTextField(10);
//					JComboBox<String> cb1;
//					String[] BCPName = {"0442", "0054", "0001", "0832", "0564"};
				JLabel lbl2 = new JLabel("출발지");
				JTextField tf2 = new JTextField(10);
//					JComboBox<String> cb2;
//					String[] depName = {"인천", "김포", "제주", "런던", "호놀룰루", "김해"};
				JLabel lbl3 = new JLabel("도착지");
				JTextField tf3 = new JTextField(10);
				JButton btn1 = new JButton("검색");
//					JComboBox<String> cb3;
//					String[] desName = {"인천", "김포", "제주", "런던", "호놀룰루", "김해"};
				
				JPanel southPane = new JPanel();
					JLabel lbl4 = new JLabel("기내식");
						JComboBox<String> cb1;
						String[] food = {"볶음밥,파스타 세트", "한식", "중식", "하외이식"};
					JCheckBox check = new JCheckBox("지연 →", false);
						JLabel depTime = new JLabel("출발시간");
						JTextField depTf = new JTextField(10);
						JLabel arrTime = new JLabel("- 도착시간");
						JTextField arrTf = new JTextField(10);
					//JLabel lbl6 = new JLabel("결항");
						JCheckBox cancel = new JCheckBox("결항", false);
					JButton btn2 = new JButton("설정완료");
					
					
		////테이블
		String info[] = {"항공편명", "출발지", "출발시간", "도착지", "도착시간"};
		JPanel gapPane = new JPanel(new BorderLayout());			
			JLabel gapLbl1 = new JLabel(" ");
			JLabel gapLbl2 = new JLabel(" ");
			JPanel tablePane = new JPanel(new BorderLayout());
				JTable table;
				JScrollPane sp;
				DefaultTableModel model;
	
			

	public EmpFlightInfoChange_OLD() {
		add(masterPane);
		masterPane.add("North", gapN);
			gapN.setPreferredSize(new Dimension(100,100));
		masterPane.add("West", gapW);
			gapW.setPreferredSize(new Dimension(200,100));
		masterPane.add("East", gapE);
			gapE.setPreferredSize(new Dimension(200,100));
		masterPane.add("South", gapS);
			gapS.setPreferredSize(new Dimension(100,100));
		masterPane.add("Center", pane);
		
		pane.add("North", topPane);
			topPane.setLayout(null);
			topPane.setPreferredSize(new Dimension(0,50));
			
			topPane.add(btn);
				btn.setBounds(15,8, 30, 35);
			topPane.add(lbl1);
				lbl1.setBounds(60, 8, 50,35);
				lbl1.setFont(fnt);
			topPane.add(tf1);
				tf1.setBounds(90,13, 100, 25);
				tf1.setFont(fnt);
			topPane.add(lbl2);
				lbl2.setBounds(210, 8, 50, 35);
				lbl2.setFont(fnt);
			topPane.add(tf2);
				tf2.setBounds(250, 13, 100, 25);
				tf2.setFont(fnt);
			topPane.add(lbl3);
				lbl3.setBounds(370, 8, 50, 35);
				lbl3.setFont(fnt);
			topPane.add(tf3);
				tf3.setBounds(410, 13, 100, 25);
				tf3.setFont(fnt);
			topPane.add(btn1);
				btn1.setBounds(530, 10, 60, 33);
				btn1.setFont(fnt);
				
		/////테이블
			pane.add("Center", gapPane);
			gapPane.add("North", gapLbl1);
			gapPane.add("Center", tablePane);
			gapPane.add("South", gapLbl2);
			model = new DefaultTableModel(info, 0);
			table = new JTable(model);
			sp = new JScrollPane(table);
			tablePane.add("Center", sp);
			
		///기내식, 지연, 결항
			pane.add("South", southPane);
			southPane.setLayout(null);
			southPane.setPreferredSize(new Dimension(0,50));
			
			southPane.add(lbl4);
				lbl4.setBounds(15,8, 60, 35);	
				lbl4.setFont(fnt);
			cb1 = new JComboBox<String>(food);
			cb1.setBackground(Color.white);
			cb1.setFont(fnt);
			cb1.setBounds(55, 9, 150,35);
			southPane.add(cb1);
			
			southPane.add(check);
				check.setBounds(200, 7, 75, 35);
				check.setFont(fnt);
			southPane.add(depTime);
				depTime.setBounds(270, 8, 100, 35);
				depTime.setFont(fnt);
			southPane.add(depTf);
				depTf.setBounds(315, 12, 50, 25);
				depTf.setFont(fnt);
			southPane.add(arrTime);
				arrTime.setBounds(365, 8, 100, 35);
				arrTime.setFont(fnt);
			southPane.add(arrTf);
				arrTf.setBounds(425, 12, 50, 25);
				arrTf.setFont(fnt);
			southPane.add(cancel);
				cancel.setBounds(475, 12, 70, 25);
				cancel.setFont(fnt);
			southPane.add(btn2);
				btn2.setBounds(525, 14, 75, 25);
				btn2.setFont(fnt);
			
			
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
			

	public static void main(String[] args) {
		new EmpFlightInfoChange_OLD();

	}

}
