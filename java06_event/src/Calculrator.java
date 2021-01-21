//21-01-12
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculrator extends JPanel implements ActionListener{
	
	// 폰트
	Font fnt = new Font ("Arial" , Font.BOLD,20);
	//JFRAME - North
	JTextField resultTf = new JTextField("0.0");
	//JFrame - Center
	JPanel centerPane = new JPanel(new BorderLayout()); // FlowLayout = > BorderLayout
	//3개의 버튼
	JPanel northPane = new JPanel (new GridLayout(1,3));
	//16개의 버튼
	JPanel btnPane = new JPanel (new GridLayout(4,4));
	// 버튼을 배열로 
		String btnLbl[] = {"BackSpace","Clear","End", 
							"7","8","9","+",
							"4","5","6","-" , 
							"1","2","3","*",
							"0",".","=","/"	};
	//연산자 보관할 변수
	String operator = "";
	//피연산자 보관
	double result = 0.0;
	
		
		
		
	public Calculrator () { // 여기는 프레임
		setLayout(new BorderLayout());
		
		//JFRAME - North 숫자 입력 칸임
		add("North", resultTf);
		resultTf.setFont(fnt);
//										SwingConstants.RIGHT
		resultTf.setHorizontalAlignment(JTextField.RIGHT);//내용을 오른쪽 정렬하는 메소드
		
		//JFrame - Center
		centerPane.add("North", northPane);
		centerPane.add(BorderLayout.CENTER,btnPane);
		add("Center",centerPane);
	
		//버튼 생성
		for (int i = 0 ; i<btnLbl.length;i++) {
			JButton btn = new JButton(btnLbl[i]);
			btn.setFont(fnt); // 글꼴,유형,크기 세팅해놓은것
//			2보다 작거나 같으면 northPane
			if(i<=2) {
				northPane.add(btn);
			}else {
				btnPane.add(btn);
				btn.setBackground(Color.LIGHT_GRAY);
			}
			//이벤트 등록
			btn.addActionListener(this);
			
		}
		
		
		
	}
	
	// 인터페이스 오버라이딩
	
	
	
	public void actionPerformed (ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		
		switch(eventBtn){
			case "End" : System.exit(0); break;
			case "0"  : case "1" : case "2" : case "3" : case "4" : case "5" :
			case "6"  : case "7" : case "8" : case "9" :
				setNumber(eventBtn);
				break;
				
			case "." :
				setPoint();
				break;
			case "BackSpace" :
				setBackSpace();
				break;
			case "+" : case "-" : case "*" : case "/" :
				setOperator(eventBtn);
				break;
			case "=" :
				setResult();
				break;
			case "Clear" :
				setClear();
				
		}
	}
//	데이터 초기화
	public void setClear () {
		result = 0.0;
		operator = "";
		resultTf.setText("0.0");
	}
	
// 연산하기
	public void setResult() {
		double secondNum = Double.parseDouble(resultTf.getText());
		switch (operator) {
			case "+" : result = result + secondNum; break;
			case "-" : result -= secondNum; break;
			case "*" : result *= secondNum; break;
			case "/" : result /= secondNum; break;
		}
		resultTf.setText(String.valueOf(result)); // result + "" 
		operator = "";
	}
	
	
	
//	연산자 버튼 선택시 ( +, - , * , / )
	public void setOperator(String operator) {
		// 연산자 보관
		this.operator = operator; // 여기에 더하기 뺴기 등을 보관
		// 첫번쨰 수 보관
		result = Double.parseDouble(resultTf.getText());
		resultTf.setText("");;
	}
	
//	BackSpace
	public void setBackSpace() {
		String lblStr = resultTf.getText(); // 1234567 하면 맨 마지막 기능을 지우는거 
		String cutStr = lblStr.substring(0,lblStr.length()-1);
		resultTf.setText(cutStr);
	}
	
	//숫자버튼을 선택하면 
	public void setNumber (String num) { // num 여기에 눌려진 버튼이있다
		// JTextField 원래 있는 데이터
		String lblStr = resultTf.getText();
		
		if (lblStr.equals("0.0")){
			resultTf.setText(num);
		}else {
			resultTf.setText(lblStr+num);
		}
	}
	//소수점 처리
	public void setPoint ()	{
		String lblStr =resultTf.getText();
		int idx = lblStr.indexOf("."); // 소수점 위치구하기 indexOf 제일 끝에서부터 소수점을 확인하고 만약에 없으면 -1이나옴
		if (idx == -1) {
			resultTf.setText(lblStr+ ".");
		
		}
	}
	

	}


