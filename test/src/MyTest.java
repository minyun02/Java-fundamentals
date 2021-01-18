import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import test.LoginDataSet;
import test.LoginVo;
////////테스트용//////
//주석을 이렇게 넣는데 왜 변화가 없
public class MyTest {
	Scanner scan = new Scanner(System.in);
	public MyTest() {
		
	}
	public void start() {
		
		String newid = conInput("등록할 아이디?");
		String newpwd = "";
		//LoginVo vo = new LoginVo();
		if(!LoginDataSet.loginList.containsKey(newid)) {
			//vo.setId(newid);
			newpwd = conInput("비밀번호 설정해");
		}
		//vo.setPwd(newpwd);
		
		LoginDataSet.loginList.put(newid, new LoginVo(newid, newpwd));
		
		outPut();
		
		logIn();
		
	}
	public void outPut() {
		Set<String> keyList = LoginDataSet.loginList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext() ) {
			LoginVo vo = LoginDataSet.loginList.get(ii.next());
			System.out.printf("%s\t%s\n",vo.getId(), vo.getPwd());
		}
	}
	public void logIn() {
		String tryid = conInput("아이디");
		String trypwd = "";
		if(LoginDataSet.loginList.containsKey(tryid)) {
			trypwd = conInput("비밀번호");
			if(LoginDataSet.loginList.containsKey(trypwd)) {
				System.out.println("로그인성공");
			}else {
				System.out.println("로그인 실패");
			}
		}
	}
	public String conInput(String msg) {
		System.out.println(msg+"=");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		new MyTest().start();
		System.out.println("프로그램이 종료되었습니다..");
	}

}
