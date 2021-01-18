package apiClass;


import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// 현재 시스템의 날짜, 시간 관련 정보를 객체로 생성한다
		Calendar now = Calendar.getInstance();  // Calendar=접근제한자라 new 사용 불가
		System.out.println(now);
		
		// 날짜를 변경하기 2021-05-28
		now.set(2021, 4, 28);	// 시간과 분은 그대로
		// set(int field, int value) 1. 연도변경 2.월변경 과 같이 특정 시간을 변경할때, 
		now.set(Calendar.YEAR, 2025);
				// Calendar라는 클래스 안에 있는 YEAR라는 멤버변수에  2025라는 값을 대입
		now.set(Calendar.MONTH, 0);
		now.set(Calendar.DAY_OF_MONTH,1);
		
		// 2020-12-24 현재시간:현재분(목) 을 출력해보자
		
		// get없이 출력하면 매개변수의 초기값을 출력한다
		
		int y = now.get(Calendar.YEAR); // 연도 , = now.get(1); < YEAR의 초기값
		int m = now.get(Calendar.MONTH)+1; // 월 1~12월을 0~11으로 데이터값이 주어졌기때문에 +1, =now.get(2);
		int d = now.get(Calendar.DAY_OF_MONTH); // 일 (11월에 며칠인지)
		
		int h = now.get(Calendar.HOUR_OF_DAY); // 시, HOUR_OF_DAY 24시간 기준, HOUR 12시간 기준
		int mi = now.get(Calendar.MINUTE);
		
		int w = now.get(Calendar.DAY_OF_WEEK); // 요일 1:일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토 > 숫자표현 문자로 변환
		String weekStr = "";
		//     V int보다 작은 정수, char, String만 사용 가능
		switch(w) {
			case 1: weekStr = "일"; break;
			case 2: weekStr = "월"; break;
			case 3: weekStr = "화"; break;
			case 4: weekStr = "수"; break;
			case 5: weekStr = "목"; break;
			case 6: weekStr = "금"; break;
			case 7: weekStr = "토"; 
		}
		
		System.out.printf("%d-%d-%d %d:%d(%s)\n",y,m,d,h,mi,weekStr);
		
		////////////////////////////////////
		
		int yearMax = now.getActualMaximum(Calendar.YEAR);
		System.out.println("yearMax = "+yearMax);
		int monthMax = now.getActualMaximum(Calendar.MONTH);
		System.out.println("monthMax = "+(monthMax+1));
		int dayMax = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("dayMax = "+dayMax); // 위에서 1월로 달을 변경했기 때문에 1월 중 제일 큰 날짜 구함
		
		
	}

}
