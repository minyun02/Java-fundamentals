import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {

	public HashtableTest() {
		
	}

	public void start() {
		// key, value를 가진다 > Map을 상속받았으니까!
		// Hashtable : 동기화 지원(동시사용 불가), 
		// HashMap : 동기화 지원 X (동시시용 가능)
		
		//회원정보 4명 Hashtable에 저장하기
		Hashtable<String, Member> ht = new Hashtable<String, Member>();
		
		// Member class에 회원정보 추가하고, Hashtable 데이터 설정,,, 데이터가 1종류면 generic 쓰기 
		// Key에는 중복값을 쓰면 안된다
		Member m1 = new Member(100, "홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1); // m1의 데이터를 hashtable에 대입 >>> key값과 value가 정해짐!
		
		ht.put("세종대왕", new Member(200, "세종대왕", "010-3333-4444", "서울시 마포구"));
		ht.put("이순신", new Member(300, "이순신", "010-5555-6666", "서울시 양천구"));
		ht.put("유관순", new Member(400, "유관순", "010-7777-8888", "서울시 종로구"));
		
		ht.put("11세종대왕", new Member(500, "11세종대왕", "010-3333-4444", "서울시 마포구"));
		ht.put("11이순신", new Member(600, "11이순신", "010-5555-6666", "서울시 양천구"));
		ht.put("11유관순", new Member(700, "11유관순", "010-7777-8888", "서울시 종로구"));
		
		//특정 key를 기준으로 가져오기 : key를 알고 있을 경우
		Member vo = ht.get("이순신"); // ht의 정보를 Member에 저장하기위해서 변수 vo 생성
		vo.memberPrn();
		
		System.out.println("--------------------------------- Map의 Key 목록 구하기 : Return Set;");
		Set<String> keyList = ht.keySet(); //keyList 안에 key들이 들어있음, but 우리가 데이터를 저장한 순서대로 구해지는게 아니라 섞임
		
		System.out.println("- - - - - - - - - - - toArray로 출력");
		Object[] obj = keyList.toArray(); // 데이터가 다 섞임
		for(Object o:obj) {
			System.out.println(o);
		}
		System.out.println("- - - - - - - - - - - Iterator로 출력");
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
		//	System.out.println(ii.next());
			Member v = ht.get(ii.next());
			v.memberPrn();
		}
		
		System.out.println("--------------------------------- Map의 전체 value 목록 구하기"); 
		Collection<Member> value = ht.values();
		
		Iterator<Member> ii2 = value.iterator();
		while(ii2.hasNext()) {
		//	System.out.println(ii2.next()); = 주소값 출력
			Member vvv = ii2.next();
			vvv.memberPrn();
		}
		
	}
	public static void main(String[] args) {
		new HashtableTest().start();

	}

}
