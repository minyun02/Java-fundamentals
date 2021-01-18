
import pac.Access02; // 오류난다, 왜? 접근제어자가 default라서 > 클래스를 public으로 변경해서 오류 해걸 > new Access02는 오류> 생성자 앞에 public
public class AccessMain {

	public AccessMain() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		// 이 클래스에서 Access01의 정보를 사용하기 위해서 객체생성, 같은 package에 있음
		Access01 a1 = new Access01();
		
		//System.out.println("Access01 안의 멤버변수? "+a1.userid); // 객체명.멤버변수, private변수로 바뀌면 사용불가
		System.out.println("Access01 안의 멤버변수? "+a1.userpwd);
		a1.printData(); // Access01에 있는 default 메소드를 사용함
		
		
		
		// 이 클래스에서 Access02의 정보를 사용하기 위해서 객체생성, 다른 package에 있음
		Access02 a2 = new Access02(); // 처음에 오류, 왜? 다른 package에 있어서
		System.out.println("a2.getName= "+a2.getName());
		System.out.println("a2.getNum= "+a2.getNum());	// private 변수 num을 출력
		
		// a2객체에 있는 num를 200으로 변경
		// 일반적인 객체에 있는 변수값 변경법: a2.num=200; < private이라 오류, 새로운 메소드 만들기
		a2.setNum(200);
		System.out.println("a2, private num=100>>> "+a2.getNum());
		//System.out.println("Access02 안의 멤버변수? "+a2.num);
		//System.out.println("Access02 안의 멤버변수? "+a2.name); 
		//	두 변수다 출력 오류, 왜? 변수의 접근제한자가 default 생성자, 일반적을 멤버변수에는 public을 붙이지 않음, 왜? 데이터를 담고 있기 때문에 정보 보호차원에서
		
		
		
		
	}

	public static void main(String[] args) {
		new AccessMain().start();
		
	}

}
