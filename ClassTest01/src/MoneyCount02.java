import java.util.Scanner;

public class MoneyCount02 {

	Scanner scan=new Scanner(System.in);
	
	public MoneyCount02() {
	}
	
	public void start() {
		int money = 50000;
		int div = 5;
		
		System.out.print("금액 입력? ");
		int wonInt = scan.nextInt();
		
		while(wonInt>0) {
			int cnt = wonInt/money;
			if(cnt>0) {
				String dan = "개";
				if(money>=1000) {
					dan="장";
				}
				System.out.println(money+"원= "+cnt+dan);
				wonInt -= (money*cnt); // 차액계산
			}	// 5만원 계산 끝
			// 다음 화폐단위 계산
			money = money/div; // 만원으로 바뀜
			if(div==5) 
				div=2;
			else 
				div=5;
			
		}
	}
	public static void main(String[] args) {
		new MoneyCount02().start();	// 생성자에서 계산 안 하고 메소드 호출

	}

}
