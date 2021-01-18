import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		//TreeMap : key, value를 가진다.. key를 기준으로 정렬
	}

	public static void main(String[] args) {
		new TreeMapTest();
		
		//회원정보 4명 TreeMap에 저장하기
		TreeMap<String, Member> ht = new TreeMap<String, Member>();
		Member m1 = new Member(100, "홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1); 
				
		ht.put("세종대왕", new Member(200, "세종대왕", "010-3333-4444", "서울시 마포구"));
		ht.put("이순신", new Member(300, "이순신", "010-5555-6666", "서울시 양천구"));
		ht.put("유관순", new Member(400, "유관순", "010-7777-8888", "서울시 종로구"));
			
		ht.put("세종대왕2", new Member(500, "세종대왕2", "010-3333-4444", "서울시 마포구"));
		ht.put("이순신2", new Member(600, "이순신2", "010-5555-6666", "서울시 양천구"));
		ht.put("유관순2", new Member(700, "유관순2", "010-7777-8888", "서울시 종로구"));		
		
		Member m = ht.get("이순신");
		m.memberPrn();
		
		System.out.println("----------------- keySet으로 목록 구하기(ascending) -----------------");
		Set<String> set = ht.keySet(); // > TreeMap의 데이터라 String을 기준으로 오름차순정렬되어서 출력됨 ...
		Iterator<String> ii = set.iterator();
		while(ii.hasNext()) {
			Member mm = ht.get(ii.next()); //TreeMap의 value를 얻어옴
			mm.memberPrn();
		}
		
		System.out.println("----------------- descendimgKeySet으로 목록 구하기 -----------------");
		NavigableSet<String> descKey = ht.descendingKeySet(); // descendingKeySet Method 이용해서 내림차순으로 정리
		
		Iterator<String> iii = descKey.iterator();
		while(iii.hasNext()) {
			Member mm = ht.get(iii.next());
			mm.memberPrn();
		}
		
		
		System.out.println("----------------- value()로 목록 구하기 -----------------");
		Collection<Member> valMem = ht.values(); // 오름차순으로 나온다
		
		Iterator<Member> iiii = valMem.iterator();
		while(iiii.hasNext()) {
			Member mm = iiii.next(); // iiii가 TreeMap의 value니까 따로 get 할 필요가 없다
			mm.memberPrn();
		}
		
	}

}
