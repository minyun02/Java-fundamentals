import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatLayout extends JFrame{
	//빈공간 넣을 틀
	JPanel pane1 = new JPanel(new BorderLayout());
		
		//ip, buttn, textArea 넣을 틀
		JPanel pane2 = new JPanel(new BorderLayout());
			
				
			
	public ChatLayout() {
		super("Chat Client");
		
		add(pane1);
		pane1.add("Center", pane2);
		setPane1();
		
		setPane2();
		
		setPane3();
		
		
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setPane1() {
		pane1.setBackground(Color.LIGHT_GRAY);
		//빈곳에 들어갈 라벨들
				JLabel lbl1 = new JLabel("위");
				JLabel lbl2 = new JLabel("왼");
				JLabel lbl3 = new JLabel("오");
				JLabel lbl4 = new JLabel("아래");
		pane1.add("North", lbl1);
		pane1.add("West", lbl2);
		pane1.add("East", lbl3);
		pane1.add("South", lbl4);
		
	}
	public void setPane2() {
		//IP, list panel
		JPanel ipPane = new JPanel(new BorderLayout());
		JTextField tf1 = new JTextField(30);
		JButton btn1 = new JButton("접속");
		
		ipPane.add("Center", tf1);
		ipPane.add("East", btn1);
		pane2.add("North", ipPane);

		//send
		JPanel sendPane = new JPanel(new BorderLayout());
		JTextField tf2 = new JTextField(30);
		JButton btn2 = new JButton("보내기");
		sendPane.add("Center", tf2);
		sendPane.add("East", btn2);
		pane2.add("South", sendPane);
		
		//TextArea
		JTextArea ta = new JTextArea();
		JScrollPane scr = new JScrollPane(ta);
		pane2.add("Center", scr);
	}
	
	public void setPane3() {
		JPanel listPane = new JPanel(new BorderLayout());
		JLabel listLbl = new JLabel("접속자리스트", JLabel.CENTER);
		listPane.add("North", listLbl);
			
		JList<String> list = new JList<String>();
				DefaultListModel<String> model = new DefaultListModel<String>();
				String user[] = {"user1", "user2", "user3", "user4"	};
				for(String userIp : user) {
					model.addElement(userIp);
				}
				list.setModel(model);
				//JScrollPane scr1 = JScrollPane(list);
		listPane.add("Center", list);		
		
		JLabel userLbl = new JLabel("현재원"+ "?"+ "명");
		listPane.add("South", userLbl);
		
		pane2.add("East", listPane);
	}
	public static void main(String[] args) {
		new ChatLayout();

	}

}
