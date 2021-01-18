package apiClass;

public class StringTest {

	public StringTest() {
		//			   0 12 345
		String data = "서울시 마포구 백범로";
		String data2 = new String("서울시 마포구 백범로");
		
		if(data==data2) {
			System.out.println(data+"와 "+data2+"는 같다.");
		}else {
			System.out.println(data+"와 "+data2+"는 다르다.");
		}
		// date가 변환된 전환된 주소와 data1이 변환한 주소가 다르다, 연산자들은 기본데이터끼리 비교할때 사용
		
		if(data.equals(data2)) {
			System.out.println(data+"와 "+data2+"는 같다.");
		}else {
			System.out.println(data+"와 "+data2+"는 다르다.");
		}
		// 자료값이 변환되어 저장된 주소끼리 비교하는게 아니라 문자(자료)를 비교하기 때문에 equals 사용해야함
		
		// String API에 있는 자주 쓰는 method
		// charAt() : index 위치의 문자 반환, 특정 위치의 문자를 구해올때
		char result1 = data.charAt(5);
		System.out.println("charAt(5)= "+result1);
		
		// concat(String str) : 문자열의 연결 data+data2
		String data3 = "Java OOP Programing...";
		String data4 = "java oop programing..."; // data3 != data4, 다르다
		String result2 = data.concat(data3);
		System.out.println("concat(data3)= "+result2);
		
		// equals()
		boolean boo1 = data3.equals(data4);	// 대소문자 구분됨
		System.out.println("equals()= "+boo1);
		boolean boo2 = data3.equalsIgnoreCase(data4);	// 대소문자 구분하지 않음
		System.out.println("equalsIgnoreCase()= "+boo2);
		
		// getbyte() : 문자열을 byte 배열로 바꿔줌, 오버로딩
		byte result3[] = data3.getBytes();
		for(byte b : result3) {	// for(A:B) B에서 차례대로 객체를 꺼내서 A에다가 넣겠다
			System.out.println(b+"ㅡ>"+(char)b);
		}
		
		// indexOf() : 내가 원하는 특정한 글자가 문자열의 어느곳(index)에 있는지 확인할때, 값이 존재하지 않을 경우 -1, 예: 이메일 유효성 확인, 오버로딩
		int result4 = data3.indexOf("OOP");
		System.out.println("indexOf(OOP)= "+result4);
		
		int result5 = data3.indexOf("OOP", 10); // 특정한 위치(10)에서부터 String값을 찾아라
		System.out.println("indexOf(OOP, 10)= "+result5);
		
		// length() : 문자수, 파일 업로드 용량 제한 할 때도 사용됨
		int result6 = data3.length(); // 배열의 길이 구할때는 괄호가 없다
		System.out.println("length()= "+result6);
		
		// replaceAll() : 특정 위치의 문자열을 변경
		String result7 = data3.replaceAll("OOP", "객체");
		System.out.println("replaceAll()= "+result7);
		
		// split() : 특정문자로 문자열을 조각낼때
		String tel = "010-1234-5678";
		String result8[] = tel.split("-"); // 만약 010--1234 이런식이면 --사이의 공간도 조각낸다
		for(int i=0; i<=result7.length(); i++) {
			System.out.println("tel["+i+"]= "+result8[i]);
		}
		
		//  substring() : 문자열의 일부 구하기(return)
		String result9 = data3.substring(5); // 5번 index부터 끝까지의 문자열을 구한다 
		System.out.println("substring(5)= "+result9);
		
		String result10 = data3.substring(5, 10); // 5번 index부터 10번 index 앞까지(9번까지)의 문자열을 구한다
		System.out.println("substring(5, 10)= "+result10);
		
		// toLowerCase 소문자로 toUpperCase 대문자로 변환
		System.out.println("toLowerCase= "+data3.toLowerCase());
		System.out.println("toUpperCase= "+data3.toUpperCase());
		
		// compareTo(String anotherString): 문자열의 크기 비교 return type이 int, cf)	compareToIgnoreCase: 대소문자 관계없이 비교
		// return값 0 = 두 값은 같다, + = 왼쪽 문자가 크다, - = 오른쪽 문자가 크다
		// a="Java" b="java" 비교 할 때, 연산자 사용이 불가능 > a.compareTo(b) 첫번째 자리부터 비교 > J-j=74-106=-32 > return=-32
		String str1 = "홍길동"; // 홍 - 이 = 3801, 왼쪽값이 더 크다
		String str2 = "이순신"; // 숫자 < 영어 < 한글
		int result11 = str1.compareTo(str2);
		System.out.println("compareTo()= "+result11);
		
		// trim(): 자료의 양끝에 있는 공백을 제거
		String str3 = "    Java Programing    ";
		System.out.println("str3="+str3);
		String result12 = str3.trim();
		System.out.println("trim()="+result12);
		
		// valueOf(): 기본데이터타입+char[]배열을 문자열로 변환하는 메소드
		int num = 1234;
		String numTxt = String.valueOf(num);
		System.out.println(numTxt+100); //1234+100 = 1234100 문자로 결합됨
		
		String num2 = "5678";
		int result13 = Integer.parseInt(num2);
		System.out.println(result13+1000);
		
		// 오토박싱: 기본데이터형이 객체형으로 대입, 오토언박싱: 객체형데이터가 기본데이터형으로 대입을 자동으로 함
		
		
		
		
	}

	public static void main(String[] args) {
		new StringTest();
			

	}

}
