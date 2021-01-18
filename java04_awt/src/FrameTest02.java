import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

// 상속받아서 frame 만들기 > 객체를 쓰지 않아도 쓸 수 있다!
public class FrameTest02 extends Frame {

	public FrameTest02() {
		//1.  창 제목 
		super("상속받은 Frame"); // or setTitle("window title")
		
		//2. 창 크기
		setSize(400, 400);
		
		//3. Layout 변경 = BorderLayout > FlowLayout: component 추가 시, 블록처럼 채워줌
		setLayout(new FlowLayout());
		
		Button btn1 = new Button("FlowLayout Button");
		add(btn1);
		
		// 창 보여주기
		setVisible(true);
	}

	public static void main(String[] args) {
		new FrameTest02();

	}

}
