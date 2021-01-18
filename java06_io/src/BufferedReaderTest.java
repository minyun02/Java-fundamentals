import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
		// 한 줄 단위로 읽어와 입력 할 수 있는 테스트 (enter값 이전까지의 문자열 >>> readLine() 메소드)
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr); // 생성자 메소드에 Reader 클래스가 필요한데, InputStreamReader가 Reader를 상속받고, InputStreamReader()생성자에는 InputStream, InputStream은 in
		
		System.out.print("문자열 입력 = ");
		try {
			// BufferedReader가 입력받은 데이터를 String으로 return
			// 반복문으로 읽어올때, retrun값이 null일 경우, 읽어온 데이터가 없다. 왜? String이라
			String inData = br.readLine();
			System.out.println("inData = "+inData);
			
			// Scanner 입력받은 데이터를 nextInt: 인트로 리턴, nextLine: 한 줄로 리턴 ...
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new BufferedReaderTest();

	}

}
