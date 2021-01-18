package apiClass;

import java.util.Random;

public class RandomTest {

	public RandomTest() {
		start(); 
	}

	public void start() {
		//Random: 난수 클래스
		Random ran = new Random(); // 객체 생성
		for(int i=1; i<1000; i++) {
			//논리형: true, false 무작위로 구해주는 method
			//boolean ranBoo=ran.nextBoolean();
			
			//실수의 값을 무작위로 구해주는 method
			//double result=ran.nextDouble();
			
			//정수의 값을 무작위로 구해주는 method > 음수와 양수가 다 나옴
			int result=ran.nextInt();
			result = ran.nextInt(31)+10;	// 0~99까지의 사이의 값에서만 무작위 추출 e.g) (50) = 0~49, 
						//if 10~40범위, {난수*(큰수-작은수+1)}+작은수, {}안의 계산값을 ()에 집어넣어준다  
			
			System.out.print(result+"\t");
			if(i%10 == 0) System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new RandomTest();	// 생성자에서 다른 메소드 호출

	}

}
