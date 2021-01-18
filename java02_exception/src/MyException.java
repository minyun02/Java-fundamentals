
public class MyException extends Exception { // API에 있는 Exception 상속받
// super 안의 값이예외 메세지로 설정된다.
	public MyException() {  // 객체생성 방법1
		super("1~10까지 값만 유효한 값입니다.");
	}
	
// 매개변수(String message)의 값이 예외 메세지로 설정된다.
	public MyException(String message) {
		super(message); //super = Exception

	}


}
