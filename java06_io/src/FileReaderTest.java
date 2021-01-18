import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
		try {
			File f = new File("d://javaIO/2021-01-14 scott.sql");
			
			//	FileReaer 객체 만드는 방법 
			FileReader fr = new FileReader(f); // 에러... 생성자 메소드 눌러보고 확인 : 예외처리가 필요
			//FileReader fr2 = new FileReader("d://javaIO/2021-01-14 scott.sql");
			
			BufferedReader br = new BufferedReader(fr);
			while(true) {
//				int read = fr.read();	한 개씩 입력이됨
//				if(read==-1) break;
//				System.out.println("f.read() :"+(char)fr.read());
				
				String read = br.readLine(); //엔터가 있는 곳까지 한 줄이 입력이됨, enter=기준
				// end of file = null > read에 들어감, read=null 일때 중단
				if(read==null) break;
				//System.out.println(read); //원래는 엔터가 빠져서 읽히는데, println이 엔터역할
				System.out.print(read);
			}
			
			
			
			}catch(FileNotFoundException fnfe) {
				System.out.println("파일이 존재하지 않습니다...");
				fnfe.getStackTrace();
			}catch(IOException io) {
				System.out.println("파일 읽기 에러 발생");
				
			}
	}

	public static void main(String[] args) {
		new FileReaderTest();
	}

}