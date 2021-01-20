package plus;



import java.util.Set;
import java.util.TreeMap;

public class memberDataSet {
	public static TreeMap<Integer,member> memList = new TreeMap<Integer,member>();
	
	public memberDataSet() {
	}
	public static void setmemList() {

		memList.put(33,new member(33,"비회원","00/00/00","00-0000-0000", "가나다"));
		memList.put(11,new member(11, "해리" , "11/11/11", "02-2222-2222", "가나가"));
		memList.put(99,new member(99,"제비","92/08/01","02-1111-1111", "가나다"));
		memList.put(22,new member(22,"헬모니","80/09/01","02-2222-2222", "가나미"));
		memList.put(33,new member(33,"위즐리","80/01/09","02-3333-3333", "가나라"));
		memList.put(44,new member(44,"시리","59/11/03","02-4444-4444", "가나구"));
		memList.put(55,new member(55,"덤비","00/07/09","02-5555-5555", "가나도"));
		memList.put(77, new member(77,"도야", "22/11/27", "010-7777-7777" , "가나라"));
		
	}
	public static Set<String> memSet(){
		
		
		return null;
	}
	
	
}

