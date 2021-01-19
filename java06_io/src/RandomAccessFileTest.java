import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		try {	
			// RandomAccessFile : 읽기, 쓰기가 가능하며 index를 지정할 수 있다.
			File f = new File("d://io", "random.txt");
			//mode : r->읽기전용, rw->읽기 쓰기 가능, w: 쓰기 가능 
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String txt = "Java api input/output Test";
			raf.writeChars(txt);
			
			String txt2 = "Sample Data 한글";  //-->바이트배열로 writeByte를 쓰니까..
			
			//원하는 index로 위치 이동해서 쓰기.
			raf.seek(3);
			byte txt2Arr[] = txt2.getBytes();
			raf.write(txt2Arr, 0, txt2Arr.length);	
			
			//읽어오기
			raf.seek(3);
			String readData = raf.readLine();
			System.out.println("readDate->"+ readData);
			
			byte[] readData2 = new byte[20];
			raf.seek(3);
			int strCount = raf.read(readData2, 0, readData2.length);
			String readData3 = new String(readData2, 0, strCount);
			System.out.println("readData3->"+ readData3);
			
			int numInt = 1234;	//0
			double numDouble = 56.3;	//10
			
			//쓰기
			raf.seek(0);
			raf.writeInt(numInt);
			
			raf.seek(10);
			raf.writeDouble(numDouble);
			
			//읽기
			raf.seek(0);
			int readData4 = raf.readInt();
			System.out.println("readData4->"+ readData4);
			
			raf.seek(10);
			double readData5 = raf.readDouble();
			System.out.println("readData5->"+ readData5);
					
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RandomAccessFileTest();

	}

}
