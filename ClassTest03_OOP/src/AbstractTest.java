// 추상메소드를 포함했기 때문에 현재 클래스는 "추상클래스"가 되어버렸다
// 따라서 class 이전에 abstract 예약어를 표기해야한다!
// 추상클래스는 객체생성을 할 수 없고 추상크래스를 상속받아 모든 추상메소드를 오버라이딩(=메소드 재정의) 해야한다! 

public abstract class AbstractTest {
	int num = 1234;
	String name = "홍길동";

	public AbstractTest() {
		
	}

	public void total() {	//일반메소드
		int sum = 0;
		for(int i=1; i<100; i+=2) {
			
		}
		this.num = sum;
	}
	
	//추상메소드 : 반드시 반환형 이전에 abstract 예약어를 표기!
	public abstract void output();
	
	public abstract void sum(int max);
	
}
