import java.util.Scanner;

public class ExceptionEx02 {
	Scanner scan = new Scanner(System.in);
	
	public ExceptionEx02() {
		
	}
	
	public void start() {
		
		try {
			System.out.print("첫번째 수? "); // InputMismatchException 
			// 콘솔의 문자열 1줄을 입력받는
			int num1 = Integer.parseInt(scan.nextLine());
			System.out.print("두번째 수? "); // InputMismatch
			int num2 = Integer.parseInt(scan.nextLine());	//만약 문자를 입력받으면 java.lang.NumberFormatException이 발생함 !!! 
	
			int result = num1*num2;
			int result2 = num1/num2; // 0으로 나누기..컴퓨터는 0을 나눌 수 없다 ArithmeticException !!!
			// !!!가 하는 예외처리는 같음 
			System.out.println(num1+"*"+num2+"="+result);
	
			System.out.printf("%d/%d=%d\n", num1, num2, result2);
			
			String names[] = {"새종대왕", "아순신"};
			for(int i=0; i<=names.length; i++) { //배열 index, ArrayIndexOutOfBoundsException
				System.out.println("name["+i+"]= "+names[i]);
			}
		}catch(ArrayIndexOutOfBoundsException aoe) {
			System.out.println("배열에서 예외 발생....");
			
		}catch(Exception e) {
			System.out.println("0을 제외한 정수를 입력... >"+e.getMessage());
		}
	}

	public static void main(String[] args) {
		new ExceptionEx02().start();

	}

}
