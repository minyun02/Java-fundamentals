import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		// (interface) set: 중복 데이터 허용 x, 입력 순서 유지 x
	
		// 숫자 데이터와 문자 데이터 만듬
		int numData[] = {10, 50, 40, 30, 60, 60, 70, 70, 70, 80, 90};
		String strData[] = {"홍길동", "이순신", "세종대왕", "홍길동", "홍길동", "신사임당", "이순신"};
		
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		for(int n : numData) {
			hs1.add(n);
		}
		System.out.println("hs1의 객체수 > "+hs1.size());
		
		HashSet<String> hs2 = new HashSet<String>();
		for(String s : strData) {
			hs2.add(s);
		}
		System.out.println("hs2의 객체수 > "+hs2.size());
		
		
		// HashSet에는 output할 method가 없다 > 다른 클래스의 도움을 받아야함 = iterator
		Iterator<Integer> i = hs1.iterator(); // HashSet의 데이터를 받아서 Iterator로 묶어서 던져줌
		while(i.hasNext()) { // 남은 객체 확인
			System.out.println("hs1 = "+i.next()); //남은 객체 출력
			
		}
		
		System.out.println();
		
		Iterator<String> i2 = hs2.iterator();
		while(i2.hasNext()) {
			System.out.println("hs2 = "+i2.next());
		}
		
		
		
	}

	
	
	
	
	
	
	public static void main(String[] args) {
		new HashSetTest();
		

	}

}
