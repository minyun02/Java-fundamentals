import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FileUnicasteReceive {

	public FileUnicasteReceive() {
		startReceive();
	}
	public void startReceive() {
		try {
			DatagramSocket ds = new DatagramSocket(20000);
			byte data[] = new byte[256];
			DatagramPacket dp = new DatagramPacket(data, 0, data.length);
			
			FileOutputStream fos = null;
			File file;
		
			while(true) {
				System.out.println("받기 대기중.....");
				ds.receive(dp);
				
				byte receiveData[] = dp.getData();
				int length = dp.getLength();
				
				String receiveStr = new String(receiveData, 0, length);
				
				if(length >= 6 && receiveStr.substring(0,6).equals("&&FN$$")) {//파일명이 전송된건지 확인
					//OutputStream생성
					file = new File("D://io", receiveStr.substring(6));
					fos= new FileOutputStream(file);
				}else if(length>=6 && receiveStr.substring(0,6).equals("*&CL^&")) { //파일전송 끝났을때
					System.out.println("전송완료");
					fos.close();
					break;
				}else {//파일 내용일때
					fos.write(receiveData, 0, length);
				}
			}
			
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new FileUnicasteReceive();
	}

}
