import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest01 {

	public ExceptionTest01() {
		//예외처리하기 
		try {	//try {}안의 정의되어있는 코드들은 지역변수가 된다, 에러가 없다면 catch 블록 밖의 것을 실행하고 종료 
			// 예외발생가능한 코드와 예외발생가능성이 없는 코드 두 개  명시 가능 
			Scanner scan = new Scanner(System.in);
			System.out.print("정수를 입력하세요... ");
			int n = scan.nextInt(); // Integar.parse(int)..
			// 만약 사용자가 정수가 아닌 다른 것을 입력하면 런타임 오류 가능성이 있다. InputMismatchException.. 
			System.out.println("n= "+n);
		}catch(InputMismatchException ime) {	// InputMismatchException..해결을 위한 조건을 ()에 입력, ime 안에 scan.nextInt()에러를 담음.
			//try 영역의 코드가 예외가 발생하면 실행 될 영역 
			// error 발생 시, 실행 할 코드 입력부분 
			ime.printStackTrace(); // =에러 메시지 종류와, 에러 발생 위치 표시됨 
			
			//System.out.println(ime.getMessage());	=에러발생확인 
			//System.out.println("숫자를 잘못 입력하였습니다..");
			
		}
		//System.out.println("프로그램이 종료되었습니다...");
	}

	public static void main(String a[]) {
		new ExceptionTest01();
	}
}
