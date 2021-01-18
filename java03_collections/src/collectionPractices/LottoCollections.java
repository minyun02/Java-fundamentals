package collectionPractices;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoCollections {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	public LottoCollections() {	}
	
	
	public int count() {
		int lottoGame = 0;
		do {
			System.out.print("게임 횟수 = ");
			lottoGame = scan.nextInt();
			LinkedList<Integer> ll = new LinkedList<Integer>();
			ll.offer(lottoGame);
			if(lottoGame <= 0) {
				System.out.println("0보다 큰 정수를 입력하세요...");
			}else {
				break;
			}
		}while(true);
		return lottoGame; 
		
	}
	
	
	public void lottoNum() {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int lotto = 0;
		
		for(int i=1; ts.size()<=7; i++) {
			lotto = ran.nextInt(45)+1;
			ts.add(lotto);
		}
		ts.remove(lotto);
		// Iterator와 toString 출력방식의 차이...
		/*
		Iterator<Integer> asc = ts.iterator();
		while(asc.hasNext()) {
			System.out.print(asc.next()+", ");
		}
		System.out.print("Bonus = "+lotto);
		*/
		///////////////////////////////////////////////////////
		System.out.print(ts.toString());
		System.out.println(" Bonus = "+lotto);
		
	}
	
	
	public boolean ask() {
		boolean boo = false;
		do {
			System.out.print("새 게임을 진행하시겠습니까? Y/y = 예, N/n = 아니오 >>> ");
			String answer = scan.next(); // 스페이스바 이후의 문장 누락됨, > nextLine 사용
			if(("Y").equalsIgnoreCase(answer)) {
				boo = true;
				System.out.println("새 번호를 추첨합니다...");
				break; 
			}else if(answer.equalsIgnoreCase("n")) {
				boo = false;
				System.out.println("--- 로또 번호 생성기 종료 ---");
				break;
			}else {
				
			}
			// 게임 지속여부에 상관없이 한 번 물어보고 끝내야함
		}while(true);
		
		return boo;
	}
	
	
	public void start() {
		do {
			int cnt = count();
			for(int i=1; i<=cnt; i++) {
				System.out.print(i+"번째 게임 : ");
				lottoNum();
			}
			if(!ask()) {
				break;
			}
			
		}while(true);
		
	}

	public static void main(String[] args) {
		LottoCollections newLotto = new LottoCollections();
		newLotto.start();
		

	}

}
