import java.sql.CallableStatement;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;

public class SelectSearchProcedure extends DBConn{

	public SelectSearchProcedure() {
		try {
			getConn();
			
			sql = "{call mem_search(?,?)}";
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, "naver");
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			stmt.executeQuery();
			rs = (ResultSet)stmt.getObject(2);
			while(rs.next()) {
				System.out.printf("%d, %s, %s, %s, %s, %s\n",
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new SelectSearchProcedure();

	}

}
