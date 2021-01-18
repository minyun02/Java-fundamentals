package apiClass;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	// String Class의 Split과 비교

	public StringTokenizerTest() {
		// 예시. 관심분야 여러 개 중 택1, 게임 야구 IT 택 > "게임/야구/IT" 하나의 자료로 저장, 쪼갤때 split or StringTokenizer 이용
		
		
	}
	
	public void start() {
		String hobby = "등산///쇼핑////IT/////축구,인터넷,야구"; // 배열이 아니기때문에 index number가 없다
		System.out.println(hobby);
		
		// 구분기호가 여러개여도 그 구분기호 사이의 빈칸이 출력되지 않음, 여러개의 구분기호를 사용 할 수 있다
		StringTokenizer st = new StringTokenizer(hobby, "/,");
		System.out.println("토큰 수-> "+st.countTokens());
		
		// hasMoreElements, hasMoreToken: 토큰이 있는지 확인
		// 토큰이 있으면 {}안이 실행됨
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
	
	public static void main(String args[]) {
		new StringTokenizerTest().start();
		
	}

}
