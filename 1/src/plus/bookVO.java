package plus;

public class bookVO {
	
	private int bNo;
	private String bName;
	private String bWriter;
	private String bHo;
	private String bGenre;
	private String able;
	
//	private boolean byesNo;

	
	public bookVO() {	}
	


//	public bookVO (int bNo,String bName, String bWriter, String bHo, String bGenre, boolean byesNo) {
	public bookVO (int bNo,String bName, String bWriter, String bHo, String bGenre, String able) {
		this.bNo = bNo;
		this.bName = bName;
		this.bWriter=bWriter;
		this.bHo = bHo;
		this.bGenre=bGenre;
		this.able=able;


		
	}













	public String getAble() {
		return able;
	}



	public void setAble(String able) {
		this.able = able;
	}



	public int getbNo() {
		return bNo;
	}


	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbHo() {
		return bHo;
	}

	public void setbHo(String bHo) {
		this.bHo = bHo;
	}

	public String getbGenre() {
		return bGenre;
	}

	public void setbGenre(String bGenre) {
		this.bGenre = bGenre;
	}





	
	
	

}
