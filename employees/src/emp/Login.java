package emp;

public class Login {
	public static String id;	// static으로 변수 선언해서 id, pwd 변수는 1개만 있으면 다 쓸 수 있다
	public static String pwd;
	
	public Login() {}

	// 로그인 체크하는 메소드 ( true: 로그인 성공, false: 로그인 실패)
	public static boolean loginCheck() { // 값이 되었을때 호출되어야함
		if(id == "" || pwd == "") { // id == null로 하면 엔터치면 공백문자가 들어가서 안뜸
			System.out.println("ID와 PASSWORD를 입력 후 로그인 하세요...");
			return false;
		}else {
			
			if(id.equals("master") && pwd.equals("1234")) {
				return true;
			}else {
				return false;
			}
		}
		
	}
}
