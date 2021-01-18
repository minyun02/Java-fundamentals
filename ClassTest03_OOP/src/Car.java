
public class Car {
	
	String carName = "소나타";
	int speed = 0;
	String carColor = "화이트";
	
	public Car() {	// 기본 생성자 메소드는 없어도 괜찮은데 만약 다른 클래스와 상속관계일때, 없으면 에러 날 수도 있음
		System.out.println("Car() 생성자메소드");
	}

	public Car(String carName, int speed, String carColor) {
		this.carName=carName;
		this.speed=speed;
		this.carColor=carColor;
		
		System.out.println("Car(String carName, int speed, String carColor) 생성자메소드");
	}
	
	
	
	public void speedUp() {  //호출 될 때마다 속도 증가
		speed += 10;
		if(speed>100) {
			speed = 100;
		}
	}
	public void speedDown() {  //호출 될 때마다 속도 감소
		speed -= 10;
		if(speed<0) {
			speed = 0;
		}
	}
	
}
