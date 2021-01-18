
public class StaticTestMain {

	public static void main(String[] args) {

		// 클래스내의 메소드를 호출하기 위해서 객체를 생성함(StaticTest를 객체로 만듬)
		//StaticTest st = new StaticTest(); 
		// 메소드 호출
		//st.prn(); 객체명.메소드() = StaticTest라는 객체 안에 있는 메소드를 이용
		
		//객체를 만들지 않고 메소드를 호출하려면? static (기능1. 객체 사용 안하고 메소드 호출, 멤버변수 사용가능)
		//StaticTest 클래스의 멤버변수 앞에 static 키워드를 사용하면, 클래스를 객체생성하지 않고 사용 할 수 있다
		//							클래스명.static멤버변수 > 객체없이 StaticTest의 멤버변수 사용
		//System.out.println("num >>> "+StaticTest.num);
	
		//Static 메소드 호출
		// 클래스명.static메소드
		//StaticTest.prn();
		
		// static멤버변수는 객체를 생성시, 공통변수로 사용된다. 
		StaticTest st = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		// 값을 변경: 한 개는 static 변수, 하나는 그냥 멤버변수의 값을 변경
		st.num = 1234;
		st.name = "이순신";
		
		st2.prn(); // num = 1234, name = 세종대왕 출력
		
		
	
	}

}
