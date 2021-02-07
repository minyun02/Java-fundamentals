import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("드라이브 로딩 에러발샐-->"+ e.getMessage());
		}
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##scott";
	String userpwd = "tiger";
	
	public DBConn() {
		
	}
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url, username, userpwd);
		}catch(Exception e) {
			System.out.println("DB연결에러 발생-->"+ e.getMessage());
		}
	}
	public void dbClose( ) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			System.out.println("DB종료 에러발생");
		}
	}
	
}
