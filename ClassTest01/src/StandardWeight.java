
public class StandardWeight {
	//In Class,
	
	//1. 멤버변수, 클래스의 내의 범위에서는 모두 사용 가능
	int age;
	int gender;
	
	//2. 생성자 메소드
	public StandardWeight() {
		// 실행 할 코드가 있으면 입력, 클래스가 객체가 될 때 실행된다
		// 매개변수가 없는 생성자 메소드는 컴파일 시, javac.exe가 추가 해준다
	}
	public StandardWeight(int a) {
		// 매개변수가 있는 생성자는 만들고 위의 매개변수가 없는 생성자를 만들지 않았다면, 상속 할 때 문제가 발생
		// 따라서 무조건 만들어 주는 것이 좋음
	}
	//3. 일반 메소드
	public void start() {	// start 지역변수 안에 정보 대입, start 메소드가 끝나면 데이터 지워짐
		age = CalendarObject.getInput("나이"); // 다른 클래스의 static이 있는 메소드를 객체없이 바로 사용. 나이, 문자열을 넣어주면 정수를 받음
		gender = CalendarObject.getInput("성별(1.여성 2.남성)");
		int height = CalendarObject.getInput("키");
		int weight = CalendarObject.getInput("현재 체중");
		
		// 표준체중 구하기 (아래 메소드)
		double standard = getStandardWeight(height); // getStandardWeight 메소드로 자료값을 넘겨줌, double standard로 리턴
		
		// 표준체중 지수 구하기
		double standardIndex = (weight/standard)*100;
		
		String standardShape = standardShape(standardIndex);
		System.out.println("표준체중="+standard);
		System.out.println("당신의 표준체중지수는 "+standardIndex+"으로 "+standardShape+"입니다.");
		
	}
	// 표준체중 구하는 메소드: 나이와 키 필요 = 표준체중을 return한다
	public double getStandardWeight(int height) {	// start 메소드 안에서 height와 weight 변수를 그냥 사용 할 수 없다. 소괄호 안에 변수는 start의 변수와 관계가 있는 것이 아님
		double idx = 0.90;
		if(age<=35 && gender==1) {
			idx = 0.85;
		}else if(age>=36 && gender==2) {
			idx = 0.95;
		}
		
		double standard = (height-100)*idx;
		return standard;
		
	}
	
	// 표준체중지수를 이용한 평가기준
	public String standardShape(double idx) {
		String result = "";
		
		if(idx<86) {	// idx =85.9까지 포함
			result = "마른형";
		}else if(idx<96) {
			result = "조금 마른형";
		}else if(idx<116) {
			result = "표준형";
		}else if(idx<126) {
			result = "조금 비만형";
		}else {
			result = "비만형";
		}
		
		return result;
	}
	
	
	
	
	
	////////////////////////////////////////////////// 다른 클레스에 있다고 생각 하고 작업하기, 다른 클래스에서 StandardWeight 객체로 실행
	public static void main(String a[]) {
		
		//StandardWeight sw = new StandardWeight(); // 객체
		//sw.start(); // 표준체중구하기 실행
		
		new StandardWeight().start(); // 객체를 만들고 바로 호출
		
	}

}
