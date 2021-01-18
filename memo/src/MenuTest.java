
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuTest extends JFrame implements ActionListener{
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	// create Menu
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새문서");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem saveMenuItem = new JMenuItem("저장");
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu editMenu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사하기");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem chromeMenuItem = new JMenuItem("크롬");
			JMenu editor = new JMenu("메모장");
				JMenuItem memoMenuItem = new JMenuItem("메모장");
				JMenuItem editplusMenuItem = new JMenuItem("에디트 플러스");
			JMenuItem compileMenuItem = new JMenuItem("컴파일");
			
	// 툴바 만들기, 툴바에 필요한 요소
	JToolBar tb = new JToolBar();
	  //새문서
	ImageIcon newIcon = new ImageIcon("icon/new01.gif"); JButton newBtn = new JButton(newIcon);
	  //저장
	ImageIcon saveIcon = new ImageIcon("icon/save01.gif"); JButton saveBtn = new JButton(saveIcon);
	  //열기
	ImageIcon openIcon = new ImageIcon("icon/open01.gif"); JButton openBtn = new JButton(openIcon);
	  //진하게
	ImageIcon boldIcon = new ImageIcon("icon/bold01.gif"); JButton boldBtn = new JButton(boldIcon);
	  //이텔릭
	ImageIcon italicIcon = new ImageIcon("icon/italic01.gif"); JButton italicBtn = new JButton(italicIcon);
	  //글자크기
	JComboBox<Integer> fontSize = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();
	
	  //글꼴
	JComboBox<String> fontName = new JComboBox<String>();; //이미 얻어진 데이터 배열이 있으니까, 그걸로 객체 만들기
	
	String textBuffer; // 임시저장 할 변수
	
	int bold = 0, italic =0;
	Font fnt = new Font("굴림체",0,14);
	 
	// 현재 작업 중인 파일객체 변수
	File nowFile;
	   
	public MenuTest() {
		
		super("Memo");
		add(sp);
		// 메뉴 안에 메뉴아이템들 담기
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator(); // 메뉴 안에서 기능별로 나누는 경계선 긋기
		fileMenu.add(endMenuItem);
		// 메뉴바 안에 메뉴 집어넣기
		mb.add(fileMenu);
		// 메뉴바를 프레임에 집어넣기 >> 한번만 하면 됨
		setJMenuBar(mb); 
		
		
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		mb.add(editMenu);
		
		runMenu.add(chromeMenuItem);
		runMenu.add(editor);
			editor.add(memoMenuItem);
			editor.add(editplusMenuItem);
		runMenu.add(compileMenuItem);
		mb.add(runMenu);
		
		/////////////////////// ToolBar
		tb.add(newBtn);
		tb.add(saveBtn);
		tb.add(openBtn);
		tb.addSeparator();
		tb.add(boldBtn);
		tb.add(italicBtn);

		for(int i=8; i<=70; i+=3) {
			fontSizeModel.addElement(i);
		}
		fontSize.setModel(fontSizeModel);
		fontSize.setSelectedIndex(14);
		tb.add(fontSize);
		add(BorderLayout.NORTH, tb);
		
		//현재 컴퓨터에 있는 폰트 얻어오는 클래스  ...?
		//윈도우 운영체제의 글꼴 얻어오기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); // 글꼴 객체화..
		String[] fntList = ge.getAvailableFontFamilyNames(); //메소드 불러옴, 상단에 글꼴 넣을 콤보박스 만들기
		fontName = new JComboBox<String>(fntList);
		fontName.setSelectedItem("굴림체");
		tb.add(fontName);
		
		 ta.setFont(fnt);
		/////////////////////// ToolBar ,, 기능처리 아직
		
		//단축기 설정하는 방법
		setShortCut(); // 다른 메소드에서 할 거라서 메소드를 호출함
		
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//기능 구현을 위해서 JMenuItem으로 만들어진 항목을 이벤트 등록 > 실행 메소드에 등록 
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		
		chromeMenuItem.addActionListener(this);
		memoMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		compileMenuItem.addActionListener(this);
		
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		fontSize.addActionListener(this);      
		fontName.addActionListener(this);
	}
	
	
	//override
	public void actionPerformed(ActionEvent ae) {
		String eventMenu = ae.getActionCommand();
		Object eventObj = ae.getSource();
		
		if(eventMenu.equals("새문서")) {
			newFile();
		}else if(eventMenu.equals("열기")) {
			fileOpen();
		}else if(eventMenu.equals("저장")) { 
			fileSave();
		}else if(eventMenu.equals("종료")) {
			//위에서 
			System.exit(0);
		}else if(eventMenu.equals("오려두기")) {
			setCut();
		}else if(eventMenu.equals("붙여넣기")) {
			setPaste();
		}else if(eventMenu.equals("복사하기")) {
			setCopy();
		}else if(eventMenu.equals("메모장")) {
			startRuntime("notedpad.exe");
		}else if(eventMenu.equals("크롬")) {
			//startRuntime("크롬파일의주소값+chrome.exe"); //실행페이지 지정을 위해서는 url 마지막에 추가 
			startRuntime("C://ProgramData/Microsoft/Windows/Start Menu/Programs/Chrome.lnk");
		}else if(eventMenu.equals("에디트플러스")) {
			startRuntime("C://ProgramData/Microsoft/Windows/Start Menu/Programs/editplus.exe");
		}else if(eventObj == boldBtn) {
			Font fnt = new Font("궁서체", Font.BOLD, 20);
			ta.setFont(fnt);
		}else if(eventObj instanceof JButton) { // 툴바의 아이콘 선택시 실행
	         if(eventObj == boldBtn) {
	             if(bold==0) {
	                bold=1;
	             }else {
	                bold=0;
	             }
	             fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
	             ta.setFont(fnt);
	    } else if(eventObj == italicBtn) {
	         if(italic==0) {
	        	 italic=2;
	             }else {
	                italic=0;
	             }
	             fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
	             ta.setFont(fnt);
	          }else if(eventObj == openBtn) {
	        	  fileOpen();
	          }else if(eventObj == newBtn) {
	        	  newFile();
	          }else if(eventObj == saveBtn) {
	        	  fileSave();
	          }
	    } else if(eventObj instanceof JComboBox) {
	          if(eventObj == fontSize || eventObj == fontName){
	             fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
	             ta.setFont(fnt);
	          }
	    }
		
		
	}
	
	//새문서 만들기
	public void newFile() {
		nowFile = null;
		setTitle("Memo");
		ta.setText(""); //작업문서객체 초기화 작업 끝
		
	}
	
	//파일저장 1.새문서 작성하고 처음 저장 > :nowFile=null 파일탐색창 보여주기, 2.불러온 파일 수정 후 저장 > :nowFile!=null 바로저장 
	public void fileSave() {
		//쓰기를 할 수 있는 API 확인하기 > FileWriter(File file): Constructs a FileWriter object given a File object.
								// cf. FileWriter(File file, boolean append) > append=true 원래 있는 내용에서 뒤에 새 내용을 붙임, append=false or 생략
								//component 안에 있는 것, 무조건 String > write(String str, int off, int len): Writes a portion of a string.
		if(nowFile==null) { // 1
			//File f = new File("D://ioSample");
			JFileChooser fc = new JFileChooser();
			
			int state = fc.showSaveDialog(this); //saveBtn = 0, cancelBtn = 1
			if(state==0) {//저장 버튼 선택시
				//선택한 드라이브명, 경로, 파일명
				File f = fc.getSelectedFile();
				//글내용
				String str = ta.getText();
				//중복된 이름
				if(f.exists()) {
					JOptionPane.showMessageDialog(this, "이미 존재하는 파일명입니다.\n저장하기가 취소되었습니다.");
				}else {
					try {
						//FileWriter객체
						FileWriter fw = new FileWriter(f);
						fw.write(str, 0, str.length());
						fw.flush();
						fw.close();
						
						nowFile = f;
						setTitle(f.getPath());
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}else { // 2
			String writeTxt = ta.getText();
			try {
				FileWriter fw = new FileWriter(nowFile);
				fw.write(writeTxt, 0, writeTxt.length());
				fw.flush();
				fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//파일열기
	public void fileOpen() {
		File f = new File("D://ioSample");
		JFileChooser fc = new JFileChooser(f); //파일탐색기
		//여러파일을 선택 할 수 있도록 설정
		fc.setMultiSelectionEnabled(true); // true:다중선택 가능하도록 설정 > 여기까지 open X, false:단일선택
		
		// 필터 설정 : 열고자 하는 파일의 확장자명으로 걸러주는 방법
		 FileFilter ff1 = new FileNameExtensionFilter("이미지","jpg","gif","jpeg","png","bmp");
		 fc.addChoosableFileFilter(ff1);
		 FileFilter ff2 = new FileNameExtensionFilter("java", "java", "JAVA", "java");
		 fc.addChoosableFileFilter(ff2);
		
		//fc.showOpenDialog(this); //탐색기파일이 열림
		int state = fc.showOpenDialog(this); 
			//파일을 열려고 한다면? 0: open, 1:cancel
		if(state==0) {
			try {
			ta.setText(""); //원래있는 컨텐츠 지우기
			//File < getSelectedFile() = Returns the selected file., 여러개는 ~s() File[]로 리턴
			File[] selFile = fc.getSelectedFiles(); // = 파일의 드라이브명, 경로, 파일명이 들어있음
			//File selFile = fc.getSelectedFile(); //파일 선택
			for(File s: selFile) {
				// 현재 파일명을 JFrame title으로 설정하는 방법
				String path = s.getPath();
				setTitle(path);
				//멤버영역에 현재파일 변수 생성해서 저장
				nowFile = s;
				
				FileReader fr = new FileReader(s); //선택한 파일을 FileReader로 읽음(한글 때문에)
				BufferedReader br = new BufferedReader(fr); //한 줄로 출력하기 위해서 읽은 파일을 버퍼에 넣음
				while(true) {
					String inData = br.readLine(); //한 줄 단위로 파일을 읽어서 출력
					//String inData = br.readLine(); //파일 출력
					if(inData == null) {
						break;
					}
					ta.append(inData + "\n"); // TextArea에 추가 BufferedReader는 enter값 포함되지 않았으니까, 개행필요
				}
				//ta.append("- - - - - - - - - - 새 파일 시작 - - - - - - - - - -\n");
			}	
			}catch(Exception e) {
				System.out.println("파일열기 에러 발생...!");
				e.printStackTrace();
			}
		}
	}
	
	
	//외부 실행형 파일 구현
	//  하나의 변수로 여러개 파일 실행을 위해서 매개변수를 만들어서 객체 실행때 입력한 매개변수의 값을 받아서 실행을 하는 것으로 변경..
	public void startRuntime(String process) {
		Runtime run = Runtime.getRuntime(); //Runtime 객체
		try {
			run.exec(process); 
			// run.exe("notepad.exe); error? throw exception처리가 안되서! .. 맥에서 해당 exe 없어서 실행 안됨 ㅠ
		}catch(IOException ie) {
			ie.getStackTrace();
		}
	}
	
	//복사하기 기능 설정
	public void setCopy() {
		// 현재 선택된 문자를 textBuffer에 넣음
		textBuffer = ta.getSelectedText();
	}
	
	//붙여넣기 기능 설정
	public void setPaste() {
		//오려둔 문자를 커서 위치에서 붙여넣기
		if(textBuffer!=null && !textBuffer.equals("")) {
			ta.replaceSelection(textBuffer); // 드레그 한 부분이 없어지면서 붙여지는 것까지 구현해야하기 때문에 replaceSelection이용
		}
	}

	//오려두기 기능 설정 
	public void setCut() {
		//TextArea에서 문자 선택 
		textBuffer = ta.getSelectedText(); //textBuffer에 저장
		//선택된만큼의 문자를 ""로 치환 > 선택된 문자 사라짐
		ta.replaceSelection("");
	}
	//단축키 설정하기
	public void setShortCut() {
		//종료메뉴 단축키 ctrl + e
		//1.단축키를 무엇으로 할 것인지 설정 = e
		endMenuItem.setMnemonic(KeyEvent.VK_E); // setMnemonic은 오버라이딩되서 char or int 중 택 1, 보통 int를 입력 > KeyEvent에서 (ascii)해당 문자의 멤버변수를 확인한다
		//2.단축키의 mask를 설정 = ctrl							단축키 			Mask key
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		//새문서 단축키 ctrl + n
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		//열기 단축키 alt + o
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		//저장 단축키  ctrl + s
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
	}
	
	
	
	public static void main(String[] args) {
		new MenuTest();
	}

}
