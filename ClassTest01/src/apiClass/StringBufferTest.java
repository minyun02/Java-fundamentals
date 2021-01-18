package apiClass;

public class StringBufferTest {

	public StringBufferTest() {
		// StringBuffer? 문자열을 비동기식으로 처리, 문자열이 자주 바뀌는 경우 유용하다.
		StringBuffer sb = new StringBuffer(); // 객체생성
		sb.append(true);
		sb.append("Spring");
		
		//insert 문자열 중간에 문자 삽입
		sb.insert(5, "Mybatis");
		
		//delete 문자 삭제
		//01234567890123456
		//trueSMybatispring
		sb.delete(4, 10); // 4번지부터 10번지 앞까지 문자열 삭제
		
		//reverse 문자의 순서를 바꿈
		//trueispring
		sb.reverse(); //오름차순, 내림차순 정리된거 반대로 할 때 사용하면 유용
		
		System.out.println("sb -> "+sb);
		System.out.println("capcity -> "+sb.capacity());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
