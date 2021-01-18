import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		// InputStream class는 Abstract class라서 객체 생성 할 수 없다 > lang.system에 멤버변수 in이 InputStream으로 리턴해줌..
		// 						byte단위로 입력 받는 클래스
		/*
		int a[] = new int[10];
		for(int b:a) {
			System.out.println(a);
		}
		// 배열의 값을 입력해두지 않으면 기본으로 0이 들어가있다..
		*/
		
		try {
			InputStream is = System.in;
			System.out.print("입력=");
			//Method 1. read(); = 입력문자를 byte씩 읽어온다
			//					기본적으로 IOException이 포함되기 때문에, 예외처리를 꼭 해줘야한다..
			while(true) {
				/* 01. read();
				int inData = is.read(); //읽을 데이터가 없을때, -1이 입력된다 > 이때, 브레이크
				if(inData == -1) break;
				System.out.println(inData+","+(char)inData); // 입력받은 문자의 (기본) ascii code 출력, 한글을 치면 한 글자당 바이트 크기가 커서 깨져서 출력됨
				*/
				
				
				/*
				// 02. read(byte[] b); -> 벼열의 크기만큼 한 번에 읽어온다
				byte inData[] = new byte[50]; //바이트 배열 만들어줌
				//byte수가 읽힘		읽을 문자는 byte이고 이걸 배열에 저장
				int cnt = is.read(inData);
				// 내가 가진 데이터 = byte형, 출력하려는 데이터 = String >>> String 클래스 API
				//System.out.println(new String(inData)+" >>> "+cnt); // 필요없는 데이터까지 모두 출력됨
				System.out.println(new String(inData, 0, cnt)+" >>> "+cnt); // 내가 입력한 문자까지 출력이 가능... cnt는 입력받은 값을 보관하는 변수, 그래서 기준이 된다
				if(cnt <=0) break;
				*/
				
				
				// 03. read(arr[] b, int off, int len) -> 배열 데이터, 처음으로 담길 번지수, 담을 데이터 개수
				byte inData[] = new byte[10];
				int cnt = is.read(inData, 3, 4);
				//				읽을 데이터 배열, 배열의 저장위치 index, 읽을 byte개수
				for(int i=0; i<inData.length; i++) {
					System.out.println("inData["+i+"]= "+inData[i]+", cnt= "+cnt);
				}
				
			}	
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
			
			
			
	}

	public static void main(String[] args) {
		new InputStreamTest();

	}

}
