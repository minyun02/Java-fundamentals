import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicasteSend {
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia; 
	public UnicasteSend() {
		//UDP방식 데이터 보내기
		try {
			ds = new DatagramSocket(); //보내기에는 포트번호를 안적어도 된다. 받는 곳 객체가 아이피 주소랑 포트번호를 받을 수 있기 때문이다.
			
			String data = "Java network 유니캐스트 통신 연습중.";
			ia = InetAddress.getByName("192.168.0.5");//받는쪽 아이피 주소
			//보낼 문자를 packet으로 만들어야 한다.
			//전송할 데이터 그램 패킷객체 생성					 	//그냥 data.length를 구하면 한글이 깨질 수 있으니까 data배열의 길이를 구한다.
			//		한번에 보내는 권장 바이트 -> 256바이트
			dp = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, ia, 10000);
			
			//데이터 보내기 //send는 데이터 그램에 있는 메소드
			ds.send(dp);
			ds.close();
		}catch(Exception e) {
			
		}
		System.out.println("보내기 완료...");
	}

	public static void main(String[] args) {
		new UnicasteSend();

	}

}
