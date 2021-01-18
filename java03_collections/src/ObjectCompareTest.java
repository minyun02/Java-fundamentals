import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {
		//객체 내의 특정 필드로 정렬하는 방법?
		
		//MemberVo data 여러개 만들어서 ArrayList에 담기
		List<Member> lst = new ArrayList<Member>();
		
		lst.add(new Member(4, "홍길동", "010-1234-1234", "강원도 삼척시"));
		lst.add(new Member(3, "이순신", "010-1111-1234", "부산광역시"));
		lst.add(new Member(2, "유관순", "010-3333-1111", "서울시 중구"));
		lst.add(new Member(1, "세종대왕", "010-7777-8888", "경기도 안산시"));
		lst.add(new Member(5, "신사임당", "010-9999-9876", "대전광역시"));
		
		System.out.println("= = = = = = = 정렬전 = = = = = = =");
		for(Member mem : lst) {
			mem.memberPrn();
		}  // 입력된 순서대로 출력된다
		
		
		
		System.out.println("= = = = = = = 이름을 이용해 내림차순으로 정렬 = = = = = = =");
		// 정렬하기
		Collections.sort(lst, new CompareNameDesc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		
		
		System.out.println("= = = = = = = 이름을 이용해 오름차순으로 정렬 = = = = = = =");
		Collections.sort(lst, new CompareNameAsc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		
		System.out.println("= = = = = = = 번호를 이용해 오름차순으로 정렬 = = = = = = =");
		Collections.sort(lst, new CompareNoAsc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		
		
		System.out.println("= = = = = = = 번호를 이용해 내림차순으로 정렬 = = = = = = =");
		Collections.sort(lst, new CompareNoDesc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		
		
	}
	
	//번호를 기준으로 내림차순으로 정렬하는 내부클래스
	class CompareNoDesc implements Comparator<Member>{
		public int compare(Member m1, Member m2) {
			return (m1.getNo() < m2.getNo())? 1 : (m1.getNo() == m2.getNo())? 0 : -1; // 왼쪽 값이 더 작다고 인식한다, 실제로는 더 큼!
		}
	}
	
	//번호를 기준으로 오름차순으로 정렬하는 내부클래스
	class CompareNoAsc implements Comparator<Member>{
		public int compare(Member m1, Member m2) {
			// m1이 작으면 -1, = 0, m1이 크면 +1 return 해줌
			// 삼항연산자 = (조건식) ? 참 : 거짓 ;
			//			4			3 > false
			return (m1.getNo() < m2.getNo())? -1 : (m1.getNo() == m2.getNo())? 0 : 1 ; //마지막 조건은 처음 조건식의 false 일 떼 리턴해주는 값
		}
	}
	
	//이름을 오름차순으로 정렬하는 내부클래스 : 규칙 ? *** Comparator라는 interface를 상속받아 compare 메소드를 오버라이딩한다
	class CompareNameAsc implements Comparator<Member> {  //<generic>에 비교 할 클래스명을 적어두기
		public int compare(Member m1, Member m2) {
			return m1.getUsername().compareTo(m2.getUsername());
		}

	}
	//이름을 내림차순으로 정렬하는 내부클래스 : 규칙 ? *** Comparator라는 interface를 상속받아 compare 메소드를 오버라이딩한다
	class CompareNameDesc implements Comparator<Member> {  //<generic>에 비교 할 클래스명을 적어두기
		// 음수, 0 ,양수 >>> if, 음수를 return : 오른쪽 객체가 크다 / 0: =/ 양수: 왼쪽 객체가 크다
		// -1, 0, 1
		public int compare(Member m1, Member m2) { // Comparator interface의 Method인 compare를 overriding...
			//StringTest 크기비교 참고 (compareTo)
			//return m1.getUsername().compareTo(m2.getUsername()); // 홍길동 : 이순신 = 양수
			//return m2.getUsername().compareTo(m1.getUsername()); // 이순신 : 홍길동 = 음수 (return이 int)= 왼쪽이 크다라고 인식한다..실제는 왼쪽이 작음
			return m2.getUsername().compareTo(m1.getUsername());
		}
	}
	
	

	public static void main(String[] args) {
		new ObjectCompareTest();

	}

}
