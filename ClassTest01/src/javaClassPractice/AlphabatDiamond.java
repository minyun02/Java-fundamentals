// 김현정 
package javaClassPractice;

import java.util.Scanner;

public class AlphabatDiamond {
	
	Scanner scan = new Scanner(System.in);

	public AlphabatDiamond() {
		
		System.out.print("임의의 홀수입력 (1~49) > ");
		int oddNum;
		oddNum = scan.nextInt();
		
		int arr[][] = new int[oddNum][oddNum];
		
		char apb = 'A';
		
		for(int row=0; row<oddNum; row++) {
			
			if(row<(oddNum/2)) {
				for(int col=(oddNum/2)-row; col<=(oddNum/2)+row; col++) {
					System.out.println(row+","+col+","+oddNum+"!");
					if(apb == 'Z'+1) {
						apb = 'A';
					}
					
					arr[row][col] = apb++;
				}
			}else {
				for(int col=row-(oddNum/2); col<oddNum-(row-(oddNum/2)); col++) {
					System.out.println(row+","+col+","+oddNum);
					if(apb == 'Z'+1) {
						apb = 'A';
					}
					arr[row][col] = apb++;
				}
			
				
			}
			
		}
		// 알파벳 배열돌리기 끝
		
		// 출력
		for(int row=0; row<oddNum; row++) {
			
			for(int col=0; col<oddNum; col++) {
				System.out.printf("%3c", arr[row][col]);
			}
			System.out.println();
		
		}
		
		
	}

	public static void main(String[] args) {
		new AlphabatDiamond();

	}

}
