

public class OuterTest {	
	int num=1234;
	String name="세종대왕";

	public OuterTest() {
		System.out.println("OuterTest() 생성자..."); // 실행확인을 위해서 찍어둠 
	}
	public void outerPrint() {
		System.out.println(num+"->"+name);
		// System.out.println(no+"->"+username); 외부클래스는 내부클래스의 정보를 사용 할 수 없다. 단! 객체를 생성하면 사용 할 수 있다.
		
		// 내부클래스 객체 만들어서 정보 사용하기, 여기가 이미 외부클래스의 위치니까 외부클래스 객체 만들필요없다!
		//현재클래스가 외부클래스 안이기 때문에 외부클래스 객체없이 내부클래스 객체이 가능하다!
		//메소드 내의 내부클래스는 메소드 호출 시 생성된다.
		System.out.println("---------외부클래스 안에 내부클래스 객체 생성");
		InnerTest it = new InnerTest();
		it.innerPrint();
		
	}
	
	// 1. 멤버 내부클래스, 멤버영역에서 추가된 클래스
	class InnerTest{	//OuterTest 클래스에 포함된 클래스이니까, 외부클래스 이용해서 객체 생
		int no = 6789;
		String username="이순신";
		InnerTest(){
			System.out.println("InnerTest()생성자...");
		}
		public void innerPrint() {
			System.out.println(no+"--->"+username);
			System.out.println(num+"--->"+name); //내부클래에서는 외부클래스의 정보를 사용 할 수 있다.
		}
	}

	
	
	
	
////////////////////////////////////////////////////////// 클래스 또 만들기 귀찮으니까 다른 클래스에 있다고 생각하기, 	
	public static void main(String[] args) {
		OuterTest ot = new OuterTest();
		ot.outerPrint();
		
		//외부에서 내부클래스 객체를 생성하기 위해선 외부클래스 객체를 이용하여 내부클래스 객체를 생성하여야 한다. ->내부클래스는 외부클래스에 의존하게 된다..
		OuterTest ot2 = new OuterTest();
		OuterTest.InnerTest it = ot2.new InnerTest(); //내부클래스 객체를 생성 ... 컴파일 한 뒤에 bin 안에 클래스 2개 생성
		it.innerPrint();
		
		ot2.outerPrint();
		
	}

}
