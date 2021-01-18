import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		//TreeSet : 중복 허용 x, 입력순서 유지 x, 크기 순서대로 정렬됨
		// 숫자 데이터와 문자 데이터 만듬
		int numData[] = {10, 50, 40, 30, 60, 60, 70, 70, 70, 80, 90};
		String strData[] = {"홍길동", "이순신", "세종대왕", "홍길동", "홍길동", "신사임당", "이순신"};
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int n : numData) {
			ts.add(n);
		}
		
		TreeSet<String> ts2 = new TreeSet<String>();
		for(String s : strData) {
			ts2.add(s);
		}
		
		
		Iterator<Integer> i = ts.iterator(); // 오름차순으로 정렬되서 get함
		while(i.hasNext()) {
			System.out.println("ts = "+i.next());
		}
		
		Iterator<String> i2 = ts2.iterator();
		while(i2.hasNext()) {
			System.out.println("ts2 = "+i2.next());
		}
		
		
		Iterator<Integer> ii = ts.descendingIterator();// 내림차순으로 
		while(ii.hasNext()) {
			int data = ii.next();
			System.out.println("ts의 desc = "+data);
		}

		Iterator<String> ii2 = ts2.descendingIterator();
		while(ii2.hasNext()) {
			String data = ii2.next();
			System.out.println("ts2의 desc = "+data);
		}
		
	}

	public static void main(String[] args) {
		new TreeSetTest();

	}

}
