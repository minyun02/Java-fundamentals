
class Access01 {

	private String userid="goguma";
	String userpwd="ggm1234";
	
	// 생성자
	Access01() {
		System.out.println("private 변수> "+userid);
	}
	
	// 메소드의 형식: 접근제어자+반환형+메소드명()
	void printData() { 	// default
		System.out.println("id="+userid);
		System.out.println("password="+userpwd);
	}

}
