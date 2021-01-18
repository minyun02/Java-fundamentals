import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import book.BookDataSet;
import book.BookVo;
import book.Login;
import book.MemDataSet;
import book.MemVo;
//////테스트용

public class BookMain {
	static Scanner scan = new Scanner(System.in);
	public BookMain() {
		
	}
	public void start() {
		//Login========================================
		Login.id = conInput("아이디");
		Login.pwd = conInput("비밀번호");
		if(Login.loginCheck()) {
			MemDataSet.setMemList();
			BookDataSet.setBookList();
			do {
				String mainMenu = conInput("메인메뉴 [1.회원관리 2.도서관리 3.프로그램 종료]");
				if(mainMenu.equals("3")) {
					break;
				}else if(mainMenu.equals("1")) {
					memAdmin();
				}else if(mainMenu.equals("2")) {
					bookAdmin();
				}
			}while(true);
		
		}else {
			System.out.println("로그인 실패");
		}
		
	}
	//				회원관리기능 =====================================
	public void memAdmin() {
		do {
			String memMenu =conInput("메뉴 [1.회원전체목록 2. 회원등록 3.회원정보수정 4.회원삭제 5.메인메뉴]");
			if(memMenu.equals("5")) {
				break;
			}else if(memMenu.equals("2")) {
				memInsert();
			}else if(memMenu.equals("3")) {
				memEdit();
			}else if(memMenu.equals("4")) {
				memDel();
			}
			memOutput();
		}while(true);
	}
	//				1.회원등록=======================================
	private void memInsert() {
		int no = Integer.parseInt(conInput("회원번호"));
		String name = conInput("이름");
		String tel = conInput("연락처");
		String addr = conInput("주소");
		String joinedDate = conInput("가입날짜");
		
		MemDataSet.memList.put(name, new MemVo(no, name, tel, addr, joinedDate));
	}
	//				2.회원정보수정====================================
	public void memEdit() {
		
		String name = conInput("수정할 회원명");
		
		MemVo mvo = MemDataSet.memList.get(name);
		if(mvo==null) {
			System.out.println("존재하지 않는 회원명입니다.");
		}else {
			String subMenu = conInput("수정할 필드 선택 [1.이름 2.연락처 3.주소 4.가입날짜");
			if(subMenu.equals("1")) {
				String memName = conInput("변경할 이름");
				mvo.setMemName(memName);
			}else if(subMenu.equals("2")) {
				String tel = conInput("수정할 연락처");
				mvo.setTel(tel);
			}else if(subMenu.equals("3")) {
				String addr = conInput("수정할 주소");
				mvo.setAddr(addr);
			}else if(subMenu.equals("4")) {
				String jDate = conInput("수정할 가입날짜");
				mvo.setJoinedDate(jDate);
			}
		}
	}
	//				3.회원전체목록====================================
	public void memOutput() {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("|\t회원번호\t이름\t연락처\t\t주소\t\t가입날짜\t\t\t|");
		System.out.println("---------------------------------------------------------------------------------");
		
		Set<String> keyList = MemDataSet.memList.keySet();
		Iterator<String> i = keyList.iterator();
			while(i.hasNext()) {
				MemVo mvo = MemDataSet.memList.get(i.next());
				System.out.printf("|\t%d\t%s\t%s\t%s\t\t%s\t\t|\n", mvo.getMemNo(), mvo.getMemName(), 
						mvo.getTel(), mvo.getAddr(), mvo.getJoinedDate());
			}
		System.out.println("---------------------------------------------------------------------------------");
	}
	//				4.회원삭제====================================
	private void memDel() {
		String memName = conInput("삭제할 회원명");
		MemDataSet.memList.remove(memName);
	}
	
	
	//				도서관리기능 =====================================
	public void bookAdmin() {
		do {
			String memMenu =conInput("메뉴 [1.도서전체목록 2. 도서등록 3.도서정보수정 4.도서정보삭제 5.대여상태수정 6.메인메뉴]");
			if(memMenu.equals("6")) {
				break;
			}else if(memMenu.equals("2")) {
				bookInsert();
			}else if(memMenu.equals("3")) {
				bookEdit();
			}else if(memMenu.equals("4")) {
				bookDel();
			}else if(memMenu.equals("5")) {
				bookRent();
			}
			bookOutput();
		}while(true);
	}
	//				1.도서전체목록====================================
	public void bookOutput() {
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t회원번호\t제목\t출판사\t저자\t\t대여상태\t|");
		System.out.println("---------------------------------------------------------");

		Set<String> keyList = BookDataSet.bookList.keySet();
		Iterator<String> ii = keyList.iterator();
			while(ii.hasNext()) {
				BookVo bvo = BookDataSet.bookList.get(ii.next());
				System.out.printf("|\t%d\t%s\t%s\t%s\t\t%s\t|\n", bvo.getBookNo(),
						bvo.getBookName(), bvo.getBookCom(), bvo.getAuthor(),
						bvo.getBookRent());
			}
		System.out.println("---------------------------------------------------------");
	}
	//				2.도서등록======================================
	private void bookInsert() {
		int bookNo = Integer.parseInt(conInput("도서번호"));
		String bookName = conInput("도서제목");
		String bookCom = conInput("출판사");
		String author = conInput("저자");
		String bookRent = conInput("대여상태");
		
		BookDataSet.bookList.put(bookName, new BookVo(bookNo, bookName, bookCom,
				author, bookRent));
	}
	//				3.도서정보수정====================================
	private void bookEdit() {
		String bookName = conInput("수정할 도서명");
		
		BookVo bvo = BookDataSet.bookList.get(bookName);
		if(bvo==null) {
			System.out.println("도서명을 찾을 수 없습니다.");
		}else {
			String subMenu = conInput("수정할 필드 선택[1.도서명 2.출판사 3.저자]");
			if(subMenu.equals("1")) {
				String title = conInput("수정할 제목");
				bvo.setBookName(title);
			}else if(subMenu.equals("2")) {
				String bookCom = conInput("수정할 출판사 이름");
				bvo.setBookCom(bookCom);
			}else if(subMenu.equals("3")) {
				String author = conInput("수정할 저자명");
				bvo.setAuthor(author);
			}
		}
	}
	//				4.도서정보삭제====================================
	private void bookDel() {
		String bookName = conInput("삭제할 도서명");
		BookDataSet.bookList.remove(bookName);
	}
	//				4.대여상태수정======================================
	private void bookRent() {
		
		String bookName = conInput("도서명");
		
		BookVo bvo = BookDataSet.bookList.get(bookName);
		if(bvo==null) {
			System.out.println("도서명을 찾을 수 없습니다.");
		}else {
			String subMenu = conInput("1. 대여가능 2. 대여불가능");
			if(subMenu.equals("1")) {
				bvo.setBookRent("대여가능");
			}else if(subMenu.equals("2")) {
				bvo.setBookRent("대여불가능");
			}
		}
	}
	//입력부분========================================
	public String conInput(String msg) {
		System.out.print(msg+"=");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		new BookMain().start();
		System.out.println("프로그램이 종료되었습니다.");
	}

}
