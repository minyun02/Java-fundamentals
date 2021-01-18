import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

//클래스에서 interface를 상속받을때, "implements" 예약어 사용
//interface는 여러개를 상속받을 수 있다 > implements A, B, ...
//상속받은 모든 추상메소드를 오버라이딩 해야한다, 10중 2개만 필요해도 10개 다해야함!
public class InterfaceMain implements InterfaceTest, ActionListener {

	public InterfaceMain() {
		
	}
	
	// 추상메소드 오버라이딩
	//InterfaceTest의 추상메소드의 오버라이딩
	public void print() {
		System.out.println(global+"--->"+MAX);
	}
	public int[] recordAll(int num) {
		Random r = new Random();
		int ran[] = new int[num];
		for(int i=0; i<ran.length; i++) {
			ran[i]=r.nextInt(100);
		}
		return ran; // return 타입이 배열이라 가능
	}
	public String total(int max) {
		return "total";
	}
	
	//InterfaceTest02의 추상메소드 오버라이딩
	public double getData(int data) {
		return (double)data; // 정수 -> 실수 형변환
	}
	
	//ActionLinstener 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	
	public static void main(String[] args) {
		
		InterfaceMain im = new InterfaceMain();
		im.print();
		int n[] = im.recordAll(10);
		System.out.println(Arrays.toString(n));
	}

}
