package test;

public class LoginVo {
	private String id;
	private String pwd;
	
	public LoginVo() {}
	public LoginVo(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}

