import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class AirlineSales extends JPanel implements ActionListener{
	
	// 제일 위 상단바

	Font fnt = new Font("굴림체",Font.BOLD,32);//매출관리
	Font fnt2 = new Font("굴림체",Font.BOLD,18); // 여남 버튼 	
	Font fnt3 = new Font("굴림체",Font.BOLD,25); //기본폰트 

	
	
	JPanel NorthPane = new JPanel(new BorderLayout()); 		//메뉴들 
	
	
		
	
	//중간 매츌관리 부분 		
	JPanel CenterPane = new JPanel(new BorderLayout());
		JPanel tablePane = new JPanel(new BorderLayout());
				JLabel salesLbl= new JLabel("매출 관리");
			JPanel buttonPane = new JPanel(new GridLayout(1,0));
				String listLbl [] = {"출발일", "도착일", "항공편", "출발지","도착지","비용","매출","영업이익","증감률"};
		
			JTable table;
			JScrollPane sp;
			DefaultTableModel sales;
		
		JPanel searchPane = new JPanel(new GridLayout(0,1));

		
		
			JPanel datePane = new JPanel();
				JLabel startDateLbl = new JLabel("시 작 일");
					JTextField tf = new JTextField(10);
				JLabel endDateLbl = new JLabel("종 료 일 ");
					JTextField tf2 = new JTextField(10);
			JPanel startPane = new JPanel();
				JLabel startLbl = new JLabel("출 발 지");
					JComboBox<String> cb1;
					String[] startName = {"ICN","GMP", "CJU","SIN","YYZ"};
			JPanel endPane = new JPanel();
				JLabel endLbl = new JLabel("목 적 지");
					JComboBox<String> cb2;
					String[] endName = {"VVO","ICN","GMP", "CJU","SIN","YYZ"};
			JPanel agePane = new JPanel();
				JLabel ageLbl = new JLabel("고객 연령대");
					JComboBox<Integer> cb3;
					Integer [] age = {10,20,30,40,50,60};
					JComboBox<Integer> cb4;
					Integer [] age2 = {10,20,30,40,50,60};
			JPanel genderPane = new JPanel();
				JLabel genderLbl = new JLabel("성별");
						JButton female = new JButton(" 여 ");
						JButton male = new JButton(" 남 ");
			JPanel emptyPane = new JPanel();

					

		// 매출내역 조회버튼	
		JPanel SouthPane = new JPanel(new BorderLayout()); 
			JPanel btnPane = new JPanel();		
				JButton enterBtn = new JButton("조회");
				JLabel empty = new JLabel("    ");
					JButton resetBtn = new JButton("초기화");
				JLabel empty2 = new JLabel("    ");
					JButton allBtn = new JButton("전체보기");
			

	public AirlineSales() {
		
//		 왜 세로로 들어가냐?
//		NorthPane.setLayout(new BorderLayout());
//		
//		add("North",NorthPane);
//			NorthPane.add("North",CenteremptyPane);
//		

		
		add("Center",CenterPane);

			CenterPane.add("North", tablePane);
			
				tablePane.add("North",salesLbl);
					salesLbl.setHorizontalAlignment(JLabel.CENTER);
				sales = new DefaultTableModel(listLbl,0);
				table = new JTable(sales);
				sp = new JScrollPane(table);
				sp.setPreferredSize(new Dimension(900,300));
				
				salesLbl.setFont(fnt);
				salesLbl.setOpaque(true);
				salesLbl.setBackground(Color.white);
				tablePane.add("Center",sp);
				
				

			CenterPane.add("Center",searchPane);
				searchPane.setBackground(Color.white);
				searchPane.add(datePane);
					datePane.add(startDateLbl);
						startDateLbl.setFont(fnt3);
					datePane.add(tf);
						tf.setPreferredSize(new Dimension(70,30)); 
					datePane.add(endDateLbl);
						endDateLbl.setFont(fnt3);
					datePane.add(tf2);
						tf2.setPreferredSize(new Dimension(70,30)); 
					datePane.setBackground(Color.white);	
					datePane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
					
				searchPane.add(startPane);
					startPane.add(startLbl);
						startLbl.setFont(fnt3);
						cb1 = new JComboBox<String>(startName);
//						cb1.setBackground(new Color(255,250,244));
						cb1.setBackground(Color.white);
						cb1.setPreferredSize(new Dimension(100,30)); 
						startPane.add(cb1);
					startPane.setBackground(Color.white);	
					startPane.setLayout(new FlowLayout(FlowLayout.LEFT));
					
				searchPane.add(endPane);
					endPane.add(endLbl);
						endLbl.setFont(fnt3);
						cb2 = new JComboBox<String>(endName);
						cb2.setBackground(Color.white);
						cb2.setPreferredSize(new Dimension(100,30)); 
						endPane.add(cb2);
						
					endPane.setBackground(Color.white);		
					endPane.setLayout(new FlowLayout(FlowLayout.LEFT));
				searchPane.add(agePane);
					agePane.add(ageLbl);
						ageLbl.setFont(fnt3);
						cb3 = new JComboBox<Integer>(age);
						cb3.setBackground(Color.white);
						cb3.setPreferredSize(new Dimension(100,30)); 
						agePane.add(cb3);
						agePane.add(new JLabel(" ~ "));
						cb4 = new JComboBox<Integer>(age2);
						cb4.setBackground(Color.white);
						cb4.setPreferredSize(new Dimension(100,30)); 
						agePane.add(cb4);
					agePane.setBackground(Color.white);
					agePane.setLayout(new FlowLayout(FlowLayout.LEFT));
					
				searchPane.add(genderPane);
					genderPane.add(genderLbl);
						genderLbl.setFont(fnt3);
						genderPane.add(female);
						genderPane.add(new JLabel(""));
						genderPane.add(male);
						
						female.setFont(fnt2);
						female.setBackground(new Color(255,128,128));
						female.setForeground(Color.white);
//						female.setBounds(); // 버/튼 크기랑 위치조절하기 setBounds(가로위치, 세로위치, 가로길이, 세로길이);
						
						male.setFont(fnt2);
						male.setBackground(new Color(255,128,128));
						male.setForeground(Color.white);
//						male.setBounds(); //버튼 크기랑 위치조절하기 setBounds(가로위치, 세로위치, 가로길이, 세로길이);
						
						genderPane.setLayout(new FlowLayout(FlowLayout.LEFT));
						
					genderPane.setBackground(Color.white);
				searchPane.add(emptyPane);
					emptyPane.setBackground(Color.white);
						


			CenterPane.add("South",SouthPane);
			SouthPane.add(btnPane);
				
				btnPane.add(enterBtn);
					enterBtn.setFont(fnt2);
					enterBtn.setBackground(new Color(255,128,128));
					enterBtn.setForeground(Color.white);
					enterBtn.setBorder(new LineBorder(Color.white, 1, true));
				btnPane.add(empty);
				btnPane.add(resetBtn);
					resetBtn.setFont(fnt2);
					resetBtn.setBackground(new Color(255,128,128));
					resetBtn.setForeground(Color.white);
					resetBtn.setBorder(new LineBorder(Color.white, 1, true));
				btnPane.add(empty2);
				btnPane.add(allBtn);
					allBtn.setFont(fnt2);
					allBtn.setBackground(new Color(255,128,128));
					allBtn.setForeground(Color.white);
					allBtn.setBorder(new LineBorder(Color.white, 1, true));
				btnPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			
				
				btnPane.setBackground(Color.white);	
				enterBtn.setPreferredSize(new Dimension(100,40));	
				resetBtn.setPreferredSize(new Dimension(100,40));	
				allBtn.setPreferredSize(new Dimension(120,40));	
				
		setBackground(Color.white);	
		setSize(1000,800);
		setVisible(true);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
