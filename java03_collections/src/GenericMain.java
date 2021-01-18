import java.util.Calendar;

public class GenericMain {

	public GenericMain() {
		GenericTest<String> gt = new GenericTest<String>(); // <String> = <T>
		gt.setUsername("홍길동"); // 홍길동 = String = T
		System.out.println(gt.getUsername());
		
		GenericTest<Calendar> gt2 = new GenericTest<Calendar>();
		gt2.setUsername(Calendar.getInstance()); // Calendar.getInstance = Calendar = T
		gt2.dateOutput();
		
		
		
	}

	public static void main(String[] args) {
		new GenericMain();

	}

}
