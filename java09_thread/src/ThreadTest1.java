

//1. Thread 클래스 상
public class ThreadTest1 extends Thread{
	String title;
	public ThreadTest1(String title) {
		this.title = title;
	}
	public void ThreadTest1() {
	//2. run()메소드 오버라이딩	
	}
	public void run() {
		for(int i=1;;i++) {
			System.out.println(title+ "="+ i);
			try {Thread.sleep(500);}catch(Exception e) {}
		}
	}
	//main메소드도 사실을 스레드 1개로 돌아가는거 -> tt1,tt2까지 총 스레드 3개
	public static void main(String[] args) {
		ThreadTest1 tt1 = new ThreadTest1("첫번째 스레드");
		ThreadTest1 tt2 = new ThreadTest1("두번째 스레드");
		//3.Thread 등록
		tt1.start();
		tt2.start();
	}

}
