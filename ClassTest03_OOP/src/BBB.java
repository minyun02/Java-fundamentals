
public class BBB extends AAA {

	String name = "hong gil dong";
	String tel = "010-5555-6666";
	
	public BBB() {
		
	}
	
	public void namePrint() {
		System.out.println("이름 = "+name);
	}
	//override,,,,
	public void output() {
		System.out.println(name+", "+tel);
	}
}
