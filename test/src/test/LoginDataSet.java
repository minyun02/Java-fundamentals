package test;

import java.util.HashMap;

public class LoginDataSet {
	public static HashMap<String, LoginVo> loginList = new HashMap<>();
	public LoginDataSet() {
		
	}
	public static void setLoginList() {
		loginList.put("master", new LoginVo("master", "1234"));
	}
}
