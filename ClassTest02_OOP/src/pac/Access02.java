package pac;

public class Access02 {

	private int num=100; // 변수의 캡슐화, 데이터 보호
	//만약 다른 패키지 또는 클래스에서 사용해야한다면? 새로운 메소드(getNum)를 만들어서 이용
	String name="홍길동";
	
	public Access02() {
		// TODO Auto-generated constructor stub
	}
	
	//getter, setter
	// get or set + 첫글자를 대문자로 바꾼 변수명: 변수명 만들때 3글자 이상 사용
	
	public String getName() {	//getName을 호출하면 문자를 반환함
	// 만약 생성자가 default라면 AccessMain에서 호출되면 에러남 > 왜? 다른 패키지라서
		return name;
		//=return this.name; 이 클래스 안에 멤버변수
	}
	public void setName(String name) {
		this.name = name;
	}
	// name은 public이라서 굳이 getter n setter가 필요없음
	
	public int getNum() {	// private 변수인 num을 사용가능하게 만듬
		return num;
	}
	
	public void setNum(int num) { // private 변수인 num의 값을 변경하기 위한 메소드
		// 메소드=기능구현가능, e.g)로그인 안되면 입력 불가
		if(num%100 == 0) {
			this.num = num;
		}
	}


}
