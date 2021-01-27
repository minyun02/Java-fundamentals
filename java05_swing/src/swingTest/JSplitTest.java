package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class JSplitTest extends JFrame{
	JSplitPane sp1, sp2;
	
	PackMan pc = new PackMan();
	Calculator c = new Calculator();
	CalendarSwing cs = new CalendarSwing();
	
	public JSplitTest() {
		sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pc, sp2);
		
		sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, c, cs);
		
		add(sp1);
		
		sp1.setDividerLocation(300);
		sp2.setDividerLocation(600);
		
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JSplitTest();

	}

}
