import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread{
	//접속대기 객체
	ServerSocket ss; //예외가 발생하기 때문에 필드에서는 변수만 선언.
	//접속자(Socket)를 보관할 객체
	List<ChatService> connAll = new ArrayList<ChatService>(); 
	
	public ChatServer() {
		this.start();
	}
	//접속대기 스레드
	public void run() {
		try {
			ss = new ServerSocket(15000);
			
			while(true) {
				System.out.println("서버 접속대기중....");
				Socket s = ss.accept(); //누가 접속하면 socket객체가 만들어진다.
	
				//클라이언트가 접속을 하면.
				ChatService cs = new ChatService(s);
				System.out.println(cs.userid+"가 접속하였습니다..");
				
				//이미 접속자인지 확인
				connectionCheck(cs);
				
				//모든 접속자를 리스트에 추가하기
				connAll.add(cs);
				
				//현재 접속중인 접속자에게 접속상태를 알린다.
				setMessageAll("$$NG##"+ cs.userid +"님이 접속하였습니다.");
				//접속자수 보내기
				setMessageAll("!&CN%$"+connAll.size());
				//접속자 명 보내기
				connectionList();
				
				//클라이언트가 보낸 문자를 받아낼 inputStream스레드 시작
				cs.start();
			}
		}catch(Exception e) {
			
		}
	}
	public void connectionCheck(ChatService cs) {
		for(int i=0; i<connAll.size();i++) {
			ChatService service = connAll.get(i);
			if(service.userid.equals(cs.userid)) {//이미 접속자일 경우
				connAll.remove(i);
				break;
			}
		}
	}
	public void connectionList() {
		String idList = "^^CL*%";
		for(int i=0; i<connAll.size(); i++) {
			ChatService cs = connAll.get(i);
			idList += "/"+cs.userid;
		}
		setMessageAll(idList);
	}
	//전체 회원에게 메세지 보내기
	public void setMessageAll(String msg) {
		for(int i=0; i<connAll.size(); i++) {
			try {
				ChatService cs = connAll.get(i);
				//쓰기
				cs.pw.println(msg);
				cs.pw.flush();
			}catch(Exception e) {
				connAll.remove(i);	//회원이 접속 종료되면 지우기
				i--;
				e.printStackTrace();
			}
		}
	}
	//클라이언트가 접속을 하면 접속자 정보를 가질 객체를 내부클래스로 만든다.
	class ChatService extends Thread{
		//socket, inputStream, outputStream, 접속자 이름(ip)
		Socket s;
		BufferedReader br;
		PrintWriter pw;
		String userid;
		InetAddress ia;
		
		ChatService(){}
		ChatService(Socket s){
			try {
				this.s = s;
				br = new BufferedReader(new InputStreamReader(s.getInputStream())); //클라이언트가 보낸 문자를 입력받는다.
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream())); 	//클라이언트에게 문자를 출력한다.
				//접속자 ip구하기
				ia = s.getInetAddress();
				System.out.println("IA->"+ia);
				userid = ia.getHostAddress();
				System.out.println("USERID->"+userid);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//입력대기 Thread
		public void run() {
			while(true) {
				try {
					String inData = br.readLine();
					if(inData != null) {
						//접속한 모든 접속자에게 문자 보내기
						setMessageAll("%$MG&^"+ userid+"님 :" + inData);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new ChatServer();

	}

}
