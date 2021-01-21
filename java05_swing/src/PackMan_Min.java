import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class PackMan_Min extends JFrame implements KeyListener{
	MyCanvas mc = new MyCanvas();
	Image img;
	public PackMan_Min() {
		super("???");
		add(mc);
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public class MyCanvas extends Canvas {
		public MyCanvas() {
			
		}
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, 50, 50,    0, 0, 50, 50, this);
		}
	}
	public static void main(String[] args) {
		new PackMan_Min();

	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int evtInt = e.getKeyCode();
		
		if(evtInt == KeyEvent.VK_A || evtInt == KeyEvent.VK_LEFT ) {
			System.out.println("aaa");
			
		}else if(evtInt == KeyEvent.VK_D || evtInt == KeyEvent.VK_RIGHT) {
			System.out.println("ddd");
			
		}else if(evtInt == KeyEvent.VK_W || evtInt == KeyEvent.VK_UP) {
			System.out.println("wwww");
		}else if(evtInt == KeyEvent.VK_S || evtInt == KeyEvent.VK_DOWN) {
			System.out.println("ssss");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
