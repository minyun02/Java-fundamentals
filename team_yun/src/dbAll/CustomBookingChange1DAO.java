package dbAll;

import java.util.ArrayList;
import java.util.List;

public class CustomBookingChange1DAO extends DBConn {

	public CustomBookingChange1DAO() {
		
	}
	public List<CustomBookingChange1VO> bookingAllSelect() {
		
		List<CustomBookingChange1VO> lst = new ArrayList<CustomBookingChange1VO>();
		try {
			getConn();  		//출발잀(날짜) 들어가야함
			sql = "";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomBookingChange1VO vo = new CustomBookingChange1VO();
			}
		}catch(Exception e) {
			System.out.println("드라이브 로딩 에러발생-->"+ e.getMessage());;
		}
		
		return lst;
	}
}
