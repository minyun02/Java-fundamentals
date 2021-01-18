
public class Sample implements SampleImp {

	public Sample() {
	}

	public void sum(int max) {
		int sum = 0;
		for(int i=1; i<=max; i++) {
			sum+=1;
		}
		System.out.println("1~"+max+"까지의 합은 "+sum);
	}
	
	//인터페이스 상속 받았으니까 인터페이스 안의 추상메소드 오버라이딩 필요 
	public void oddSum(int max) {
		
	}
	public void evenSum(int max) {
		
	}
}
