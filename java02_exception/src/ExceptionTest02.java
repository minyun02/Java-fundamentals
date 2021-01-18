// try ~ catch ~ finally, 에러처리 방법과 에러 발생 유무와 상관없이 무조건 실행하는 방법 

public class ExceptionTest02 {

	public ExceptionTest02() {
		
		try {
			//실행부 
			int data[] = {10, 8, 44, 64, 33};
			// System.out.println(data[data.length]); // ArrayIndextOutOfBounds
			System.out.println(data[data.length-1]);
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열의 index를 잘못 사용하였습니다... > "+ae.getMessage());
		}finally {
			System.out.println("finally 무조건 한 번은 실행됨");
		}

	}

	
	
	
	public static void main(String[] args) {
		new ExceptionTest02();
		
	}

}
