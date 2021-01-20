package plus;

public class member {
	
	private int memberNo;
	private String memberName;
	private String memberBd;
	private String memberPh;
	private String memberAd;
	
	public member() {	}
	
	public member(int memberNo, String memberName, String memberBd, String memberPh, String memberAd) {
		
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberBd = memberBd;
		this.memberPh = memberPh;
		this.memberAd = memberAd;
		
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBd() {
		return memberBd;
	}

	public void setMemberBd(String memberBd) {
		this.memberBd = memberBd;
	}

	public String getMemberPh() {
		return memberPh;
	}

	public void setMemberPh(String memberPh) {
		this.memberPh = memberPh;
	}

	public String getMemberAd() {
		return memberAd;
	}

	public void setMemberAd(String memberAd) {
		this.memberAd = memberAd;
	}

	
	
	
	
}
