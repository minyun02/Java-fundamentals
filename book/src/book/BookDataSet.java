package book;

import java.util.HashMap;

public class BookDataSet {
	public static HashMap<String, BookVo> bookList = new HashMap<>();
	public BookDataSet() {
		
	}
	public static void setBookList() {
		bookList.put("자바의정석", new BookVo(1, "자바의정석", "도우출판", "남궁성", "대여가능"));
	}
}
