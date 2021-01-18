
public class VariableTest {

	public static void main(String[] args) {
		
		Aclass aaa = new Aclass(100, "이순신");  //객체생성
		// aaa 객체 안에 있는 변수: num=100, username=이순신, Scanner, [total, sum] Aclass안의 메소드
		//   >>> 객체내의 초기값은 100과 이순신으로 바뀜, 따라서 total과 sum에서 사용되는 초기값은 100과 이순신
		
		// 객체 안의 100/이순신은 생성자 메소드 n/name변수에 담겼다가 num/username변수에 담겨짐
		//   >>> 같은 데이터인데 변수명이 달라진다 >>> 같은 변수명 사용가능(n->num) >>> 지역변수와 멤버변수의 구분을 위해서 this.을 사용
		
		// 객체내의 num과 username이 변경이 되었는지 확인한다
		// 객체명.변수명 = 멤버변수
		
		System.out.println("aaa.num = "+aaa.num+aaa.username); 
		// Aclass의 멤버변수 값이 아닌, aaa객체의 값이 나옴 : 멤버변수일때만 가능

		Aclass bbb = new Aclass();  
		// bbb객체 안에는 num=500, username="홍길동", Scanner, total, sum
		// 초기값은 멤버변수에서 선언된 값이 사용된다.
		// aaa객체와 bbb객체는 같은 클래스를 이용해서 안에 자료가 다른 분리된 객체이다..?
	}

}
