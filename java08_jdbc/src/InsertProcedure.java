import java.sql.CallableStatement;

public class InsertProcedure extends DBConn{

	public InsertProcedure() {
		try {
			//1. 연결
			getConn();
			//2. PreparedStatement
			//		프로시저 호출
			sql = "{call mem_insert(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "고구마");
			cstmt.setString(2, "010-9999-9999");
			cstmt.setString(3, "testtest@naver.com");
			cstmt.setString(4, "서울시 강동구");
			//3. 실행
			int r = cstmt.executeUpdate();
			if(r>0) {
				System.out.println("회원이 등록되었습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new InsertProcedure();

	}

}
