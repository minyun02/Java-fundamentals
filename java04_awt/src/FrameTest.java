import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrameTest {

	//객체를 이용한 컨테이너 생성
	Frame frm = new Frame(); // 기본적으로 Border Layout이 setting : center만 크기가 바뀌고, west east는 높이만 바뀌고, north south는 폭만 바뀜
	Dimension dim = new Dimension(400, 300);
	Point pnt = new Point(200, 200);
	Rectangle rect = new Rectangle(pnt, dim);
	
	public FrameTest() {
		//0. Frame의 Title
		frm.setTitle("연습용 Frame");
		
		//1. 창의 크기 설정 : setSize, setBounds, pack
		//frm.setSize(500, 500); 창 제일 구석에서 열림
		//frm.setBounds(100, 100, 500, 500); // frame을 열 좌표(100,100) 설정
		//frm.setSize(dim);
		frm.setBounds(rect);
		//frm.pack(); 

		//2. botton 만들기 : before showing comtainer
		Button btn1 = new Button("Button 01");
		frm.add(btn1); // 버튼이 창 크기와 같음 (위치가 center) .. 버튼 크기 조절 필요
		
		Button btn2 = new Button("Button 02");
		frm.add("North", btn2); // or BorderLayout.NORTH
		frm.add(BorderLayout.EAST, new Button("Button 03"));
		frm.add("South", new Button("Button 04"));
		frm.add(BorderLayout.WEST, new Button("Button 04"));
		
		
		//3. 창을 show
		frm.setVisible(true);
		
		//4. 창의 tile에 보여질 icon 설정
		Toolkit kit = Toolkit.getDefaultToolkit(); //toolkit 객체를 만들고 getDefaultToolKit으로 overriding
		
		Image img = kit.getImage("img_awt/images.jpg"); //이미지 불러오기
		frm.setIconImage(img);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new FrameTest();

	}

}
