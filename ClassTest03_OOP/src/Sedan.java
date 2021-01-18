
public class Sedan extends Car{
	// 다른 클래스를 상속받을 경우 클래스명 왼쪽에 "extends" + 상속받을 클래스명
	// 클래스는 1개만 상속받을 수 있다.
	
	String carColor = "Orange"; //상위클래스에 있는 변수
	//하위클래스에서 변수를 상위클래스의 변수와 같은 변수를 선언 할 수 있다
	int speedMax = 150; //상위클래스에 없는 변수
	
	public Sedan() {
		
		System.out.println("Sedan() 생성자메소드");
	}
	
	public Sedan(String carName, String carColor) {
		//상위클래스의 생성자를 호출하는 방법, 상위클래스의 생성자명을 바로 사용 못함
		//상위클래스의 생성자 호출은 항상 첫번째 행에서 이루어져야함
		super("그랜저",50,"Gray");
		
		//super.carName = carName; 
		//하위클래스에 carName없어서 super없어도 되지만, 여기서 없어지면 지역변수 carName으로 바뀐다
		// =this.carName으로 하면 하위에 carName이 없으니까 자동으로 상위클래스로 간다
		this.carName = carName;
		super.carColor = carColor;
		
		System.out.println("Sedan(String, String)생성자");
	}
	
	
	
	public void start() {
		System.out.println("색상:"+carColor);
		//상위클래스와 하위클래스의 변수명이 같으면 하위클래스 변수 사용
		//자신의 클래스 this, 상위클래스 super > 상위클래스의 변수를 가져옴
		System.out.println("색상(상위클래스):"+super.carColor);
		
		System.out.println("이름:"+carName);
	}

	public void speedUp() {
		speed += 15;
		if(speed>150) {
			speed = 150;
		}
	}
	public static void main(String[] args) {
		Sedan s = new Sedan(); // 객체 생성
		s.speedUp(); // 하위클래스의 메소드가 더 가까우니까 하위클래스로 실행됨
		System.out.println("s.sppedUp()= "+s.speed);
		// 실행 될 경우, 상위클래스의 생성자를 먼저 실행하고 하위클래스의 생성자를 실행
		//s.start();
		
		//Sedan ss = new Sedan("베뉴","Blue");
		//ss.start();
		
	}

}
