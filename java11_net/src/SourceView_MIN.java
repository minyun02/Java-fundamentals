import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceView_MIN extends JFrame implements ActionListener  {
	//url Panel
	JPanel urlPane = new JPanel(new GridLayout(1,0));
		JLabel url = new JLabel("URL");
		JTextField tf = new JTextField();
		JButton btn = new JButton("Source View");
	//taPane
	JPanel taPane = new JPanel(new BorderLayout());
		JTextArea ta = new JTextArea();
	public SourceView_MIN() {
		add(urlPane, "North");
		add(taPane, "Center");
		
		urlPane.add(url);
		urlPane.add(tf);
		urlPane.add(btn);
		
		taPane.add("Center", ta);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf.addKeyListener(new EnterKeyEvent());
		btn.addActionListener(this);
	}
	public class EnterKeyEvent extends KeyAdapter {
		public void keyReleased(KeyEvent ke) {
			int key = ke.getKeyCode();
			if(key ==KeyEvent.VK_ENTER) {
				String urlTf = tf.getText();
				getSource(urlTf);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == btn) {
			String urlTf = tf.getText();
			getSource(urlTf);
		}
		
	}
	public void getSource(String urlTf) {
		try {
			URL url = new URL(urlTf);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			ta.setText("");
			while(true) {
				String inData = br.readLine();
				if(inData==null)break;
				ta.append(inData+ "\n");
				tf.setText("");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new SourceView_MIN();

	}

}
