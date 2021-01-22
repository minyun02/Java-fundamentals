

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
// 								 직렬화를 하여 객체를 파일로 저장하도록 한다.
public class FileCopy implements Serializable {

	public FileCopy() {
		
	}
	public void start() {
		try {
			//파일복사
			File srcFile = new File("d://1.png"); //복사 할 파일을 가져옴
			File targetFile = new File("d://ioSample", srcFile.getName()); //복사할 곳
			
			FileInputStream fi = new FileInputStream(srcFile); //파일 불러오는 객체
			FileOutputStream fo = new FileOutputStream(targetFile); //파일 집어넣는 객체
			
			while(true){
				int inData = fi.read(); //가져올 파일 읽어오기
				if(inData==-1) break;
				fo.write(inData); //복사 할 곳에 쓰기
			}
			fo.flush();
			fo.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		new FileCopy();
//	}

}
