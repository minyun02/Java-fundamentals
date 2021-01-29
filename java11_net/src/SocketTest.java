import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTest {

	public SocketTest() {
		try {
			InetAddress ia = InetAddress.getByName("127.0.0.1");
			int port = 12000;
			//서버에 접속하는 객체이다.
			Socket s = new Socket(ia, 12000);
			
			//서버에서 보낸 데이터 받기
			InputStream is = s.getInputStream();//byte씩 읽어온다.
			InputStreamReader isr = new InputStreamReader(is);//char단위로 읽어온다.
			BufferedReader br = new BufferedReader(isr);//Line으로 읽어온다.
			
			String data = br.readLine(); //한줄을 보냈으니까 한줄만 읽는다.
			System.out.println("서버에서 받은 문자-->"+ data);
			//br.close(); //보내고 나서 close
			
			//클라이언트가 서버로 데이터 보내기
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("하이...server!!!!!");
			pw.flush();
			pw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SocketTest();
	}

}
