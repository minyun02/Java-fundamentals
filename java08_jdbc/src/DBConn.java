import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//JDBC드라이브 로딩과 연결하는 부분을 매번 적어주기 보다는 클래스를 만들어서
//앞으로 상속을 받아 작업한다.

public class DBConn {
	//1. 드라이브로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("드라이브 로딩 에러발생-->"+ e.getMessage());
		}
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = null;
	
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String url = "jdbc:oracle:thin:@localhost:51521:xe";
//	String username = "c##scott";
	String username = "SCOTT";
	String userpwd = "tiger";
	
	public DBConn() {
		
	}
	//DB연결 
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url, username, userpwd);
		}catch(Exception e) {
			System.out.println("DB연결에러 발생-->"+ e.getMessage());
		}
	}
	//DB접속 종료
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			System.out.println("DB종료 에러발생");
		}
	}
}
