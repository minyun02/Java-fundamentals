import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		
		try {
		
				// 원래 데이터 타입으로 저장하기, 불러오기 
				// DateOutputStream, DataInputStream
				
				File file = new File("D://io","data.txt");
				FileOutputStream fos = new FileOutputStream(file);
				DataOutputStream dos = new DataOutputStream(fos);
				
				//byte(1byte) < short(2byte) = char(2byte) < int(4byte) < long(8byte) < float(4byte) < double(8byte)
				//boolean : 1 byte
				int num = 125487;
				char str  = 'Z';
				double num2 = 254836.3254;
				boolean boo = true;
				
				dos.writeInt(num);
				dos.writeChar(str);
				dos.writeDouble(num2);
				dos.writeBoolean(boo);
				dos.close();
				
				//읽어오기
				FileInputStream fis = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(fis);
				
				int numIn = dis.readInt();
				char charIn = dis.readChar();
				double num2In = dis.readDouble();
				boolean booIn = dis.readBoolean();
				
				System.out.println("numIn = >" + numIn);
				System.out.println("numIn = >" + charIn);
				System.out.println("numIn = >" + num2);
				System.out.println("numIn = >" + booIn);
				
				
				
				
		}catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException ie) {
			System.out.println("쓰기 에러가 발생하였습니다.");
		}
		
	}

	public static void main(String[] args) {
		new DataInputOutputStreamTest();

	}

}
