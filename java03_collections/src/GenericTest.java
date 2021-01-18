import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenericTest<T> { // generic class
	
	private T username; // 데이터형을 변환해서 변수를 쓰고싶을때.. = Generic, class명 옆에 <>를 선언함. <T> 안의 T data type
	
	public GenericTest() {}
	
	public GenericTest(T username) { // 참조변수로 
		this.username = username; //멤버변수로 치환
		
	}

	public T getUsername() {
		return username;
	}

	public void setUsername(T username) {
		this.username = username;
	}

	public void dateOutput() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //API 확인해보기
		String fmt = format.format(((Calendar)username).getTime()); //형변환
		System.out.println("fmt = "+fmt);
	}
}
