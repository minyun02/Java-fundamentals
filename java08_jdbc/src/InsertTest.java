import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	//2. DB연결
	//			 "oracleDB용 기본주소" ->@이후에는 오라클 데이터베이스가 있는 서버 주소-> :이후에는 포트번호 -> :xe
//			String url = "jdbc:oracle:thin:@192.168.0.16:1521:xe";
	String url = "jdbc:oracle:thin:@localhost:51521:xe";
//			String userid = "c##scott";
	String userid = "SCOTT";
	String userpwd = "tiger";
	Connection conn = null;
	
	//1. JDBC 드라이브 로딩
	//멤버영역에 실행문 사용법
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //주소를 찾아가서 oracledrive를 객체로 만들어준다
			System.out.println("JDBC 드라이브가 로딩 되었습니다.");
		}catch(Exception e) {
			System.out.println("JDBC드라이브 로딩 실패하였습니다.==>"+ e.getMessage());
		}
	}

	public InsertTest() {
		try {

			
			conn = DriverManager.getConnection(url, userid, userpwd);
			conn.setAutoCommit(false);
			InputStreamReader isr = new InputStreamReader(System.in); 
			BufferedReader br = new BufferedReader(isr); //한글자씩 가져오기 위해서 bufferedreader를 사용한다.
			
			do {
				
				System.out.print("이름=");
				String username = br.readLine();
				System.out.print("연락처=");
				String tel = br.readLine();
				System.out.print("이메일=");
				String email = br.readLine();
				System.out.print("주소");
				String addr = br.readLine();

				//3. preparedStatement를 생성, 이용해서 쿼리문을 만든다.
				//preparestatement에 들어갈 문자열
				String sql = "insert into member(num, username, tel, email, addr, writedate) "
						+ " values(memSq.nextval, ?, ?, ?, ?, sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql); //문자열을 넣으면 preparedstatement로 반환해준다.
				//? 값 세팅
				pstmt.setString(1, username); //첫번째 ?에다가 username을 세팅해라.
				pstmt.setString(2, tel);
				pstmt.setString(3, email);
				pstmt.setString(4, addr);
				
				//4.실행
				//executeQuery() -> select
				//executeUpdate() -> insert, update, delete -> 레코드의 숫자만큼 int로 return된다.
				int result = pstmt.executeUpdate();
				
//				 
//				sql = "insert into member(num, username, tel, email, addr, writedate, values(memsq.nextval, ?,?,?,? sysdate)";
//				pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setString(1, "AAAAAAA");
//				pstmt.setString(2, "010-8989-7878");
//				pstmt.setString(3, "ababab@nate.com");
//				pstmt.setString(4, "서울시 강서구");
				
//				int result2 = pstmt.executeUpdate();
				if(result >0) {
					conn.commit(); //원래는 예외발생하지만 지금은 캐치문 안에 있어서 오케이 
					System.out.println("회원등록되었습니다.");
				}
				
			}while(true);
			
		}catch(Exception e) {
			//예외 발생하면 먼저 정상실행된 쿼리실행문 취소
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new InsertTest();

	}

}
