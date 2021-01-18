// 김현정

package javaClassPractice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LotteryGame {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Random ranNum = new Random(); 
		
		while(true){
			System.out.print("게임 횟수 = ");
			int gameNum = scan.nextInt();
	
			int[] lottoNum = new int[6]; // 로또 난수 범위 지정
			int bonus = 0;
			
			for(int cnt=0; cnt<gameNum; cnt++) {  // 입력받은 게임횟수만큼 실행 0   1
				                             //                    5      
				System.out.print((cnt+1)+" 게임= ");
				
				for(int six=0; six<lottoNum.length; six++) {
					
					lottoNum[six] = ranNum.nextInt(45)+1;
					
					for(int check=0; check<six; check++) {	// 중복제거
						if(lottoNum[six]==lottoNum[check]) {
							six--;
							break;
					}
				}
					
				boolean flag = true;
				do {
					for(int i=0; i<lottoNum.length; i++) {  // 보너스 번호 추출
						bonus = ranNum.nextInt(45)+1;
						if(bonus == lottoNum[i]) {
							flag = false;
						}
					}	
				}while(!flag);		
					
				}
				Arrays.sort(lottoNum);// 오름차순정리
				System.out.print(Arrays.toString(lottoNum));
				System.out.println(" bonus="+bonus);	
			}
			System.out.print("계속하시겠습니까(1:예, 2:아니오)? ");
			int answer = scan.nextInt();
			if(answer == 2) {
				System.out.println("... 종료합니다 ...");
				break;
			}	
				
		}
		
			
			
			
			
			
	}

}	
