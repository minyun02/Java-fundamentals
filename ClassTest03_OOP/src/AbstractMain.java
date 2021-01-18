
public class AbstractMain extends AbstractTest{

	public AbstractMain() {
		// TODO Auto-generated constructor stub
	}
	
	//추상메소드 오버라이딩 = 추상메소드와 똑같이! abstract 빼고
	public void output() {
		System.out.println("num--->"+num);
		System.out.println("name--->"+name);
	}
	public void sum(int max) {	//오버라이딩 할 추상메소드의 데이터타입은 같아야하고, 변수명은 달라도 된다!
		int total = 0;
		for(int i=1; i<=max; i++) {
			total+=i;
		}
		System.out.println("1~"+max+"까지의 합은? "+total);
	}
	
	//더 추가하고싶은 메소드 추가해도 됨
	public void start() {
		
	}
	
	public static void main(String[] args) {
		AbstractMain am = new AbstractMain();
		am.sum(100);
		
		//AbstractTest at = new AbstractTest(); 
		//  ㄴ error 난다, 왜? 추상클래스의 추상메소드가 미완성된 상태이기 때문에
	}

}
