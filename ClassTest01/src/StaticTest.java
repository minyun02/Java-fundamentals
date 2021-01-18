
public class StaticTest {
	// 멤버변수
	// 초기값을 설정하지 않은 멤버변수인 경우
	//   ; 정수는 0이 초기값, 실수는 0.0, 논리형: false, 객체형: null이 초기값으로 들어간다
	static int num = 100;
	static String name = "세종대왕";
	
	public StaticTest() {}
	
	public static void prn() {
		System.out.println("num > "+num);
		System.out.println("name > "+name); // 만약 name 앞에 static없으면 오류발생
	}

}
