import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

import java06_io.FileCopy;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			//파일의 객체를 가져오기
			File f = new File("d://io/Object.txt");
			FileInputStream fis = new FileInputStream(f); //바이트로 가져온다.
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//첫번째 객체 읽어오기 
			ArrayList al = (ArrayList)ois.readObject();
			
			//두번째 객체 읽어오기
			DataVO vo = (DataVO)ois.readObject();
			
			//형변환해서 가지고 오기----------------------------------------------------------
			String username = (String)al.get(0);
			Calendar date = (Calendar)al.get(1);
			FileCopy copy = (FileCopy)al.get(2);
			
			System.out.println("arrayList.string->"+ username);
			System.out.println("arrayList.calendar->"+ date);
			copy.start();//fileCopy
			
			System.out.printf("dataVO->%d, %s, %s, %s\n", vo.getNum(), vo.getName(), vo.getTel(), vo.getEmail());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();

	}

}
