import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	//JFrame-center
	JPanel centerPane = new JPanel(new BorderLayout());					//프레임 중아에 들어갈 패널
		JPanel connPane = new JPanel(new BorderLayout());					//접속 버튼과 텍스트필드 들어갈 패널
			JTextField connTf = new JTextField();											//접속할 ip주소를 넣을 텍스트필드
			JButton connBtn = new JButton("접속");										//접속 버튼
		JTextArea msgTa = new JTextArea();												//메시지가 찍힐 창
		JScrollPane msgSp = new JScrollPane(msgTa);								//메시지가 길어지면 스크롤바 필요
		JPanel sendPane = new JPanel(new BorderLayout());					//남쪽에 들어갈 메시지 입력 텍스트필드랑 버튼
			JTextField sendTf = new JTextField();											//메시지입력 텍스트필드
			JButton sendBtn = new JButton("보내기");									//보내기 버튼
	//JFrame-East
	JPanel eastPane = new JPanel(new BorderLayout());						//접속자리스트가 들어갈 동쪽패널
		JLabel listTitle = new JLabel("             접속자리스트            ");			
		DefaultListModel<String> nameModel = new DefaultListModel<String>();	//접속자를 담을 리스트 기본 모델 String이 담기기때문에 제네릭은 String
		JList<String> nameList = new JList<String>(nameModel);			//접속자 리스트			
		JScrollPane nameListSp = new JScrollPane(nameList);				//JList용 스크롤바
		JLabel connCountLbl = new JLabel("현재원 : 0명");	
		
	////////////////////////////////////////////
	Socket s;																									//Socket 변수 선언
	PrintWriter pw;																						//문자 출력을 위한 PrintWriter 변수 선언
	BufferedReader br;																						//문자를 줄 단위로 읽어오기 위한 BufferedReader.
	public ChatClient() {
		//JFrame-center		
		add(centerPane);																						//레이아웃 셋팅
		centerPane.add("North", connPane);
			connPane.add(connTf);
			connPane.add("East", connBtn);
		centerPane.add(msgSp);
			msgTa.setBackground(Color.LIGHT_GRAY);
		centerPane.add("South", sendPane);
			sendPane.add(sendTf);
			sendPane.add("East", sendBtn);
			
		///Border///////////////////////////
		LineBorder lineBorder = new LineBorder(Color.green);
		TitledBorder tBorder = new TitledBorder(lineBorder, "Message",
				TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
		//					 좌우						위아래.
		centerPane.setBorder(tBorder);
		////////////////////////////////////	
		//JFrame-East
		add("East", eastPane);
			eastPane.add("North", listTitle);
			nameModel.addElement("");
			eastPane.add(nameListSp);
			eastPane.add("South", connCountLbl);
			
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		connTf.addActionListener(this);																						//이벤트 등록.				
		connBtn.addActionListener(this);
		sendTf.addActionListener(this);
		sendBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object eObj = ae.getSource();																						//이벤트가 발생한 소스를 object객체 넣는다.
		if(eObj == connTf || eObj == connBtn) {																		//object객체에 담긴 이벤트가 conTf나 connBtn과 같다면
			//서버연결
			serverConnection();																									//서버 연결 메소드 호출/
		}else if(eObj == sendTf || eObj == sendBtn) {
			//문자보내기
			if(sendTf.getText().equals("")){
				JOptionPane.showMessageDialog(this, "메세지를 입력 후 보내기를 선택합니다.");
			}else {
				pw.println(sendTf.getText());
				pw.flush();
				sendTf.setText("");
			}
		}
	}
	public void serverConnection() {
		if(connTf.getText().equals("")) {																						//텍스트 필드이 빈칸이면 
			JOptionPane.showMessageDialog(this, "IP를 입력 후 접속하세요~");							//옵션패널로 메시지 출력
		}else {
			try {
				InetAddress ia = InetAddress.getByName(connTf.getText());								//conTf에 입력한 주소를 가지고 inetAddress 주소객체에 담는
				s = new Socket(ia, 15000);																						//아이피 주소와 열여있는 포트로 접속한다.
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));			//통신을 위한 문자 줄 단위 읽기 준비
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));				//문자 출력을 위한 printwriter
				
				//이미 연결되면 다시 접속 못하도록 접속 비활성화
				connTf.setEnabled(false);																							
				connBtn.setEnabled(false);
				
				Thread t = new Thread(this);//현재 클래스를 스레드 객체로 만든다.
				t.start();			//스레드 시작
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized void run() {
		while(true) {
			try {
				String inData = br.readLine();																		//읽어온 줄을 inData에 담는다.
				if(inData != null) {																							//inData가 비어있지 않으면.
					String header = inData.substring(0, 6);													//inData의 5번째자리 문자까지를 header에 담는다.
					if(header.equals("$$NG##")) {//접속자 정보 알림 받기								//0~5번째 자리 특수문자로 넘어온 정보를 알 수 있다.
						msgTa.append(inData.substring(6)+"\n");											//특수문자를 뺀 나머지를 TextArea에 출력.
					}else if(header.equals("!&CN%$")) {//접속자 수 받기
						connCountLbl.setText("현재원 : "+inData.substring(6)+"명");
					}else if(header.equals("^^CL*%")) {//접속자 목록 받기
						// 192.168.0.6/192.168.5.45/192.132.123 .......
						setConnectListReset(inData.substring(6));										//접속자 목록을 하나씩 찍어내기위한 메소드
					}else if(header.equals("%$MG&^")) {
						msgTa.append(inData.substring(6)+"\n");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void setConnectListReset(String nameList) {
		StringTokenizer st = new StringTokenizer(nameList, "/"); // "/"를 기준으로 나누기				//토크나이저를 이용해 "/"사이에 문자들을 구한다.
		nameModel.removeAllElements();//원래 목록 지우기															//원래 목록 지우기
		while(st.hasMoreElements()) {																							//토크나이저로 나눈 문자열이 더 있으면
			nameModel.addElement(st.nextToken());																	//nameModel(JList)에 추가해준다.
		}
		
	}
	public static void main(String[] args) {
		new ChatClient();

	}

}
