import java.util.Scanner;

public class MoneyCount01 {
	Scanner scan = new Scanner(System.in);
	int money[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
	
	public MoneyCount01() {
		
		System.out.print("금액 입력? ");
		int wonInt = scan.nextInt();
		
		for(int i=0; i<money.length; i++) { //i = 0 ~ 9
			int cnt = wonInt/money[i];
			if(cnt>0) {
				System.out.print(money[i]+"원= "+cnt);
				if(money[i]>=1000) {
					System.out.println("장");
				}else {
					System.out.println("개");
				}
				// 차액 계산하기
				wonInt -=(cnt*money[i]);
			}
		}
		
	}

	public static void main(String[] args) {
		new MoneyCount01();	// 생성자에서 모든 계산
		

	}

}
