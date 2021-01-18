// 김현정

package javaClassPractice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class LotteryGameObj {
	
	Scanner scan = new Scanner(System.in);
	Random sampling = new Random();
	
	int bonus=0;
	int lotto[] = new int[6];
	

	public LotteryGameObj() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int drawNum(int gameNum) {
		
		for(int count=1; count<=gameNum; count++) {
			
			for(int i=0; i<lotto.length; i++) {
				lotto[i] = sampling.nextInt(45)+1;
				
				for(int check=0; check<i; check++) {
					if(lotto[check]==lotto[i]) {
						i--;
					}
				}
			}
			//System.out.print(Arrays.toString(lotto));
		}
		return drawNumResult[];
		
	}
	
	
	public void answer() {
		System.out.print("계속 진행하시겠습니까? (1:예, 2:아니오) ");
		int answer = scan.nextInt();
		int w=0;
		while(w>0) {
			if(answer == 1) {
				
			}else {
				System.out.println("... 종료합니다 ...");
				break;
			}
		}
	}
	
	
	public void start() {
		System.out.print("게임 횟수= ");
		int gameNum = scan.nextInt();
		
		// 6개 로또번호 추첨
		int drawNumResult[] = drawNum(gameNum);
		
		// 1개의 보너스 번호 추첨
		
		// 게임 지속 여부 물어보기
		
	}

	
	public static void main(String[] args) {
		// new LotteryGameObj();

	}

}
