import org.python.util.PythonInterpreter;

public class PythonTest {

	public PythonTest() {

	}

	public static void main(String[] args) {
		// jython라이브러리를 추가한다.
		// http://www.jython.org/download
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("s=120");
		interpreter.exec("print(s)");
		//python파일 실행하기
		
		interpreter.execfile("pp/javaPythonTest.py");
		interpreter.exec("print(name)");
	
	}

}
