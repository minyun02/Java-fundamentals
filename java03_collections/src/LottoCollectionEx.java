import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoCollectionEx {
	
	Scanner scan = new Scanner(System.in);

	public LottoCollectionEx() {
	}

	public void start() { // 
		do {
			int cnt = gameCount(); // 게임 수 > 정수값을 return해줌
			for(int i = 1; i<=cnt; i++) { // 1, 2, 3, ...
				System.out.print(i+"게임= ");
				createLotto();
			}
			// 게임 지속 여부, true? do-while 반복함, false > do-while 반복문 중단
			if(!qna()) {
				break;
			}
			
		}while(true);
		System.out.println("---------- The End ----------");
		
	}
	
	//게임 수 입력
	public int gameCount() {
		int intCnt = 0;
		do {	
			try {
				System.out.print("게임 수? ");
				intCnt = Integer.parseInt(scan.nextLine()); // Exception: NumberFormat ..
				// 게임의 수가 + != 경우, 0 or -1 ... > 게임 수 다시 입력받아야함
				if(intCnt <= 0) {
					// 강제 예외 발생
					throw new Exception("게임 수는 1보다 큰 값이어야 합니다. ");
				}
				break; // 게임 수가 제대로 입력되었을때 break
			}catch(NumberFormatException ne) {
				System.out.println("게임 수는 정수만 입력 가능합니다. ");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		return intCnt;
	}
	
	//1게임 set의 로또를 만드는 메소드
	public void createLotto () {
		Random ran = new Random();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int lastNum = 0;
		
		//번호 생성 후, TreeSet에 추가 -> 7개가 될 때까지...
		//회전 횟수를 모르는 반복문을 돌리기
		while(true) {
			lastNum = ran.nextInt(45)+1; // 1 ~ 45, --- 마지막으로 만들어진 번호임..
			ts.add(lastNum); // TreeSet에 넣어줌
			if(ts.size() >= 7) {
				break;
			}
		}
		//마지막으로 생성된 번호는 lastNum에 들어가 있는데, 이건 보너스니까 TreeSet에서 제거한다..
		ts.remove(lastNum);
		System.out.print(ts.toString()); // [1, 5, 6, 7, 8, 23]으로 출력됨
		System.out.println(", bonus = "+lastNum); //마지막 번호를 lastNum이 기억하고 있다..
	}
	
	//게임 지속 여부 물어보기
	public boolean qna() {
		boolean boo = false;
		do {
			System.out.println("계속하시겠습니까? (Y or y = 예, N or n = 아니오? "); // 이 외의 문자 > 다시입력
			String answer = scan.nextLine();
			if(answer.equalsIgnoreCase("Y")) { // "Y".equalsIgnoreCase(answer)도 가능
				// true: 계속, false: 멈춤
				boo = true;
				break;
			}else if(answer.equalsIgnoreCase("N")) {
				boo = false;
				break;
			}else { // 그 외 처음으로 돌아가서 질문
				
			}
			// 게임 지속여부에 상관없이 한 번 물어보고 끝내야함. 그래서 조건식 실행문에 break!
		}while(true); // break 없으면 무한 루프
		
		return boo;
	}
	
	
	
	
	
	public static void main(String[] args) {
		LottoCollectionEx lotto = new LottoCollectionEx();
		lotto.start();

	}

}
