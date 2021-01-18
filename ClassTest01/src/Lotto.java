import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	public Lotto() { 
		start();
	}
	
	public void start() {
		do {
			System.out.print("게임 횟수= ");
			
			int game = scan.nextInt();
			
			//입력받은 게임 수만큼 로또번호를 처리
			for(int cnt=1; cnt<=game; cnt++) {	// cnt = 1,2,3,4,....
				
				// 1. 게임을 저장 할 배열을 생성
				int lotto[] = new int[7]; // index num 0~6, new라서 반복될 때마다 계속 새로운 배열 생성됨
				// 2. 난수 만들기
				for(int i=0; i<lotto.length; i++) {
					lotto[i] = ran.nextInt(45)+1; // 1~45
					//2-1. 다음 데이터 만들기 전에, 이전의 값들과 중복검사 실행,
					for(int check=0; check<i; check++) { // i=0? check=false, 현재 for문 실행안됨
						if(lotto[check]==lotto[i]) {	// 중복값일 경우
							i--; // i-1로 돌아감
						}
						
					}	// 보너스 숫자를 제외한 나머지만 정렬
					
				}
				
				// 오름차순 정렬, 버블 sorting 방법
				for(int j=0; j<lotto.length-2; j++) { // 0 ~ 5번지
					for(int i=0; i<lotto.length-2-j; i++) {	// 보너스 숫자를 제외한 lotto의 길이(6)에서 마지막 번지를 제외한 나머지끼리 비교, 0~4번지, -j 회전수를 줄여줌
						if(lotto[i] > lotto[i+1]) {
							// 두 데이터를 교환
							int temp = lotto[i];
							lotto[i] = lotto[i+1];
							lotto[i+1] = temp;	// 여기까지하면 보너스 숫자를 제외한 마지막 숫자가 제일 큰 숫자가 오지만, 앞에는 정렬이 안돼있다. > 5번 비교 실행하면 정렬됨
						}
						
					}
				}
				// 여기서 그냥 출력하면 보너스 번호까지 배열 안에 다 들어가서 출력됨
				// 출력
				System.out.print(cnt+"번 게임=[");
				for(int i=0; i<lotto.length-1; i++) {	// [0] ~ [5]
					System.out.print(lotto[i]);
					if(i==5) {
						System.out.print("], ");
					} else {
						System.out.print(",");
					}
				}
				// 보너스 
				System.out.println("bonus= "+lotto[lotto.length-1]);
				//System.out.println(Arrays.toString(lotto));
			}
			
			//게임 계속 여부 확인
			System.out.print("계속하시겠습니까 (1:예, 2:아니오)? ");
			int que = scan.nextInt();
			if(que == 2) break; // 무한루프가 끝나고 while문 아래로 나감
		}while(true);	// 무한루프
		System.out.println("프로그램을 종료합니다...");
	}
	
	
	
	
	

	public static void main(String[] args) {
		new Lotto();
		

	}

}
