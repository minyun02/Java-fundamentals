import java.sql.CallableStatement;

public class UpdateProcedure extends DBConn{

	public UpdateProcedure() {
		// 이름을 입력받아 연락처, 이메일, 주소를 수정
		try {
			getConn();
			sql = "{call mem_update(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "고구마");
			cstmt.setString(2, "010-1111-2222");
			cstmt.setString(3, "abcd@gmail.com");
			cstmt.setString(4, "서울시 서대문구");
			
			int r = cstmt.executeUpdate();
			if(r>0) {
				System.out.println("회원정보 수정 성공");
			}else {
				System.out.println("실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new UpdateProcedure();

	}

}
