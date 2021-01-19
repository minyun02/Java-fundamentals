import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{
	MyCanvas mc = new MyCanvas();
	public GraphicsTest() {
		setTitle("그림판");
		add(BorderLayout.CENTER, mc);
		
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//그림그리기
	//그림을 그리기 위해서는 Canvas를 상속 받고 pain()메소드를 오버라이딩 하면 처음 객체 생성시 별도의 호출없이 pain()메소드는 1번 자동 호출된다.
	class MyCanvas extends Canvas {
		public MyCanvas() {}
		//그림을 그리는 메소드를 오버라이딩한다. --> 생성자 메소드 실행 후 자동호출 됨.
		public void paint(Graphics g) {
			//직선 그리기
			g.drawLine(50,50,300,300);
			//사각형그리기
			g.drawRect(80,50,200,300); 
			//색 변경
			g.setColor(Color.red);
			g.fillRect(400, 50, 200, 300);
			
			//글자 그리기
			g.setColor(Color.blue);
			g.setFont(new Font("굴림체", Font.BOLD, 30));
			String str = "문자열을 그림으로 그리기";
			g.drawString(str, 50, 400);
			
			//원그리기
			g.drawOval(80, 50, 200, 300);
			g.fillOval(400, 50, 200, 300);
			
			//둥근원 그리기
			g.drawRoundRect(250, 450, 400, 400, 400, 400);
			
			//다각형
			g.setColor(Color.MAGENTA);
			int x[] = {300, 400, 350, 100, 110};
			int y[] = {100, 180, 400, 600, 300};
			g.drawPolygon(x, y, x.length);
		
		}
	}
	public static void main(String[] args) {
		new GraphicsTest();

	}

}
