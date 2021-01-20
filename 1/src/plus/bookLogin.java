package plus;

public class bookLogin {
	
	public static String id;
	public static String pwd;

	public bookLogin() {
		
	}

	public static boolean loginCheck() {
		
		if(id == "" || pwd== "" ) {
			System.out.print("관리자 아이디와 비밀번호를 입력하세요");
			return false;
		}else {
			if(id.equals("123") && pwd.equals("123")) {
				return true;
			}else {
				return false;
			}
		}
			
		
	}
	
}
