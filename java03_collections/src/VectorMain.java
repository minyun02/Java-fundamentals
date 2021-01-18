import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {

	}

	public static void main(String[] args) {
		VectorTest vt = new VectorTest();
		Vector vv = vt.getdata();
	
		//컬렉션의 객체를 얻어오기 - 객체가 지워지지 않는다.(vector의 특징)
		Member m1 = (Member)vv.elementAt(2); // 현재 member는 VectorTest클래스에서 add메서드로 Object객체로 만들어 넣었기때문에 강제 형변환(타입캐스팅)이 필요하다.
		Calendar date = (Calendar)vv.get(5);
		
		m1.memberPrn();
		System.out.println(date);
		
		//담겨있는 총 객체의 수를 알 수 있다
		System.out.println("객체의 수 --->"+vv.size()); // index 0 ~ 6 번지까지 있다
		
		//lastElement(Objcet) 형변환 필요
		Random ran = (Random)vv.lastElement();// 마지막 객체 얻어오기
		//System.out.println(ran);
		System.out.println("난수 ="+ran.nextInt());
		
		//객체 지우기
		vv.remove(3);
		vv.removeAllElements();
		//System.out.println("remove(3) 후 객체의 수 --->"+vv.size()); index number가 다 바뀜 
		System.out.println("removeAllElements 후 객체의 수 --->"+vv.size());
	}

}
