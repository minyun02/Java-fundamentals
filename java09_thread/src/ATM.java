
public class ATM implements Runnable{
	private int money = 20000; //통장잔액 
	public ATM() {
		
	}
	//Thread 처리 - 출금 
	//synchronized : 스레드의 동기화(스레드가 구현되는 동안 다른 스레드는 대기) -> 2가지 방법
	//1. run() 메소드에 반환형 왼쪽에 synchronized키를 추가한다. 
	public void run() {
		//2. run() 메소드 실행부에 동기화 처리
		synchronized(this) {
			for(int i=1; i<=10; i++) {
				getCash(1000);
				//동기화 및 동기화 해제
				if(money%2000==0) {
					//동기화 해제 
					try {	
						this.wait();
					}catch(InterruptedException ie) {}
				}else {
					//동기화 
					this.notify();
				}
			}
		}
	}
	//출금처리 메소드 
	public void getCash(int cash) {
		if(money>0) {
			money-=cash;
			System.out.println(Thread.currentThread().getName()+", 잔액="+ money);
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread t1 = new Thread(atm, "mother"); 
		Thread t2 = new Thread(atm, "son");
		
		t1.start();
		t2.start();
	}

}
