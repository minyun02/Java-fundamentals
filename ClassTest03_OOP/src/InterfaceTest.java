
public interface InterfaceTest extends InterfaceTest02 {	//공동작업이기 때문에 interface에 메소드명들만 다 적어줌, = 추상메소드들의 집합
	//static 멤버변수들, 인터페이스의 접급제어자는 무조건 public
	public static String global= "seoul"; //String global="seoul" 차이?
	public static final int MAX = 100; // final과 값(100)이 설정되어있으면 MAX라는 변수는 다른값으로 변경안됨 = 상수화된 변수!
	
	//추상메소드들... 일반메소드는 만들 수 없다!
	public void print();
	public int[] recordAll(int num);
	public String total(int max);
	
}
