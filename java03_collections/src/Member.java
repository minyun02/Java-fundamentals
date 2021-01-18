
//VO = Value Object, VO 클래스
//DTO = Data Type Object, DTO 클래스 
// public class MemberVO .. 
public class Member {
	
	//getter setter를 위해서 전역변수를 캡슐화 하기
	private int no=1234;
	private String username="세종대왕";
	/* String userName = "세종대왕";
	 * public String getUserName () { return userName };
	 * 
	 */
	private String tel="010-4578-4577";
	private String addr="서울시 마포구 백범로";
	
	public Member() {
	
	}
	
	public Member(int no, String username, String tel, String addr) {
		this.no=no;
		this.username=username;
		this.tel=tel;
		this.addr=addr;
	}
	
	public void memberPrn() {
		System.out.printf("%d, %s, %s, %s\n",no,username,tel,addr);
	}
	
	//getter, setter 만들기 .. 보통 변수마다 다 만듬
	public int getNo() {  // =getter, 외부에서 
		return no; // Member no return
		
	}
	
	public void setNo(int no) {  // =setter, 외부에서 정보를 받아서 내부 데이터 변경
		this.no = no;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
