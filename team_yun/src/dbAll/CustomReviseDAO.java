package dbAll;

import java.util.ArrayList;
import java.util.List;

public class CustomReviseDAO extends DBConn{

	public CustomReviseDAO() {}
	
	// 회원 정보 수정
	public int ReviseUpdate(String user_id, CustomReviseVO vo) {
		int result = 0;
		String name_kor = vo.getName_kor();
		String name_eng = vo.getName_eng();
		String user_pwd = vo.getUser_pwd();
		String user_tel = vo.getUser_tel();
		String user_birth = vo.getUser_birth();
		String nationality = vo.getNationality();
		String user_email = vo.getUser_email();
		
		List<CustomReviseVO> lst = blankCheck(user_id);
		for(int i=0; i<lst.size();i++) {
			CustomReviseVO pastVo = new CustomReviseVO();
			
			if(name_kor.equals("")) {
				name_kor = pastVo.getName_kor();
			} else if(vo.getName_eng().equals("")) {
				name_eng = pastVo.getName_eng();
			} else if(vo.getUser_pwd().equals("")) {
				user_pwd = pastVo.getUser_pwd();
			} else if(vo.getUser_tel().equals("")) {
				user_tel = pastVo.getUser_tel();
			} else if(vo.getUser_birth().equals("")) {
				user_birth = pastVo.getUser_birth();
			} else if(vo.getNationality().equals("")) {
				nationality = pastVo.getNationality();
			} else if(vo.getUser_email().equals("")) {
				user_email = pastVo.getUser_email();
			}
		}
		
		try {
			getConn();
			sql = "update ac_user set name_kor=?,name_eng=?,user_pwd=?,user_tel=?,user_birth=?,nationality=?,user_email=? where user_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name_kor);
			pstmt.setString(2, name_eng);
			pstmt.setString(3, user_pwd);
			pstmt.setString(4, user_tel);
			pstmt.setString(5, user_birth);
			pstmt.setString(6, nationality);
			pstmt.setString(7, user_email);
			pstmt.setString(8, user_id);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return result;
	}
	
	public List<CustomReviseVO> blankCheck(String user_id) {
		List<CustomReviseVO> result = new ArrayList<CustomReviseVO>();
		try {
			getConn();
			sql = "select name_kor, name_eng, user_pwd, user_tel, user_birth, nationality, user_email from ac_user where user_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomReviseVO vo = new CustomReviseVO();
				vo.setName_kor(rs.getString(1));
				vo.setName_eng(rs.getString(2));
				vo.setUser_pwd(rs.getString(3));
				vo.setUser_tel(rs.getString(4));
				vo.setUser_birth(rs.getString(5));
				vo.setNationality(rs.getString(6));
				vo.setUser_email(rs.getString(7));
				
				result.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return result;
	}

}
