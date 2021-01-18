
public class CalendarObjectMain {

	public static void main(String[] args) {
						// String 배열, 문자를 1개 이상 받을 수 있다

		CalendarObject obj = new CalendarObject(); // 객체 생성
								// = public CalendarObject()
		
		obj.start(); 
		// 메소드 호출 Start에서 getInput메소드까지 실행하고 값을 만든다음에 int year로 바뀜
		
		//int kor = obj.getInput("국어점수");
		//System.out.println("kor= " + kor);	// 정수입력 받을때 Scanner 사용하지 않고 이 매소드 사용가능
		
		//obj.titlePrint(2025, 5);
	}

}
