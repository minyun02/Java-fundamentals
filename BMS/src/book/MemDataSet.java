package book;
//////테스트용
import java.util.HashMap;

public class MemDataSet {
	public static HashMap<String, MemVo> memList = new HashMap<String, MemVo>();
	public MemDataSet() {
		
	}
	public static void setMemList() {
		memList.put("홍길동", new MemVo(1, "홍길동", "010-1111-2222", "종로구", "2020.12.14"));
		memList.put("김세종", new MemVo(2, "김세종", "010-2222-3333", "마포구", "2021.01.02"));
	}

}
