import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
	//1. 드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("드라이브로딩 에러 발생");
		}
	}
	Connection conn = null;
	PreparedStatement pstmt=null;
	
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String url = "jdbc:oracle:thin:@localhost:51521:xe";
//	String username = "c##scott";
	String username = "SCOTT";
	String userpwd = "tiger";
	
	public SelectTest() {
		
	}
	public void recordSelect() {
		try {
			//데이터베이스에 연결하기 
			conn = DriverManager.getConnection(url, username, userpwd);
			
			//쿼리문을 먼저 만든다 
			String sql = "select num, username, tel, email,  writedate, addr from member  "
					+ " order by num asc";
			pstmt = conn.prepareStatement(sql);
			//불러온 데이터는 rs에 담긴다.
			ResultSet rs = pstmt.executeQuery();
			
			//rs객체에서 point이동으로 record 정보를 얻어온다.
			while(rs.next()) {
				int num = rs.getInt(1); //rs.getInt("num");
				String username = rs.getString(2); //rs.getString("username");
				String tel = rs.getString(3);
				String email = rs.getString(4);
				String writedate = rs.getString(5);
				String addr = rs.getString(6);
				System.out.printf("%d, %s, %s, %s, %s, %s\n", num, username, tel, email, writedate, addr);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SelectTest().recordSelect();

	}

}
