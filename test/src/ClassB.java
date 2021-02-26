class ClassA{
	public int getValue() {
//		int value = 0;
//		boolean setting = true;
//		String title = "Hello";
//		//if(value || (setting && title == "Hello")) {return 1;}
//		if(value==0 || title.equals("Hello")) {
//			return 1;
//		}
//		if(value==1 && title.equals("Hello")) {
//			return 2;
//		}	
//		try {
//			String[] pet = {"강아지", "고양이"};
//			for(int i=0; i<=pet.length; i++) {
//				System.out.println(pet[i]);
//			}
//			
//		}catch(Exception e) {
//			System.out.println("예외가 발생했습니다->"+e.getMessage());
//		}	
//		
//		return 1;
//	}
}

public class ClassB{
	public static void main(String[] args) {
		ClassA a = new ClassA();
		a.getValue();
	}
}
