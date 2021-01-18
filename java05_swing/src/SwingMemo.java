
public class SwingMemo {

	public SwingMemo() {
		
	}
	
	/*
	 * awt = window 의존적
	 * swing , awt 기반으로 만든 팩키지
	 * 
	 * 각 component 마다 event 처리를 하지 않으면, 만들어도 작동을 하지 않음..
	 * JFrame > BoradLayout
	 * JPanel > FlowLayout
	 * 
	 * JButton > event 처리를 하지 않으면 눌러도 아무 반응이 없다...
	 * JLabel
	 * 
	 * Button을 기준으로 발생하는 event 처리하기
	 * e.g) 로그인 화면에서 login Button > 무슨 event? or Sign in > 무슨 event?
	 * event 처리? 이벤트 등록, 이벤트 처리 > (방법) 1.해당 이벤트의 인터페이스 상속받아서 만듬 2.이벤트 등록 3.추상메소드를 override
	 * 
	 * JButton method..
	 *  addActionListener : Action Event, "ActionListner" = interface
	 *  addChangeListener : Change Event
	 *  addItemListener :  Item Event
	 * 
	 * Font clss
	 *  - 글꼴 유형: 돋음, 바탕, 고딕
	 *  - 글꼴 설정: 기울임, 진하게, 보통
	 *  - 글자크기 설정
	 *  > 객체, Font(String name, int style, int size)
	 *  			서체결정, 		기울임 진하게 보통, 글자크기:양의 정수
	 *  
	 *  Javax.swing
	 *  JComboBox : 클릭하면 여러개의 목록을 보여줌
	 *   - 생성자 만드는 방법 (), (E[]): 배열, (Vector) 
	 *   
	 *   WindowListener 인터페이스를 상속받으면 인터페이스 안에 모든 메소드 오버라이딩
	 *   복잡함.. adaptor?를 이욯해서 한 개만 오버라이딩 할 수 있다..?
	 *   
	 *   
	 *   
	 *   - - - 2021 01 15
	 *   FileNameExtensionFilter(String description, String... extensions)
	 *    > Creates a FileNameExtensionFilter with the specified description and file name extensions.
	 *   class A {
	 *   	A(String ... name) { ... }
	 *   = A는 스트링을 필요한 만큼 배치 할 수 있음
	 *   	A("..");
	 *   	A("..", "..", ..., "...");
	 *   
	 */
	

}
