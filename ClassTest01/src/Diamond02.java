import java.util.Scanner;

public class Diamond02 {
	Scanner scan = new Scanner(System.in);
	
	
	public Diamond02() {
	}
	
	public void start() {
		// 입력 받기
		System.out.print("임의의 홀수입력(1~49)= ");
		int max = scan.nextInt();	// max=9
		// 짝수를 입력하면 홀수로 변경하는 작업
		if(max%2==0) {
			max--; //max++;
		}
		
		
		// / / / / / /  / / //// / / / / / /  / / / / / / /  / / ////삼각형 만들기!
		// 출력문자의 초기값 세팅
		char txt = 'A';
		int step = 2;
		
		//행 처리: 한 줄에 출력하는 문자의 개수 > 홀수로 증가하는 규칙				row-=2
		for(int row=1; row>0; row+=step) { // row = 1, 3, 5, 7, 9 | 7, 5, 3, 2, 1
			//공백 출력 = (max - row)/2: 9 -1 /2
			for(int space=1; space<=(max-row)/2; space++) {  // space = 1, 2, 3, 4 (1회차)
				System.out.print(" ");
			}
			
			//문자 출력 = (max - row) 
			for(int col=1; col<=row; col++) {
				System.out.print(txt++);
				if(txt>'Z') {  // Z까지 출력 후, 초기화!
					txt = 'A';
				}
			}
			System.out.println();
			if(row>=max) {
				step-=2;
			}
		}
		
	}
	
	
	

	public static void main(String[] args) {
		new Diamond02().start(); // 객체와 만들어진 객체가 들어있는 클래스 안의 메소드 호출

	}

}
