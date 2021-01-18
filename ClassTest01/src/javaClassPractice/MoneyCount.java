package javaClassPractice;


import java.util.Calendar;

public class MoneyCount {
	
	public MoneyCount() {
		
	}
	
	public int change(int num) {
		
		int coin[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int remain = 0;
		
		for(int i=0; i<coin.length; i++) {
			if(num/coin[i]>0) {
				System.out.println(coin[i]+" 원="+(num/coin[i]));
				remain = num%coin[i];
			}
			else if(remain>0) {
				System.out.println(coin[i]+" 원="+(num/coin[i]));
			}
		}

	}
	
	public void start() {
		
		Scanner kb = new Scanner(System.in);
		System.out.print("금액을 입력하세요? ");
		int money = kb.nextInt();
		
		int a = change(num);

	}
	
	
	
	
	
	public static void main(String[] args) {

		
		
	}

}
