
public class UpdateTest extends DBConn{

	public UpdateTest() {
		
	}
	public void setUpdate() {
		try {
			getConn();
			
			sql = "update member set tel=? where username=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "010-5555-5555");
			pstmt.setString(2, "장영실");
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+"개의 레코드가 수정되었습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(); //데이터베이스 종료위치는 예외가 생기거나 생기지 않아도 실행되어야 하기 때문에 finally안에 위치.
		}
	}
	public static void main(String[] args) {
		new UpdateTest().setUpdate();

	}

}
