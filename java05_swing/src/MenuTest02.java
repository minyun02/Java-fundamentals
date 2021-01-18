// 세라언니 코드

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MenuTest02 extends JFrame implements ActionListener{
   JTextArea ta = new JTextArea();
   JScrollPane sp = new JScrollPane(ta);
   
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
         JMenu editor = new JMenu("편집기");
            JMenuItem memoMenuItem = new JMenuItem("메모장");
            JMenuItem editplusMenuItem = new JMenuItem("에디트플러스");
         JMenuItem compileMenuItem = new JMenuItem("컴파일");
   ////툴바만들기
   JToolBar tb = new JToolBar();
   //새문서
   ImageIcon newIcon = new ImageIcon("img/new01.gif"); JButton newBtn = new JButton(newIcon);
   //저장
   ImageIcon saveIcon = new ImageIcon("img/save01.gif"); JButton saveBtn = new JButton(saveIcon);
   //열기
   ImageIcon openIcon = new ImageIcon("img/open01.gif"); JButton openBtn = new JButton(openIcon);
   //진하게
   ImageIcon boldIcon = new ImageIcon("img/bold01.gif"); JButton boldBtn = new JButton(boldIcon);
   //이탤릭
   ImageIcon italicIcon = new ImageIcon("img/italic01.gif"); JButton italicBtn = new JButton(italicIcon);
   //글자크기
   JComboBox<Integer> fontSize = new JComboBox<Integer>();
   DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();// 배열쓰지말고 모델을 쓰세요!
   //글꼴넣을 콤보박스
   JComboBox<String> fontName = new JComboBox<String>();
   
   String textBuffer;
   
   int bold = 0, italic =0;
   Font fnt = new Font("굴림체",0,14);

   public MenuTest02() {
      super("메모장");
      add(sp);
      //파일메뉴 추가
      fileMenu.add(newMenuItem);       fileMenu.add(openMenuItem);      fileMenu.add(saveMenuItem);
      fileMenu.addSeparator();      fileMenu.add(endMenuItem); // separator는 구분선임!
      mb.add(fileMenu);
      //편집메뉴 추가
      editMenu.add(cutMenuItem);      editMenu.add(copyMenuItem);      editMenu.add(pasteMenuItem);
      mb.add(editMenu);
      //실행메뉴 추가
      runMenu.add(chromeMenuItem);   runMenu.add(editor);      runMenu.add(compileMenuItem);
      editor.add(memoMenuItem);      editor.add(editplusMenuItem);
      mb.add(runMenu);
      // 메뉴바 만들기
      setJMenuBar(mb);
      //툴바 만들기
      tb.add(newBtn); 
      tb.add(openBtn);
      tb.add(saveBtn);
      tb.addSeparator();
      tb.add(boldBtn);
      tb.add(italicBtn);
      for (int i=8; i<=70; i+=3) {
         fontSizeModel.addElement(i);
      }
      fontSize.setModel(fontSizeModel);
      fontSize.setSelectedItem(14);
      tb.add(fontSize);
      add(BorderLayout.NORTH, tb);
      //윈도우 운영체제의 글꼴 얻어오기
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      String[] fntList = ge.getAvailableFontFamilyNames();
      fontName = new JComboBox<String>(fntList);
      fontName.setSelectedItem("굴림체");
      tb.add(fontName);
      
      ta.setFont(fnt);
   
      // 단축키설정
      setShortCut();
      
      //
      setSize(500,500);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      // 메뉴를 이벤트 등록
      newMenuItem.addActionListener(this);       openMenuItem.addActionListener(this);
      saveMenuItem.addActionListener(this);      endMenuItem.addActionListener(this);
      
      cutMenuItem.addActionListener(this);       copyMenuItem.addActionListener(this);
      pasteMenuItem.addActionListener(this);
      
      chromeMenuItem.addActionListener(this);      compileMenuItem.addActionListener(this); 
      memoMenuItem.addActionListener(this);      editplusMenuItem.addActionListener(this);
      
      newBtn.addActionListener(this);      openBtn.addActionListener(this);
      saveBtn.addActionListener(this);      boldBtn.addActionListener(this);
      italicBtn.addActionListener(this);
      
      fontSize.addActionListener(this);      fontName.addActionListener(this);
   }
   //Jmenu, Jbutton, Jcombobox
   public void actionPerformed(ActionEvent ae) {
      String eventMenu = ae.getActionCommand();
      Object eventObj = ae.getSource();
      //이벤트가 발생한 객체가 어떤 클래스로 생성된것인지 확인
      if(eventObj instanceof JMenuItem) { // eventObj가 Jmenuitem으로 만들어진거니~?
         if(eventMenu.equals("종료")) {
            System.exit(0);
         } else if(eventMenu.equals("오려두기")) {
            setCut();
         } else if(eventMenu.equals("붙여넣기")) {
            setPaste();
         } else if(eventMenu.equals("복사하기")) {
            setCopy();
         } else if(eventMenu.equals("메모장")) {
            startRuntime("notepad.exe");
         } else if(eventMenu.equals("크롬")) {
            startRuntime("C://Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.naver.com");
         } else if (eventMenu.equals("에디트플러스")) {
            startRuntime("C://Program Files/EditPlus/editplus.exe");
         } else if(eventObj == boldBtn) {
            Font fnt = new Font("궁서체", Font.BOLD, 20);
            ta.setFont(fnt);
         }
      } else if (eventObj instanceof JButton) {
         if(eventObj == boldBtn) {
            if(bold==0) {
               bold=1;
            } else {
               bold=0;
            }
            fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
            ta.setFont(fnt);
         } else if (eventObj == italicBtn) {
            if (italic==0) {
               italic=2;
            } else {
               italic=0;
            }
            fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
            ta.setFont(fnt);
         }
      } else if(eventObj instanceof JComboBox) {
         if(eventObj == fontSize || eventObj == fontName) {
            fnt = new Font((String)fontName.getSelectedItem(), bold+italic, (Integer)fontSize.getSelectedItem());
            ta.setFont(fnt);
         }
      }
   }
   //메모장실행
   public void startRuntime(String process) {
      Runtime run = Runtime.getRuntime();
      try {
      run.exec(process);
      }catch(IOException ie) {
         ie.getStackTrace();
      }
   }
   //복사하기
   public void setCopy() {
      textBuffer = ta.getSelectedText();
   }
   //붙여넣기
   public void setPaste() {
      if(textBuffer!=null && !textBuffer.equals("")); {
         ta.replaceSelection(textBuffer);
      }
   }
   // 오려두기
   public void setCut() {
      textBuffer = ta.getSelectedText();
      ta.replaceSelection("");
   }
   // 단축키설정하기
   public void setShortCut() {
      // 종료: Ctrl+e
      // 단축키를 E로 설정
      endMenuItem.setMnemonic(KeyEvent.VK_E);
      // Ctrl 단축키의 Mask설정
      endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
      
      // 새문서 Ctrl+n
      newMenuItem.setMnemonic(KeyEvent.VK_N);
      newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
      // 열기 Ctrl+o
      openMenuItem.setMnemonic(KeyEvent.VK_O);
      openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
      // 저장 Ctrl+s
      saveMenuItem.setMnemonic(KeyEvent.VK_S);
      saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
   }

   public static void main(String[] args) {
      new MenuTest02();

   }

}