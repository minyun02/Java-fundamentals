import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		try {
			//
			URL url = new URL("https://www.nate.com/");
			//URL url = new URL("https://cafe.naver.com/goguma777");
			System.out.println("protocol-->"+ url.getProtocol());
			System.out.println("hostname-->"+ url.getHost());
			System.out.println("port-->"+ url.getPort()); 
			System.out.println("filename-->"+ url.getFile());
			System.out.println("path-->"+ url.getPath());
			
			//URLConection 객체를 구해 Header의 xontenType을 구하면 한글코드를 알아낼 수 있다.
			URLConnection con = url.openConnection();
			con.connect();//header정보를 얻기 전에 통신채널을 연결해서 확보한다.
			
			//Header의 contentType가져오기
			String contentType = con.getContentType();
			System.out.println("contentType-->"+ contentType);
			
			String encode = contentType.substring((contentType.indexOf("=")+1));
			System.out.println("substring-->"+ encode);
			//String encode2[] = contentType.split("=");
			//System.out.println("split-->"+ encode2[1]);
			
			
			// URL객체를 통해 리소스 가져오기
			InputStream is = url.openStream(); 		//1byte씩 불러오기 때문에 한글이 깨진다... //데이터 불러온게 없으면 -1
			InputStreamReader isr = new InputStreamReader(is); 	//1 char씩 불러오기		//불러올 데이터가 없으면 -1
			BufferedReader br = new BufferedReader(isr);		//한줄씩 읽어오기
			
			while(true) {
				String inData = br.readLine(); //String이라 불러올 데이터가 없으면 null으로 나온다.
				if(inData==null) break;
				System.out.println(inData);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLTest();

	}

}
