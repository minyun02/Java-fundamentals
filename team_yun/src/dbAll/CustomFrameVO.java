package dbAll;

public class CustomFrameVO {
	private String user_id;
	private String name_kor;
	
	public CustomFrameVO() {}
	public CustomFrameVO(String user_id, String name_kor) {
		this.user_id = user_id;
		this.name_kor = name_kor;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getName_kor() {
		return name_kor;
	}
	public void setName_kor(String name_kor) {
		this.name_kor = name_kor;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
