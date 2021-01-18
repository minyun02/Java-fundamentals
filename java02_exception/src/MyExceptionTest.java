import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	
	public MyExceptionTest() {
		try {
			System.out.print("1~10까지의 정수를 입력 > ");
			int data = scan.nextInt(); //InputMismatchException ...
			if(data<1 || data>10) {
				//throw new MyException(); //강제예외 발생 : throw
				throw new MyException("1 ~ 10까지 정수가 아닙니다..."); // MyException 출력문구가 달라짐 
			}else {
				sum(data); // 정상처리 
			}
		}catch(MyException e) {
			e.printStackTrace();
		}
	}
	
	public void sum(int m) {
		int s = 0;
		for(int i=1; i<m; i++) {
			s += i;
		}
		System.out.println("s > "+s);
	}

	

	public static void main(String[] args) {
		new MyExceptionTest();
	}

}
