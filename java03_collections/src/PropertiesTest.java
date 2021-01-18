import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// key, value가 String인 collection
		Properties prop = new Properties();
		
		prop.setProperty("네이트", "http://www.nate.com");
		prop.setProperty("다음", "http://www.daum.net");
		prop.setProperty("네이버", "http://www.naver.com");
		prop.setProperty("비트캠프", "http://www.bitcamp.co.kr");
		
		String url = prop.getProperty("비트캠프");
		System.out.println("비트캠프 : "+url);
		
		Enumeration key = prop.propertyNames(); // properties에서 key list를 구함
		while(key.hasMoreElements()) {
			String kk = (String)key.nextElement();
			System.out.println("key= "+kk+", value= "+prop.getProperty(kk));
		}
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
