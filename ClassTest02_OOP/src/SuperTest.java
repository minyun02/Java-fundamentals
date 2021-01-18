class SubTest extends SuperTest{
	public SubTest(int a) {
		super(a);
	}
	public SubTest() {
		super(20);
	}
}


public class SuperTest {

	int a;
	
	public SuperTest(int a) {
		this.a = a;
	}

	
	
	
	public static void main(String[] args) {
		SubTest ob = new SubTest();
		System.out.println("a = "+ob.a);

	}

}
