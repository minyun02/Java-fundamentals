package emp;

import java.util.HashMap;
// 원래는 DB에서 만들어줘야하는데, 아직 안 배워서 여기다 임의의 데이터를 설정해줌
public class EmpDataSet {

	public static HashMap<String, EmpVO> empList = new HashMap<String, EmpVO>();
	// List는 interface라서 객체로 못 만들어서 HashMap으로 바꿈
	public EmpDataSet() {}
	
	public static void setEmpList() {
		empList.put("홍길동", new EmpVO(1, "홍길동", "02-1234-1111", "총무부", "과장"));
		empList.put("강감찬", new EmpVO(3, "강감찬", "02-5689-7784", "기획부", "대리"));
		empList.put("유승룡", new EmpVO(5, "유승룡", "02-1234-7894", "총무부", "사원"));
		empList.put("이순신", new EmpVO(2, "이순신", "02-4445-7854", "인사부", "사원"));
		empList.put("장영실", new EmpVO(4, "장영실", "02-1148-7778", "영업부", "부장"));
		
	}
}
