import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DBConn{

	public MemberDAO() {
		
	}
	//레코드 전체선택
	public List<MemberVO> memberAllSelect() {
		//선택한 레코드를 보관할 컬렉션
		List<MemberVO> lst = new ArrayList<MemberVO> ();
		try {
			getConn();
			sql = "select num, username, tel, email, addr, writedate "
					+ " from member order by num asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//레코드를 VO에 담고 VO를 List에 담는 작업
				MemberVO vo = new MemberVO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				lst.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return lst;
	}
	//레코드 추가
	//레코드 수정
	//레코드 삭제
	//레코드 검색
	public List<MemberVO> getSearchRecord(String searchWord) {
		List<MemberVO> lst = new ArrayList<MemberVO> ();
		try {
			getConn();
			sql = "select num, username, tel, email, addr, writedate " 
					//															  '%홍%'		 '%99%'
					+ " from member where username like ? OR tel like ? order by num asc";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+searchWord+"%");
			pstmt.setString(2, "010-%"+searchWord+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWritedate(rs.getString(6));
				
				lst.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return lst;
	}
	
	//회원 등록 메소드
	public int memberInsert(MemberVO vo) {
		int result = 0;
		try {
			getConn();
			
			sql = "insert into member(num, username, tel, addr, email, writedate "
					+ "values(memSq.nextval, ?, ?, ? ,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getEmail());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}
}
