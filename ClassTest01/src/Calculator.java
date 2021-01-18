// 패키지(폴더) 자리, 필요없으면 없어도 됨, 상위 디렉토리

import pac.AAA; 
// import문 자리 : 다른 클래스를 객체 또는 상속을 받아 사용할때, 클래스가 있는 위치를 알려준다. import의 개수는 제한이 없다
// Class의 기능을 여기서 쓰기 위해서 가지고 옴
// class file의 명명 기준, 대문자로 지어줘야함, ex.String, System, TestCaculator, ...
//import java.lang.System;
// lang이라는 패키지에 있는 class는 javac가 자동으로 import
//import java.util.*; util에 있는 모든 클래스
public class Calculator {
	// 멤버 영역: 실행문을 구현 할 수 없는 영역, > 멤버영역에 내부 클래스, 메소드, 생성자 메소드, 메인 메소드를 만드는 것.
	
	//public class 안의 구성 (하나의 클래스 안에는 기본적으로 멤버변수, 생성자메소드, 메소드가 필요하다)
	
	//1.멤버 변수: 해당 클래스 전체에서 사용 할 수 있는 변수
	
	//2.생성자 메소드 : 객체를 만들때, 실행, 호출 해줄 수 없다
	
	//3.메소드 : 호출을 해줄때, 사용 가능
	
	//4.메인 메소드
	
	//5.내부 클래스
	public static void main(String args[]) {	// 메인메소드
		//다른 클래스에서 구현한 기능을 사용할때 할 수 있는 방법 2가지: 1. 객체, 2. 상속
		// 1. 객체(new) : 생성자 메소드로 만들어야함		
		// new (내가 필요한 클래스명)()
		 Aclass obj = new Aclass(); // = reference 변수, 클래스에 해당하는 자료/구현한 기능을 모두 담고 있다
		int num = 100; //과 같은 변수와 다르다, 일반 변수는 변수 1개에 자료 1개만 담음
		 System.out.println("obj= "+obj);
		// 보관을 해야하는데, 보관하지 않으면 생성됐다가 사라져서 밑에서 사용불가 따라서 변수를 선언해줘야한다
		// 클래스명 변수명 = new (내가 필요한 클래스명)()
		 
		 Aclass obj2 = new Aclass(10, 5, "hong"); // 정수, 정수, 스트링의 변수를 가지고 있는 생성자
		 
		 Aclass obj3 = new Aclass(120);
		 
		// 객체내의 메소드 호출하는 방법, 호출하지 않으면 실행되지 않음
		 obj2.total(); // obj2 안에 있는 메소드가 실행됨
		 //int result = obj.sum(100); // 100이 max의 값으로 대입됨, 메소드의 실행값은 현재 클래스로 넘어오지 않는다 > 리턴(반환)이 필요함
		 int result = obj3.sum(10);
		 System.out.println("result = "+result);
		 
		 // 메인메소드 안에 생성된 메소드는 stack(지역변수)에 저장되어서 메인메소드 밖으로 나가면 사라짐
		 
		 
	}
	//static static void main(String args[]) {
	//public static void main(String ss[]) {
	//public static void main(String[] args){
	
}
