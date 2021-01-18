
public class MethodinnerClass {
	String email = "adcb@naver.com"; //멤버변수 
	
	public MethodinnerClass() { //생성자 
	}

	public void output() {
		System.out.println("이메일-->"+email);
		
	}
	
	public void innerClassMethod() {
		int num = 100;
		
		// 메소드에 정의된 내부클래스 
		class InnerCreate {
			String name = "홍길동";
			InnerCreate() {	// 내부클래스의 생성자메소드 
				
			}
			
			void innerPrint() { // 내부클래스의 메소드
				System.out.println("name--->"+name);
				System.out.println("num--->"+num);
				System.out.println("email--->"+email);
				output();
				
			}
		}
		// 객체생성
		InnerCreate ic = new InnerCreate();
		ic.innerPrint();
		
	} //innerClassMethod 메소드가 호출되어야지 안에 Class 생성이됨
	
	
	
	
	
	public static void main(String[] args) {
		MethodinnerClass mic = new MethodinnerClass();
		mic.innerClassMethod();
	}

}
