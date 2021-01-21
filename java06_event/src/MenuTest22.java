import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuTest22 extends JFrame implements ActionListener {
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	JMenuBar mb =new  JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새문서"); // B
			JMenuItem openMenuItem = new JMenuItem("열기"); // A
			JMenuItem saveMenuItem = new JMenuItem("저장");  
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu editMenu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사하기");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem chromeMenuItem = new JMenuItem("크롬");	
			JMenu editor = new JMenu("편집기");
				JMenuItem memoMenuItem = new JMenuItem("메모장");
				JMenuItem editplusMenuItem = new JMenuItem("에디트플러스");
			JMenuItem compileMenuItem = new JMenuItem("컴파일");
			
			String textBuffer ;
	///////툴바//////////
	JToolBar tb = new JToolBar();
	// 새문서
	ImageIcon newIcon = new ImageIcon("icon/new01.gif"); JButton newBtn = new JButton(newIcon);	
	// 저장
	ImageIcon saveIcon = new ImageIcon("icon/save01.gif"); JButton saveBtn = new JButton(saveIcon);
	// 열기
	ImageIcon openIcon = new ImageIcon("icon/open01.gif"); JButton openBtn = new JButton(openIcon);
	// 진하게
	ImageIcon boldIcon = new ImageIcon("icon/bold01.gif"); JButton boldBtn = new JButton(boldIcon);
	// 이탤릭 폰트
	ImageIcon italicIcon = new ImageIcon("icon/italic01.gif"); JButton italicBtn = new JButton(italicIcon);		
	
	// 글자 크기를 선택하기 위한 콤보박스
	JComboBox<Integer> fontSize = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();
	// 글꼴 넣을 콤보박스
	JComboBox<String> fontName; //= new JComboBox<String>(); 얻어지 ㄴ객체가 있어서 변수만 선언해도 됨
	// font 관련 기능
	// 볼드 정보를 저장할 변수
	int bold = 0, italic =0;
	Font fnt = new Font("굴림체",0,14);


	///////////////////
	public MenuTest22() {
		super("메모장");
		add(sp);
		// 담기 
		//파일메뉴
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		//경계선
		fileMenu.addSeparator();
		//
		fileMenu.add(endMenuItem);
		mb.add(fileMenu);
		// 편집메뉴
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		mb.add(editMenu);
		// 실행메뉴
		runMenu.add(chromeMenuItem);
		runMenu.add(editor);
			editor.add(memoMenuItem);
			editor.add(editplusMenuItem);
		runMenu.add(compileMenuItem);
		mb.add(runMenu);
		
		setJMenuBar(mb); // 프레임 안에 메뉴바 넣기 
		
		////////////툴바 설정////////////////
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		//font콤보박스
		for(int i=8; i<=70; i+=3) {
			fontSizeModel.addElement(i);
		}
		fontSize.setModel(fontSizeModel);
		// 폰트 유형 - 초기 글자크기
		fontSize.setSelectedItem(14);
		tb.add(fontSize);
		
		// 툴바를 프레임에 넣기
		add(BorderLayout.NORTH, tb);
		//////////////////////////////////
		// 윈도우 운영체제의 글꼴 얻어오기
		GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fntList = ge.getAvailableFontFamilyNames(); // 배열 안에 글꼴들이 있음 콤보박스 만들어서 툴바에 넣기 
		fontName = new JComboBox<String>(fntList);
		fontName.setSelectedItem("굴림체");
		tb.add(fontName);
		ta.setFont(fnt);
		//단축키 설정
		setShortCut();
		//
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//메뉴를 이벤트 등록
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
		
		// 툴바 이벤트 등록
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		// 툴바 내 폰트 
		fontSize.addActionListener(this);
		fontName.addActionListener(this);
	}
    // 단축키 설정
	public void setShortCut() {
		// 종료 : ctrl + e
		//1. E 단축키를 무엇으로 할 것인지 설정
		endMenuItem.setMnemonic(KeyEvent.VK_E);
		//2. ctrl 단축키의 Mask 설정                         단축키          MASK코드
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		
		// filemenu의 3개 단축키 설정하기
		// 새문서 ctrl + n
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		// 열기 alt + o
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.ALT_MASK));
		// 저장 ctrl + s
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
	}
	// 오려두기 메소드 
	public void setCut() {
		 textBuffer	= ta.getSelectedText() ;// 선택된 문자를 가져오는것/ 멤버변수 만들어서 거기에 저장 
		 // 선택된 만큼 없애기 ""
		 ta.replaceSelection("");
	}
	 // 붙여넣기
	 public void setPaste() {
		 //공백일 때는 null
		 if(textBuffer!=null && !textBuffer.equals("")) {
			 ta.replaceSelection(textBuffer);
		 }
	 }
	// 복사하기
	 public void setCopy() {
		 textBuffer = ta.getSelectedText();
	 }
	// 파일 열기	
	public void fileOpen() {
	// 파일 탐색기
		File f = new File ("D://javaTest"); // default 폴더
		JFileChooser fc = new JFileChooser(f);
		// 여러 파일을 선택할 수 있도록 설정
		fc.setMultiSelectionEnabled(true); //true 다중선택, false 단일선택
		// 필터 설정(원하는 확장자선택)
		FileFilter ff1 = new FileNameExtensionFilter("이미지", "jpg","jpeg","gif","png","bmp");
		fc.addChoosableFileFilter(ff1);
		          // ff1 과 ff2 ->임포트의 ff2처럼 해아함
		javax.swing.filechooser.FileFilter ff2 = new FileNameExtensionFilter("java", "java","JAVA","Java");
		fc.addChoosableFileFilter(ff2);
		
		//showOpenDialog(componet parent => frame 부모컨테이너를 알려조 그게 바로 프레임) 열기 창 
		int state = fc.showOpenDialog(this); // 파일 탐색기 열림
		//0:열기 1: 취소
		if(state ==0) {
			try {
				ta.setText("");// 원래 있는 컨텐츠 지우기 
				//File selFile = fc.getSelectedFile();
	
				// data 중복 읽기
				File selFile[] = fc.getSelectedFiles();
				for(File s: selFile) {
				// data read
				FileReader fr = new FileReader(s);	
				BufferedReader br = new BufferedReader(fr);
				
				while(true) {
					String inData=br.readLine();
					if(inData==null) {
						break;
					}//if end
					ta.append(inData + "\n");
				  }// while end
				ta.append("-----------------------------------------------\n");
				}// for end
			}catch(Exception e) {
				System.out.println("파일열기 에러 발생");
				e.printStackTrace();
			}// try catch end
		}// if state ==0 end
			//fc.showOpenDialog(this); // 파일 탐색기 열림
			//modal 선택창이 실행된 후에 기존 창을 쓸수 있도로 막아둔것
			
	}
	 
	 // 외부 실행형 파일 구현 - String 변수를 설정  아래의 원하는 값을 불러옫로ㅗㄱ
	 public void startRuntime(String process) {
		 Runtime run = Runtime.getRuntime();
		 try {
		 run.exec(process); // IO Exception이라는 예외 발생 
		 }catch(IOException ie) {
			ie.getStackTrace();
		}
	 }
		 
	 
	@Override  //ae ->  Jmenuitem jbutton jcombobox
	public void actionPerformed(ActionEvent ae) {
		//String eventMenu = ae.getActionCommand();
		Object eventObj = ae.getSource(); // 컴퍼넌트 구분 없이 구해줌  무조건 구해짐 obj가 위 세개의 데이터 변수 중 무엇인지 확인해야함
		// 이벤트가 발생한 객체가 어떤 클래스로 생성된 것인지 확인
		// 객체                   클래스명
		if(eventObj instanceof JMenuItem) {
			String eventMenu = ae.getActionCommand();
			if(eventMenu.equals("열기")) { // A 열기 
					fileOpen();
				}else if(eventMenu.equals("종료")) {
					System.exit(0);	
				}else if(eventMenu.equals("오려두기")) {  // 편집메뉴 - 오려두기 기능
					setCut();
				}else if(eventMenu.equals("붙여넣기")) { // 편집메뉴 - 붙여넣기 기능
					setPaste();
				}else if(eventMenu.equals("복사하기")) { // 편집메뉴 - 복사하기 기능
					setCopy();
				}else if (eventMenu.equals("메모장")) { // 실행  - 메모장
					startRuntime("notepad.exe");
				}else if(eventMenu.equals("크롬")) { // 실행 - 크롬
					startRuntime("C://Program Files/Google/Chrome/Application/chrome.exe https://naver.com");
				}else if(eventMenu.equals("에디트플러스")) {
					startRuntime("C://Program Files//EditPlus/editplus.exe");
				//}else if(eventObj == boldBtn) {
				//	Font fnt = new Font("궁서체",Font.BOLD,20);
				//	ta.setFont(fnt);
				}
		
		}else if(eventObj instanceof JButton){
			// 볼드와 이태릭 0 -? 1 2로 변경
			if(eventObj == boldBtn) {
				if(bold==0) {bold =1;
				}else if(bold ==1) {
					bold = 0;
				}
				fnt = new Font((String)fontName.getSelectedItem(), bold + italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}else if(eventObj == italicBtn) {
				if(italic ==0) {
					italic =2;
				}else italic =0;
				fnt = new Font((String)fontName.getSelectedItem(), bold + italic, (Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}else if(eventObj == openBtn) { //A 열기
				fileOpen();
			}
		}else if(eventObj instanceof JComboBox) {
				if(eventObj == fontSize || eventObj == fontName) {
					fnt = new Font((String)fontName.getSelectedItem(), bold + italic, (Integer)fontSize.getSelectedItem());
					ta.setFont(fnt);
				}
			}
	}

	public static void main(String[] args) {
		new MenuTest22();

	}

}
