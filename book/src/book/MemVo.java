package book;

public class MemVo {
	private int memNo;
	private String memName;
	private String tel;
	private String addr;
	private String joinedDate;
	
	public MemVo() {}
	public MemVo(int memNo, String memName, String tel, String addr, String joinedDate ) {
		this.memNo = memNo;
		this.memName = memName;
		this.tel = tel;
		this.addr = addr;
		this.joinedDate = joinedDate;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
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
	public String getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	
	
}
