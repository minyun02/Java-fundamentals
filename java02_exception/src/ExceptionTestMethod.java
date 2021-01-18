
public class ExceptionTestMethod {

	public ExceptionTestMethod() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException{  //2번째 실행 생성자 메소드 
		method1(); // 3번째 실행  9번째   
	}
	public void method1() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException{  //4번째 실행 
		int a = 100, b = 10;
		int c = a/b; // b = 0, arithmatic 에러 발생 
		System.out.println("c="+c);
		method2();  // 8번째 
	}
	public void method2() throws NumberFormatException, ArrayIndexOutOfBoundsException{  //5번째 실행 
		String numStr = "12";
		int num = Integer.parseInt(numStr); //parsing 하면서 문자 데이터 때문에 오류: NumberFormatException
		System.out.println("num="+num);
		method3();  // 7번째 
	}
	public void method3() throws ArrayIndexOutOfBoundsException {  // 6번째 실행 
		int num[] = {10, 20, 30};
		System.out.println(num[num.length]);
		
	}
	
	
	
	
	public static void main(String args[]) {
		try {
			new ExceptionTestMethod(); // 1번째 실행   
		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없습니다..."+ae.getMessage());  
	
		}catch(NumberFormatException nf) {
			System.out.println("문자는 숫자로 바꿀 수 없습니다..."+nf.getMessage());
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열의 첨자값을 잘못 입력하였습니... "+ae.getMessage());
			ae.printStackTrace();
		}
		System.out.println("프로그램 종료...");  // try ~ catch 사용 전 10번쨰 실행부  
	} 	
}
