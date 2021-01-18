
public class TypeCasting {

	public TypeCasting() {
		BBB b1=new BBB();  // reference 변수 = 객체, BBB=(AAA+BBB) 왜? 상속받음
		b1.print();
		b1.namePrint();
		
		// 하위클래스로 객체를 생성하여 상위 클래스 변수에 대입 가능하다
		AAA a1 = new BBB();
		a1.print();
		//a1.namePrint(); // AAA클래스에는 BBB클래스가 숨겨져 있다
		BBB b2 = (BBB)a1;
		b2.namePrint();
		
		/* 상위클래스의 객체를 하위클래스의 레퍼런스 변수에 대입 할 수 없다!
		AAA a2 = new AAA();
		BBB b3 = (BBB)a2;
		b3.namePrint(); > 여기서 오류 안 나지만, 실행시 오류!   */
		
		////////////////////////////////////////////////
		BBB b3 = new BBB();
		b3.output();
		// 하위클래스에서 상위클래스의 메소드를 오버라이딩한 메소드는 상위클래스로 형변환 하더라도 메소드가 존재한다!
		AAA a3 = b3;  // 상위클래스에 하위클래스 객체를 삽입, 형변환
		a3.output();
		
		Object obj = new BBB(); // Object는 최상위 클래스라서
		BBB b4 = (BBB)obj; // 하위클래스인 BBB로 형변환해도
		b4.namePrint(); // 하위클래스의 메소드가 작동한다
		
		
	}

	public static void main(String[] args) {
		new TypeCasting();

	}

}

