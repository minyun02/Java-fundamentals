import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		//객체를 여러개 담아서 리스트를 생성하고싶다
		ArrayList al = new ArrayList(); // 다른 종류의 객체 추가 가능 
		List<Member> lst = new ArrayList<Member>(); // Member 객체만 추가 가능
		
		//각 객체에 회원 1명에 대한 정보가 들어있다
		Member mem1 = new Member(100, "hong", "010-1234-5678", "서울시 서대문구");
		Member mem2 = new Member(200, "kim", "010-4567-7891", "서울시 종로구");
		Member mem3 = new Member(300, "park", "010-9876-1234", "서울시 중구");
		
		// ArrayList에 객체 담기, List라는 인터페이스를 상속받으니까 Vector와 담는 메소드 비슷하다
		al.add(mem1); //[0]
		al.add(mem2); //[1]
		al.add(mem3); //[2]
		
		lst.add(mem1); //[0]
		lst.add(mem2); //[1]
		lst.add(mem3); //[2]
		
		al.add(new String("홍길동"));
		// lst.add(new String("김대중"));// 왜? <Member>라고 담을 객체를 한정해서, generic은 같은 종류의 객체만 추가 가능하다
		
		for(int i = 0; i<lst.size(); i++) {
			Member m = lst.get(i); // 객체 데이터를 받아옴, Vector와 다르게 형변환이 필요없음, 왜? generic으로 담겨있어서 Object으로 담긴게 아니라 Member로 담겨있다 
			//Member m2 = (Member)al.get(i); Member로 형변환이 필요함
			
			m.memberPrn(); // Memeber class 안의 method 사용
		}
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
