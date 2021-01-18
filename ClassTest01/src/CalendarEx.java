import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {

	//Calendar cal = Calendar.getInstance();
			
	public static void main(String args[]) {
	
	/*	
	// code by teacher
	// 1.연도와 월을 입력받아야함
	Scanner scan = new Scanner(System.in);
	
	System.out.print("년도 = ");
	int year = scan.nextInt();
	System.out.print("월 = ");
	int month = scan.nextInt();
	
	Calendar date = Calendar.getInstance(); // 캘린더를 가져옴, 오늘 날짜와 시간
	
	// 2. 날짜를 1일로 바꾸기
	date.set(year, month-1, 1);  // 1의 요일을 구하기 위해서 날짜를 1일로 변경
	
	// 3. 1일에 대한 요일 구하기
	int week = date.get(Calendar.DAY_OF_WEEK);  // 1일에 대한 요일이 구해짐
	
	// 4. 마지막 날짜 구하기, 31일 = 1월 3월 5월 7월 8월 10월 12월/ 30일 = 4월 6월 9월 11월/ 28, 29 = 2월
	/*  방법 1, 직접 계산
	int lastDay = 31;
	switch(month) {
		case 4: 
		case 6: 
		case 9:
			lastDay =30; break; // 4, 6, 9월일 경우 30일로 바뀜
		case 2: // 출력할 달이 2월인지 확인 > 윤년인지 아닌지 확인해야함
			if(year%4 == 0 && year%100 != 0 || year%400 == 0) { // 윤년일 경우
				lastDay = 29;
			}else { // 윤년이 아닐때
				lastDay = 28;
			}
	}
	// 
	int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	// 필요한 정보 구하기 끝 --------------------------------------------------------------
	
	// 5. 출력하기
	//		5-1) 제목 출력
	System.out.printf("\t\t\t%d년 %d월\n",year,month);
	System.out.println("일\t월\t화\t수\t목\t금\t토");  // 배열에 넣어서 반복문 돌려도 됨
	
	// 		5-2) 공백 출력, 반복문 이용
	for(int space=1; space<week; space++) { // ex. week 5, space 1 ~ 5
		System.out.print("\t");
		System.out.print(" ");
	}
	
	//		5-3) 날짜 출력
	for(int day=1; day<=lastDay; day++) {
		System.out.print(day+"\t");
		if(day<9) {
			System.out.print(" ");
		}
		if((day+(week-1))%7 == 0) {
			System.out.println();
		}
	}
	//		5-4) 줄 바꾸기, 출력할 날짜(day) + (요일(5)-1) 2020.12, 5
	
	*/
	
	
	//==================================================================================
		
	//데이터 입력, 연도와 월
	Scanner sc = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	
	int inputYear = 0;
	int inputMonth = 0;
	
	System.out.print("년도 = ");
	inputYear = sc.nextInt();
	System.out.print("월 = ");
	inputMonth = sc.nextInt();
	
	// 입력한 날의 달력값 가져오기
	//cal.set(Calendar.YEAR, inputYear);
	//cal.set(Calendar.MONTH, inputMonth-1);
	
	cal.set(inputYear, inputMonth-1, 1); // 입력한 날의 첫번째 날짜
	int lastDay = cal.getActualMaximum(Calendar.DATE); // 달의 마지막 날짜
	
	// 달력 출력..ㅠㅠ
	System.out.println("\t\t\t"+inputYear+"년 "+inputMonth+"월"+"\t\t\t");
	System.out.println("일\t월\t화\t수\t목\t금\t토");
	
	// 총 한 달을 7일씩 끊어서 출력..
	for(int i=1; i<=lastDay; i++) {
		int week = Calendar.DAY_OF_WEEK; // 7칸 생성... 7개씩..? 출력 > 배열로 했더니 outofbound 에러
		if(i==1) {
			week = Calendar.DAY_OF_WEEK;
		}
		else if(i<10) {
			for(int j=1; j<week; j++) {
				System.out.print(" "); 
			}
		}
		System.out.print("\t"+i);
		if((i+(week-1))%7 == 0) {
			System.out.println();
		}
	}
	
	
	
	
	}
	
}
