import pac.ProtectedTest;

public class ProtectedMain extends ProtectedTest{

	public ProtectedMain() {
		
	}

	public void start() {
		//protected 접근제한자는 같은 패키지일 경우 접근허용,
		//					  다른 패키지일 경우 성속받아서 접근가능
		//ProtectedTest pt = new ProtectedTest(); 객체생성 불가 > 왜? protected 접근제한자 사용
		
		
		//ProtectedEx pe = new ProtectedEx();	// protected로 선언되어도 같은 패키지 안에 있어서 접근허가 or 상속받으면 가능
		//System.out.println("----------"+pe.username);
		//pe.print();
		System.out.println("ProtectedTest의 username 변수 = "+username);
		print();
		
	}
	
	
	
	
	public static void main(String[] args) {
		new ProtectedMain().start();

	}

	
	
	
	
	
	
	
	
}
