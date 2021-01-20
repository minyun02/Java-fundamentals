
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


import plus.bookDataSet;
import plus.bookLogin;
import plus.bookVO;
import plus.member;
import plus.memberDataSet;

public class BookMainver3 {
	Scanner sc = new Scanner(System.in);
	boolean isTrue;
	
	public BookMainver3() {	}
	
	public void start() {
		
		
		
		
		
		do {
				String mene4 = conInput("안녕하세요! 블레어 도서관 입니다. 모드를 선택하여 주세요.\n (1 : 회원 모드 2 : 관리자 모드  3: 종료) \n"); 
				if(mene4.equals("2")) {	
					
					bookLogin.id = conInput("관리자 아이디");
					bookLogin.pwd=conInput("관리자 비밀번호");
					
					if(bookLogin.loginCheck()) {
						
						System.out.println("로그인 성공");
						
						
					
						do {
							String mene3 = conInput("\n회원 정보 확인 & 책 목록 확인 (회원정보 : 1  / 책목록 : 2  / 돌아가기 : 3 ) \n"); 
								if(mene3.equals("2")) {
									bookDataSet.setbookList();
										
									do {
										String menu = conInput("\n메뉴 [1. 전체목록 , 2, 도서 대출 3, 도서 등록, 4, 도서 수정, \n     "
												+ " 5, 도서 삭제, 6, 목록으로 돌아가기 ] \n");
								
										if (menu.equals("6")) {
											break;
										}else if (menu.equals("2")) {
											bookable();
											bookOutput();
										}else if (menu.equals("3")) {
											bookInsert();
										}else if (menu.equals("4")) {
											bookEdit();
										}else if (menu.equals("5")) {
											bookDel();
										}else if (menu.equals("1")) {
											bookOutput();
											}
									}while(true);
										
								}else if(mene3.equals("1")) {
								
									memberDataSet.setmemList();
									
									do {
										String mene2 = conInput ("\n메뉴 [1. 회원목록 , 2. 회원등록 ,3. 회원 수정 , 4. 회원삭제 , 5. 목록으로 돌아가기]");						
										if(mene2.equals("5")){
											break;
										}else if (mene2.equals("2")){
											memInsert();
											memOutput();
										}else if (mene2.equals("3")){
											memEdit();
										}else if (mene2.equals("4")){
											memDel();
											memOutput();
										}else 
											memOutput();
										
										}while(true);
										
									
								}else if (mene3.equals("3")) {
									break;
									}
										
							
									
								
							}while(true);
					
					}else {
						System.out.println("관리자 정보가 일치하지 않습니다.");
				}
		}else if(mene4.equals("1")) {
			
			memberDataSet.setmemList();
			bookDataSet.setbookList();
			
			do {
				String mene5 = conInput ("\n메뉴 [1. 도서목록 , 2. 회원목록 ,3. 회원 등록 , 4. 목록으로 돌아가기]");
				if(mene5.equals("4")) {
					break;
				}else if (mene5.equals("2")) {
					memOutput();
				}else if (mene5.equals("3")) {
					memInsert();
					memOutput();
				}else
					bookOutput();
				
			}while(true);
			
			
			
		}else if (mene4.equals("3"))
			break;
	}while(true);
		
	}

	////////////////////////////////////////////////////////
	public void bookDel() {
		System.out.println("");
		System.out.println(">> 도서 삭제 <<\n");
		String bookName = conInput("삭제할 책 이름");
		bookDataSet.bookList.remove(bookName);
	}
	
	
	
	
	public void memDel() {
		
		String memName = conInput("삭제할 회원 이름");
		
		Set<Integer> keySet = memberDataSet.memList.keySet();
		Iterator<Integer> i = keySet.iterator();
		
		
		while (i.hasNext()) {
			Integer key = (Integer)i.next();
//			System.out.println(key);
			member mvo = memberDataSet.memList.get(key);
//			System.out.println(mvo.getMemberName());
//			System.out.println(memName);
			if (mvo.getMemberName().equals(memName)) {
				memberDataSet.memList.remove(key);
				break;
				
//				System.out.println(mvo.getMemberName()+"====");
			}
			
		}
	}

	public void bookEdit() {
		
		System.out.println("");
		System.out.println(">> 도서 수정 <<\n");
		
		String bookName = conInput("수정할 책 이름");
		bookVO vo = bookDataSet.bookList.get(bookName);
		if (vo == null) {
			System.out.println("존재하지 않는 책 이름 입니다.");
		}else {
			String subMenu = conInput("수정할 필드를 선택 [1. 작가 , 2.출판사, 3.장르]");
		if(subMenu.equals("1")) {
			String writer =conInput("수정할 작가 이름");
			vo.setbWriter(writer);
			}else if (subMenu.equals("2")) {
				String ho =conInput("수정할 출판사명");
				vo.setbHo(ho);
			}else if (subMenu.equals("3")) {
				String ge =conInput(" 장르 변경");
				vo.setbGenre(ge);
			}
		}
	}	

	public void memEdit() {
		String memName = conInput("수정할 회원 이름");  
		
		Set<Integer> keySet =memberDataSet.memList.keySet();
		
		Iterator<Integer> i = keySet.iterator();
		
		while (i.hasNext()) {
			Integer key = (Integer)i.next();
			member mvo = memberDataSet.memList.get(key);
			
			if (mvo.getMemberName().equals(memName)) {
				
				if (key == null) {
				System.out.println("존재하지 않는 회원 입니다.");
				}else {
					String subMenu = conInput("수정할 필드를 선택 [1. 생년월일 , 2.연락처, 3.아이디]");
					if(subMenu.equals("1")) {
						String bd =conInput("수정 생년월일");
						mvo.setMemberBd(bd);
					}else if (subMenu.equals("2")) {
						String ph =conInput("수정할 연락처");
						mvo.setMemberPh(ph);
					}else if (subMenu.equals("3")) {
						String ad =conInput(" 수정할 아이디");
						mvo.setMemberAd(ad);
				}
			}	
			}
		}
	}

