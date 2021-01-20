package plus;



import java.util.TreeMap;




public class bookDataSet {
	public static TreeMap<String,bookVO> bookList = new TreeMap <String, bookVO>();
	
	
	public bookDataSet() {
		
	}
	public static void setbookList() {
		bookList.put("마법사의 돌", new bookVO(1,"해리포터와 마법사의 돌","조앤 K 롤링", "문학수첩", "판타지" ,"대여가능" ));
		bookList.put("비밀의 방", new bookVO(2,"해리포터와 비밀의 방","조앤 K 롤링", "문학수첩", "판타지", "대여가능" ));
		bookList.put("아즈카반의 죄수", new bookVO(3,"해리포터와 아즈카반의 죄수","조앤 K 롤링", "문학수첩", "판타지","대여가능"  ));
		bookList.put("불의 잔", new bookVO(4,"해리포터와 불의 잔","조앤 K 롤링", "문학수첩", "판타지","대여가능"  ));
		bookList.put("불사조 기사단", new bookVO(5,"해리포터와 불사조기사단","조앤 K 롤링", "문학수첩", "판타지","대여가능"));
		bookList.put("혼혈왕자", new bookVO(6,"해리포터와 혼혈왕자","조앤 K 롤링", "문학수첩", "판타지","대여가능" ));
		bookList.put("죽음의 성물", new bookVO(7,"해리포터와 죽음의 성물","조앤 K 롤링", "문학수첩", "판타지","대여가능"  ));
		bookList.put("저주받은 아이", new bookVO(8,"해리포터와 저주받은아이","조앤 K 롤링", "문학수첩", "판타지","대여가능"  ));
		bookList.put("테오", new bookVO (9,"양말괴물 테오", "유태오", "STORY.B", "동화", "대여가능"));
		bookList.put("빛이라면",new bookVO(10,"당신이 빛이라면", "백가희","쿵", "시", "대여가능") );
		bookList.put("간격의미",new bookVO(11,"간격의 미", "백가희", "쿵", "시", "대여가능") );
		bookList.put("누리야",new bookVO(12,"누리야 누리야", "양귀자", "쓰다", "동화", "대여가능") );

		
//		무엇이 문제인가??? 
	}

	

}
