import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

	public ExceptionEx() {

	}

	// 에러가 발생할 것 같은 곳을 찾아보기 
	public void start() {
		// 한 블록 안에서 예외 여러번 나오면 try-catch문을  3번 써야하는가 ..? nono >catch만 반복해서 사용 
		Scanner scan = new Scanner(System.in);
		do {
			try {
	
				System.out.print("첫번째 수? "); // InputMismatchException 
				//int num1 = scan.nextInt();
				// 콘솔의 문자열 1주을 입력받는
				int num1 = Integer.parseInt(scan.nextLine());
				System.out.print("두번째 수? "); // InputMismatch
				int num2 = Integer.parseInt(scan.nextLine());	//만약 문자를 입력받으면 java.lang.NumberFormatException이 발생함 
		
				int result = num1*num2;
				int result2 = num1/num2; // 0으로 나누기..컴퓨터는 0을 나눌 수 없다 ArithmeticException 
		
				System.out.println(num1+"*"+num2+"="+result);
		
				System.out.printf("%d/%d=%d\n", num1, num2, result2);
				
				String names[] = {"새종대왕", "아순신"};
				for(int i=0; i<=names.length; i++) { //배열 index, ArrayIndexOutOfBoundsException
					System.out.println("name["+i+"]= "+names[i]);
				}
			}//catch(InputMismatchException ime) {
			 //	System.out.println("숫자만 입력하세요..");
			catch(NumberFormatException nfe) {
				System.out.println("숫자만 입력하세요...");
			}catch(ArithmeticException ae) {
				System.out.println("두번째 숫자를 0 이외의 값을 입력하세요...");
			}catch(ArrayIndexOutOfBoundsException ai) {
				System.out.println("배열의 index를 잘못 사용하였습니다.."+ai.getMessage());
			}
		}while(true);	
		
	}
	
	
	
	
	
	
	
	public static void main(String a[]) {
		new ExceptionEx().start();
	}
}
