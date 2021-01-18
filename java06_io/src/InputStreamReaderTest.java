import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		//InputStreamReader : 콘솔에서 문자단위 입력하는 클래스
		InputStreamReader isr =new InputStreamReader(System.in);
		
		System.out.print("문자입력 = ");
		
		try {
		while(true) {
			/*
			// 01. read(); > 한번에 1문자(char)를 읽어온 후, 코드로 바꿔줌/return
			int inData = isr.read();
			System.out.println(inData+" ----> "+(char)inData);
			if(inData==-1) break;
			*/
			
			/*
			// 02. read(char[] cbuf); > char 배열을 이용하여 여러문자를 한 번에 읽어오기
			char[] inData = new char[30];
			// 읽은 문자의 수  = 문자 배열을 읽어옴
			int cnt = isr.read(inData);
			// char >>> String
			String inStr1 = new String(inData);
			String inStr2 = String.valueOf(inData);
			
			System.out.println(inStr1+"* * * * *");
			System.out.println(inStr2+"= = = = =");
			*/
			
			// 03. read(char[] cbuf, int off, int len); >
			char[] inData2 = new char[30];
			int cnt2 = isr.read(inData2);
			String inStr3 = new String(inData2, 0, cnt2);
			System.out.println(inStr3+" 입력한 문자까지만 출력");
			
			
		}
		
		
		
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}
