import java.util.Scanner;

public class EmailCheck {

	Scanner scan = new Scanner(System.in);
	
	public EmailCheck() {
		do {
			// 이메일 입력
			System.out.print("이메일 입력= ");
			String email = scan.nextLine(); // 한 줄의 데이터를 입력받음
			
			// 이메일 유효성 검사
			// 1. @(at mark) 존재의 유무
			int atMark = email.indexOf("@");
			// 2. .의 위치
			int point = email.indexOf(".");
			
			// @과 . 의 중복을 확인하는 방법
			int pointCnt = 0;
			int atMarkCnt = 0;
			for(int i=0; i<email.length(); i++) { // i = 0, 1, 2, 3, ... 
				if(email.charAt(i) == '.') {
					pointCnt++;
				} else if(email.charAt(i) == '@') {
					atMarkCnt++;
				}
			}
				
			
			if(atMark==-1 || point==-1 || atMark>point || (point-atMark)<=2 || pointCnt>=2 || atMarkCnt>1) { // 잘못된 이메일 주소
				System.out.println(email+"주소는 잘못된 이메일 주소입니다....");
			
			}else { // 정상 이메일 주소
				// @기준으로 앞과 뒤의 값을 잘라줌 > String.split or StringTokenizer
				String emailResult[] = email.split("@"); // 방법 1
				
				String id = email.substring(0, atMark); // 방법 2, 아이디와 도메인 직접 구분
				String domain = email.substring(atMark+1);
				
				System.out.println("아이디="+emailResult[0]);
				System.out.println("도메인="+domain);
			}
			
		}while(true); // 무한 루프

	}
	
	///////////////////////////////////////////////////////////// 실행
	public static void main(String[] args) {
		
		new EmailCheck();

	}

}
