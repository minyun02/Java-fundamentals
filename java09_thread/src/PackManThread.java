
public class PackManThread {

	public PackManThread() {
		PackMan pt1 = new PackMan();
		PackMan pt2 = new PackMan();
		
		Thread t1 = new Thread(pt1);
		Thread t2 = new Thread(pt2);
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new PackManThread();

	}

}
