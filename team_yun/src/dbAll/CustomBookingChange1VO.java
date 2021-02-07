package dbAll;

public class CustomBookingChange1VO {
	private String resNo;
	//출발일시 들어가야해 -> 필드에도 추가하고, 메소드에도 추가해야해
	private String flightNo;
	private String dep;
	private String dep_airport;
	private String depTime;
	private String des;
	private String des_airport;
	private String desTime;
	
	public CustomBookingChange1VO() {
		
	}
	public CustomBookingChange1VO(String resNo, String flightNo, String dep, String dep_airport, String depTime, 
			String des, String des_airport, String desTime){
		this.resNo = resNo;
		//출발일시(날짜) 들어가야해
		this.flightNo = flightNo;
		this.dep = dep;
		this.dep_airport = dep_airport;
		this.depTime = depTime;
		this.des = des;
		this.des_airport = des_airport;
		this.desTime = desTime;
	}
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getDep_airport() {
		return dep_airport;
	}
	public void setDep_airport(String dep_airport) {
		this.dep_airport = dep_airport;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getDes_airport() {
		return des_airport;
	}
	public void setDes_airport(String des_airport) {
		this.des_airport = des_airport;
	}
	public String getDesTime() {
		return desTime;
	}
	public void setDesTime(String desTime) {
		this.desTime = desTime;
	}
	
}