	public void bookable() {
		try {
				bookOutput();
				System.out.println("");
				System.out.println(">> 대여 등록 <<\n");
				String bookName = conInput("ㄴ대여할 책 이름");
				bookVO vo = bookDataSet.bookList.get(bookName);
				if (vo == null) {
					System.out.println("존재하지 않는 책 입니다.");
				}else {
					System.out.print(" 선택 [1. 대여  / 2. 반납] = > ");
					int setAble = Integer.parseInt(sc.nextLine());
					
					if (setAble ==1) {
						vo.setAble("대여불가능");
					}else if (setAble ==2) {
						vo.setAble("대여가능");
					}
				}
		}catch(Exception ee) {
			System.out.println("번호를 선택해주세요.");
		}
	}	
	////////////////////////////////////////////////
	public void bookInsert() {
		try {
			System.out.println("");
			System.out.println(">> 도서 등록 <<\n");
			int no = Integer.parseInt(conInput("ㄴ책 번호"));
			String name = conInput("ㄴ책 이름") ;
			String writer = conInput("ㄴ작가");
			String ho = conInput("ㄴ출판사");
			String ge = conInput("ㄴ장르");
			String al = conInput("ㄴ대여여부");
			bookDataSet.bookList.put(name, new bookVO(no,name,writer,ho,ge,al));
		}catch(Exception e ) {
			System.out.println("등록하실 도서의 번호를 입력해주세요. 초기메뉴로 돌아갑니다.");
		}
	}
	
	public void memInsert() {
		try {
			System.out.println("");
			System.out.println(">> 회원 등록 <<\n");
			int no = Integer.parseInt(conInput("ㄴ번호"));
			String mname = conInput("ㄴ회원 이름") ;
			String bday = conInput("ㄴ회원 생년월일");
			String numb = conInput("ㄴ회원 연락처");
			String adr = conInput("ㄴ회원 아이디");
			memberDataSet.memList.put(no, new member(no,mname,bday,numb,adr));
		}catch (Exception e){
			System.out.println("등록하실 회원의 번호를 입력해주세요. 초기메뉴로 돌아갑니다.");
		}
	}
	////////////////////////////////////////////////
	public void bookOutput() {
		System.out.println("");
		System.out.println("\t\t\t== 도서 목록 ==\t\t\n");
		System.out.println("번호\t도서 이름\t\t\t작가\t\t\t출판사\t\t도서 분야\t대여 여부\n");
		Set<String> keyList = bookDataSet.bookList.keySet();
		Iterator<String>bb =keyList.iterator();
		
		while(bb.hasNext()) {
		
			bookVO vo = bookDataSet.bookList.get(bb.next());
			
			if(vo.getbName().length() > 8 && vo.getbName().length()<=12) {
				System.out.printf("%d\t%s\t\t%s\t\t%s\t%s\t\t%s\n",
					vo.getbNo(),vo.getbName(),vo.getbWriter(),vo.getbHo(),vo.getbGenre(),vo.getAble());
			} else if (vo.getbName().length() <= 9 && vo.getbName().length() >= 4) {
				System.out.printf("%d\t%s\t\t\t%s\t\t\t%s\t\t%s\t\t%s\n",
						vo.getbNo(),vo.getbName(),vo.getbWriter(),vo.getbHo(),vo.getbGenre(),vo.getAble());
			}else if (vo.getbName().length() < 13) {
				System.out.printf("%d\t%s\t%s\t\t%s\t%s\t\t%s\n",
						vo.getbNo(),vo.getbName(),vo.getbWriter(),vo.getbHo(),vo.getbGenre(),vo.getAble());
			}else if (vo.getbName().length() <= 3 ) {
				System.out.printf("%d\t%s\t\t\t\t%s\t\t\t%s\t\t%s\t\t%s\n",
						vo.getbNo(),vo.getbName(),vo.getbWriter(),vo.getbHo(),vo.getbGenre(),vo.getAble());
			}
		}
			System.out.println("");
			System.out.println("총 도서 보유량 = >" +bookDataSet.bookList.size());
		
	}
	
	public void memOutput() {
		System.out.println("");
		System.out.println("\t\t\t== 회원 목록 ==\t\t\n");
		System.out.println("번호\t회원이름\t생년월일\t회원 번호\t\t회원 아이디\n");
		
		Set<Integer> keyList = memberDataSet.memList.keySet();
		Iterator<Integer> mm = keyList.iterator();
		
		while(mm.hasNext()) {
			member mvo = memberDataSet.memList.get(mm.next());
			System.out.printf("%d\t%s\t\t%s\t%s\t\t%s\n",
					mvo.getMemberNo(),mvo.getMemberName(),mvo.getMemberBd(),mvo.getMemberPh(),mvo.getMemberAd());
		}
		System.out.println("");
		
		
	}

	//////////////////////////////////////////////////
	public String conInput(String enter) {
		System.out.print(enter+"=>");
		return sc.nextLine();
	}

	/////////////////////////////////////////////////////
	public static void main(String[] args) {
		new BookMainver3().start();
		System.out.println("프로그램을 종료합니다.");

	}

}
