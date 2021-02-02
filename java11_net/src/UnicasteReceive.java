import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteReceive() {
		// UPD방식 데이터 받기
		try {
			//받기를 할 객체 생성
			ds = new DatagramSocket(10000);//65000 소켓 중 아무거나 쓰면 된다.
			
			//받은 데이터를 저장할 바이트 배열
			byte data[] = new byte[256];
			dp = new DatagramPacket(data, data.length);
			
			System.out.println("전송받기 대기중..");
			ds.receive(dp); //대기
			
			//받은 데이터 처리
			byte receiveData[] = dp.getData(); //전송받은 데이터 배열
			int len = dp.getLength(); //전송받은 바이트 수 구하기
			//receiveData를 스트링으로 바꿔서 출력 -> 배열 속 빈공간이 길게 나온다. -> 보낼때 몇 바이트를 보낸지 알려주면 해결가능
			System.out.println("받은 문자 -->"+ new String(receiveData, 0, len)+"-------");
		}catch(Exception e) {
			
			
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

	public static void main(String[] args) {
		new UnicasteReceive();

	}

}
