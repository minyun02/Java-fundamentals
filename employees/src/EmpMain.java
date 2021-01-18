// 처음 실행하는 부분이라 root에 두는 것..
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import emp.EmpDataSet;
import emp.EmpVO;
import emp.Login;

// 로그인 정보 입력 받는 부분
public class EmpMain {
	
	Scanner scan = new Scanner(System.in);

	public EmpMain() {
		
	}
	
	public void start() {
		// 아이디와 비밀번호 입력받아 로그인 하는 부분 구현
		Login.id = conInput("ID");
		Login.pwd = conInput("PASSWORD");
		
		if(Login.loginCheck()) { // 로그인 성공 ---> 메뉴 보여주기
			System.out.println("성공");
			// 로그인 성공시의 기능구현 ...
			//초기 데이터 세팅
			EmpDataSet.setEmpList(); // 5명의 데이터를 불러옴
			do {  // 메뉴, 종료를 누를때까지 계속 반복
				String menu = conInput("메뉴 [1.사원전체목록, 2.사원등록, 3.사원수정, 4.사원삭제, 5.종료]");
				if(menu.equals("5")) {
					break;
				}else if(menu.equals("2")) {
					empInsert();
				}else if(menu.equals("3")) {
					empEdit();
				}else if(menu.equals("4")) {
					empDel();
				}
				empOutput();
			}while(true);
			
		}else { // 로그인 실패
			System.out.println("Login에 실패하였습니다.");
		}
		
		
	}
	
	//사원정보 삭제
	public void empDel() {
		String empName = conInput("삭제 할 사원의 이름");
		EmpDataSet.empList.remove(empName);
	}
	
	//사원정보 수정 (이름 제외)
	public void empEdit() {
		// 수정 할 사원을 입력, 없을 경우도 생각
		String empName = conInput("수정 할 사원의 이름");
		//해당 사원의 이름이 없을 경우..
		EmpVO vo = EmpDataSet.empList.get(empName); //바꿀 데이터의 주소값을 가져옴
		if(vo==null) {
			System.out.println("존재하지 않는 사원이름 입니다...");
		}else { // 정보가 있을때, 무엇을 고칠지?
			// 연럭처, 부서명, 직급
			do {
				String subMenu = conInput("수정 할 필드 선택 [1.연락처, 2.부서명, 3.직급, 4.수정완료]");
				if(subMenu.equals("1")) {
					String tel = conInput("수정 할 연락처");
					vo.setTel(tel);
				}else if(subMenu.equals("2")) {
					String depart = conInput("수정 할 부서명");
					vo.setDepart(depart);
				}else if(subMenu.equals("3")) {
					String position = conInput("수정 할 직급");
					vo.setPosition(position);
				}else if(subMenu.equals("4")) {
					break;
				}
			}while(true);	
			//.................. 한 번에 여러 개 수정 할 방법은 없을까?
			//.................. 잘못을 막을 방법은?
		}
		
		
	}
	
	//사원등록 메소드
	public void empInsert() {
		int no = Integer.parseInt(conInput("사원번호"));
		String name = conInput("사원이름");
		String tel = conInput("연락처");
		String depart = conInput("부서명");
		String position = conInput("직급");
		EmpDataSet.empList.put(name, new EmpVO(no, name, tel, depart, position)); // 데이터가 추가됨, empList += 새로운 정보
	}
	
	//사원전체목록 출력하는 메소드 (반복해서 출력하니까 메소드 만들어줌)
	public void empOutput() {
		//키목록을 가져옴
		Set<String> keyList = EmpDataSet.empList.keySet();
		Iterator<String> ii= keyList.iterator();
		while(ii.hasNext()) {
			EmpVO vo = EmpDataSet.empList.get(ii.next()); // emList = HashMap, empList의 value? > EmpVO를 받음
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", vo.getEmpNo(), vo.getEmpName(), vo.getTel(), vo.getDepart(), vo.getPosition());
		}
		
	}
	
	//콘솔에서 문자입력 받아 리턴하는 메소드
	public String conInput(String msg) {
		System.out.print(msg+" = ");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		new EmpMain().start();
		System.out.println("프로그램이 종료되었습니다...");
	}

}
