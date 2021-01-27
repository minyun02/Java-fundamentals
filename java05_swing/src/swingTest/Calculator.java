package swingTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JPanel implements ActionListener{
	Font fnt = new Font("Arial", Font.BOLD, 20);
	
	//JFrame - North
	JTextField resultTf = new JTextField("0.0");
	//JFrame - Center - 3개 버튼, 4*4 버튼을 담을 큰 틀
	JPanel centerPane = new JPanel(new BorderLayout()); //JPanel은 flowlayout이 default
		JPanel northPane = new JPanel(new GridLayout(1, 3)); // 버튼 3개 들어갈 틀
		JPanel btnPane = new JPanel(new GridLayout(4,4));	
		
	//버튼에 들어갈 내용들을 스트링 배열로 만든다.	
	 String btnLbl[] = {"BackSpace", "Clear", "End", 
			             "7", "8", "9", "+",
			             "4", "5", "6", "-", 
			             "1", "2", "3", "*",
			             "0", ".", "=", "/"};
	//연산자 보관할 변수
	String operator = "";
	//첫번째 피연산자 -> double로 선언하는 이유는 계산기 기능에 소수점이 있기 때문
	double result = 0.0;
	
	public Calculator() {
		//레이아웃을 FlowLayout에서 BorderLayout으로 변경
		setLayout(new BorderLayout());
		//super("계산기");
		//JFrame - North
		add("North", resultTf);
		resultTf.setFont(fnt);
		//내용을 오른쪽 정렬
		//								SwingConstatnts.RIGHT ->상위클래스로 써도 같은 기능 구현
		resultTf.setHorizontalAlignment(JTextField.RIGHT);
		//JFrame - Center
		centerPane.add("North", northPane);	//northPane을 centerPane JFrame north에 넣어준다.
		centerPane.add(BorderLayout.CENTER, btnPane);	//btnpane을 centerPane center에 넣어준다.
		add("Center", centerPane);

		//버튼 생성하기
		for(int i=0; i<btnLbl.length; i++) {
			JButton btn = new JButton(btnLbl[i]);
			//폰트 설정하기
			btn.setFont(fnt);
			if(i<=2) {
				northPane.add(btn);
			}else {
				btnPane.add(btn);
				//4*4부분 배경색만 지정해주면 되니까 여기서 배경 지정
				btn.setBackground(Color.LIGHT_GRAY);
			}
			//이벤트 등록은 최소한 버튼이 만들어지고 나서 해야하니까 이 위치가 적당
			btn.addActionListener(this);
		}
		
		//setSize(400, 250);
		//setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//이벤트 등록용 인터페이스 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		//System.out.println(eventBtn);		//눌린 버튼을 콘솔창에 추력하는 내용
		switch(eventBtn) {
		case "End": System.exit(0); break;
		case "0": case "1": case "2": case "3": case "4": case "5":
		case "6": case "7": case "8": case "9":
			 setNumber(eventBtn);
			 break;
		case ".":
			setPoint();
			break;
		case "BackSpace":
			setBackspace();
			break;
		case "+": case "-": case "*": case "/":
			setOperator(eventBtn);
			break;
		case "=":
			setResult();
			break;
		case "Clear":
			setClear();
		}

	}
	//데이터 초기화
	public void setClear() {
		result = 0.0;
		operator = "";
		resultTf.setText("0.0");
	}
	//연산하기
	public void setResult() {
		double secondNum = Double.parseDouble(resultTf.getText());
		switch(operator) {
			case "+": result = result + secondNum; break;
			case "-": result -= secondNum; break;
			case "*": result *= secondNum; break;
			case "/": result /= secondNum; break;
		}
		resultTf.setText(String.valueOf(result)); //result+"" ->result는 double이니까 스트링으로 바꿔준다
		operator = "";
	}
	//연산자 버튼 선택시 (+, -, *, /)
	public void setOperator(String operator) {
		//연산자 보관
		this.operator = operator;
		result = Double.parseDouble(resultTf.getText()); //첫번째 피연산자 보관
		resultTf.setText("");
	}
	//BackSpace 처리
	public void setBackspace() {
		String lblStr = resultTf.getText(); //1234567
		String cutStr = lblStr.substring(0,lblStr.length()-1);
		resultTf.setText(cutStr);
	}
	//소수점 처리
	public void setPoint() {
		String lblStr = resultTf.getText();
		//.위치 구하기
		int idx = lblStr.indexOf(".");
		if(idx == -1) {
			resultTf.setText(lblStr+".");
		}
	}
	//숫자버튼을 선택하면 숫자 가져오기
	public void setNumber(String num) {
		//JTextField 원래값 얻어오기
		String lblStr = resultTf.getText(); // 시작할때는 0.0
		if(lblStr.equals("0.0")) { 
			resultTf.setText(num); //클릭한 숫자버튼을 세팅
		}else {
			resultTf.setText(lblStr+num);
		}
	}
//	public static void main(String[] args) {
//		new Calculator();
//
//	}

}