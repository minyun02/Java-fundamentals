class PrivateChild extends PrivateParent{  //상위클래스를 상속받음
	
	PrivateChild(){
		//private 접근제어자가 있는 멤버변수는 상속되지 않는다
		//System.out.println("num = "+num); < 에러!
		//setNum(); < private으로 바껴서 에러
		//super.setNum(); < private 접근제어자 메소드는 상속되지 않는다
	}
	
	//오버라이딩(override): 상속된 상위클래스 안에 있는 메소드 안의 함수식을 다시 써움(재정의/재활용), 반완형/메소드명/매개변수가 모두 같아야함
	//  상속클래스의 setNum 메소드가 private 접근제한자로 정의되어 있기 때문에 오버라이딩이 안된다!
	//private void setNum() {
	//	age += 2; 
	//}
	
}
///////////////////////////////////////////////////////////////
// 하나의 파일에 클래스가 2개, bin folder에 compiled 파일이 2개 생성, src 파일은 1개 > 저장파일의 이름에 "public"을 붙여줘야함!, 다른 클래스의 처리식이 적을때 사용
public class PrivateMain {

	public PrivateMain() {
		
		
	}

	public static void main(String[] args) {
		PrivateChild pc = new PrivateChild();
		System.out.println("pc.getNum() = "+pc.age);
		//							private 접근제한자는 객체명을 통한 접근이 불가능
		//System.out.println("pc.num = "+pc.num);
		

	}

}
