import java.util.Calendar;
import java.util.Scanner;

public class CalendarObject {	// 달력을 객체로 만들기 !
	//생성자 메소드, 객체 생성시 실행된다
	public CalendarObject() {
		// start(); 객체가 생성시 생성자 메소드가 실행되니까 자동으로 start 매소드 실행됨
	}

	// 1번. 콘솔에서 정수를 입력 받는 메소드
	public static int getInput(String msg) {	//문자열을 입력받아서 정수로 출력
		// public static int getInput = 이 클래스를 객체로 만들지 않아도, 이 메소드를 사용 할 수 있음. [다른 클래스에서] int age = CalendarObject.getInput("나이");
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		return scan.nextInt();
	}
	// 2번. 입력 받은 연, 월과 1일을 Calendar객체로 만들어 리턴하기 
	public Calendar getCalendar(int y, int m) {
		Calendar now = Calendar.getInstance(); // 현재 날짜의 캘린더
		now.set(y, m, 1); // 날짜를 1일로 바꿔줌
		return now;
	}
	// 5번. 제목 출력
	public void titlePrint(int y, int m) {
		System.out.println("\t\t"+y+"년 "+m+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
	}
	// 6번. 1일 앞에 공백출력
	public void spcacePrint(int w) {
		for(int i=1; i<w; i++) {
			System.out.print("\t");
		}
	}
	// 7. 날짜 출력, 7일 간격 출바꾸기
	public void dayPrint(int lastDay, int week) {
		for(int i=1; i<=lastDay; i++) {
			if(i<10) {
				System.out.print(" ");
			}
			System.out.print(i+"\t");
			if((i+(week-1))%7 == 0) {
				System.out.println();
			}
		}
	}
	public void start() {	// 위에 있는 하나의 getInput 메소드로 입력을 2개를 받음
		// 날짜 입력
		int year = getInput("년도");
		int month = getInput("월");
		Calendar modifyCalendar = getCalendar(year,month-1); // 변경된 캘린더가 나옴
		// 요일 구하기
		int week = modifyCalendar.get(Calendar.DAY_OF_WEEK); //4번
		int lastDay = modifyCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); //5번
		
		titlePrint(year,month);
		spcacePrint(week);
		dayPrint(lastDay, week);
		
	}
}
