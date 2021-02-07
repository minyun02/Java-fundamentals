package dbAll;

public class CustomReviseVO {
	private String user_id;
	private String name_kor;
	private String name_eng;
	private String user_pwd;
	private String user_tel;
	private String user_birth;
	private String nationality;
	private String user_email;
	
	
	public CustomReviseVO() {}
	public CustomReviseVO(String user_id,String name_kor, String name_eng, String user_pwd, String user_tel, String user_birth, String nationality, String user_email) {
		this.user_id = user_id;
		this.name_kor = name_kor;
		this.name_eng = name_eng;
		this.user_pwd = user_pwd;
		this.user_tel = user_tel;
		this.user_birth = user_birth;
		this.nationality = nationality;
		this.user_email = user_email;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName_kor() {
		return name_kor;
	}
	public void setName_kor(String name_kor) {
		this.name_kor = name_kor;
	}
	public String getName_eng() {
		return name_eng;
	}
	public void setName_eng(String name_eng) {
		this.name_eng = name_eng;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	

}
