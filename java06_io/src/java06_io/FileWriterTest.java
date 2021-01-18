package java06_io;

import java.io.File;
import java.io.FileWriter;

public class FileWriterTest {

	public FileWriterTest() {
		try {
		File f = new File("d://ioSample/text_file.txt"); //text_file 생성
		FileWriter fw = new FileWriter(f);
		String txt = "자바에서 문자열을 파일로 쓰기 연습 중...";
		
		//방법 1. 배열로 저장 : write(char[] cbuf, int off, int len)
			//문자열을 배열로 변환하기 > toCharArray() (=String) ---> char[]
		char c[] = txt.toCharArray();
		fw.write(c, 5, c.length-5); // 길이에 -5 안하면, 문자열이 넘어감
		fw.flush(); // 파일 안에 기록 완료
		
		//방법 2. String으로 저장 : write(String str, int off, int len)
		fw.write(c, 0, txt.length()); 
		fw.flush();
		
		fw.close(); // 사용 끝, 닫기
		
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("익셉션 발생");
		}
		System.out.println("end. . .");
	}

	public static void main(String[] args) {
		new  FileWriterTest();
	}

}
