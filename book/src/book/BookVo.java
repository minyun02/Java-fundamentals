package book;

public class BookVo {
	private int bookNo;
	private String bookName;
	private String bookCom;
	private String author;
	private String bookRent;
	
	public BookVo() {}
	public BookVo(int bookNo, String bookName, String bookCom, String author, String bookRent) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookCom = bookCom;
		this.author = author;
		this.bookRent = bookRent;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCom() {
		return bookCom;
	}
	public void setBookCom(String bookCom) {
		this.bookCom = bookCom;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookRent() {
		return bookRent;
	}
	public void setBookRent(String bookRent) {
		this.bookRent = bookRent;
	}
	
	
}
