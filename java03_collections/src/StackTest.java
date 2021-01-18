import java.util.Stack;

public class StackTest {

	public StackTest() {
		// First In Last Out의 구조 > 처음 추가된 객체가 제일 마지막에 나옴
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(100); // Auto-boxing되서 new Integer(100)으로 안써도 됨 int > Integer로 자동으로 들어감
		stack.push(200);
		stack.push(300);
		stack.push(400);
		
		while(!stack.empty()) {
			System.out.println("stack.pop > "+stack.pop()); //역순으로 아웃풋이 된다
			System.out.println("남은 객체 수> "+stack.size());
		}
		
		
	}	
	
	
	
	public static void main(String[] args) {
		new StackTest();
	}

}
