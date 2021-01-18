import java.util.Iterator;
import java.util.Scanner;

public class Aclass {
	// 멤버변수, 객체가 만들어지면 무조건 생성된 상태처럼 여겨진다. 전역변수
	int num = 500;
	String username = "홍길동";	// 클래스이지만 일반 변수처럼 사용
	
	Scanner a = new Scanner(System.in);
	
	// 생성자 메소드
	// 1. 생성자 메소드는 클래스 생성자 메소드명의 이름과 같아야 한다
	// 		생성자 메소드는 반드시 반환값이 없어야 한다.
	// 2. 메소드는 반드시 소괄호()가 있다 
	// 3. 매개변수(arguments)의 개수는 제한이 없다, 소괄호 안에 있는 것
	// 4. 생성자 메소드는 객체 생성시 한 번만 실행된다.
	// 5. 객체 생성 시, 여러개의 생성자 메소드 호출 방법? 하나의 생성자 메소드 안에 다른 메소드를 호출함, this이용
	
	public Aclass(int num, String name) {	// VariableTest에서 쓸 생성자
		total();
		sum(num);
		this.num = num;
		// this: 지역변수와 멤버변수가 같을때 멤버변수를 지정하는 키워드(예약어)
		username = name; // 만약 username;으로 구현 할 경우, 자동적으로 멤버변수를 찾아감
	}
	
	public Aclass() {
		// new A() 매개변수가 없다
		System.out.println("Aclass()생성자 실행됨 ...");
		//total(); <<< 메소드 1 호출, 메소드가 호출이 되어야지 객체가 만들어지면서 실행이 됨
	}
	public Aclass(int n) {
		// new A(10) 정수형 매개변수 1개
		
		// 생성자에서 다른 생성자 호출: this() =현재 클래스 안에 있는 매소드?
		// 반드시 첫번째 실행문으로 처리되어야 한다, 즉 this() 위에 다른 명령문이 있으면 안된다.
		this();
		System.out.println("Aclass(int n)실행 -> "+n);
	}
	public Aclass(int x, int y, String name) {
		// new A(10, 20) 정수형 매개변수 2개, 문자열 변수/클래스 1개
		System.out.println("Aclass(int x, int y, String name)실행 -> "+x+", "+y+", "+name);
	}
	//public Aclass(int a, int b, String firtName) { // 변수는 소문자로, 다음 단어는 대문자로 시작, 위의 자료형과 매개변수 구조가 같아서?
	public Aclass(int a, int b, double firstName) {
		System.out.println("Aclass(int x, int y, double firstName)실행 -> "+a+", "+b+", "+firstName);
	}
	
	// 생성자 매소드 클래스 완성!
	
	// 메소드 1 : 1 ~ 100 까지의 합을 구하는 메소드
	// 접근제한자 + 반환형 + 메소드명(소문자로 시작, ()가 있다)
	public void total() {	// 접근제한자 없어도 되는 경우가 있음
	// 구현 
		int tot = 0;
		for(int i=1; i<=100; i++) {
			tot += i;
		}
		System.out.printf("tot = %d\n",tot);
	
	}
	
	
	// 메소드 2 : 임의의 값을 전달받아 그 수까지의 합을 구하는 메소드
	public int sum(int max) {
		int sum =0;
		for(int i =1; i<=max; i++) {
			sum +=i;
		}
		//System.out.println("sum = "+sum);
		return sum; // 반환은 결과값에 해당하는 자료형(int)을 입력[public int sum]하고 마지막에 리턴, 다른 클래스로 결과값을 보낼 수 있다?
	}
	// public int sum()은 괜찮지만, public int sum(int a)는 오류난다.
	
	
	
	
	
	
	
	
	
	
}
