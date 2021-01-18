

import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		//List, Queue, Deque 를 상속받음
		//List  
		//Queue 객체를 한쪽에서 추가하고 다른쪽에서 제거한다.
		//Deque 객체를 양쪽에서 추가, 제거 할 수 있다.
		// 	Queue, Deque 객체를 get() output하면 컬렉션에서 객체가 지워진다
		
		LinkedList<String> ll = new LinkedList<String>();
		
		//데이터 추가하기
		// offer이용 > 앞에서부터 순서대로 input함
		ll.offer("홍길동");
		ll.offer("세종대왕");
		ll.offer("이순신");
		ll.offer("신사임당");
		ll.offerFirst("Hong Gil Dong");
		
		//제일 마지막 객체를 pop하고 싶다면 ?
		System.out.println(ll.pollLast()+"\n");
		System.out.println(ll.get(1)+"\n"); //데이터가 추출되지 않고 그대로 있음

		//데이터=객체를 get할 때마다 index 안의 데이터가 같이 추출되어서 삭제됨, 
		//따라서 반복문으로 0~last index까지의 조건으로 추출 할 수 없다. 따라서 비어있을때까지 반복시키는 것으로 만들어줘야함(for문보다 while문 사용)
		while(!ll.isEmpty()) { // 컬렉션 ll이 비어있는지 확인후 true, false 리턴, 비어있을때까지 반복 = 채워져있을때 출력
			System.out.println(ll.pop());
		}

		//객체의 수 확인 
		System.out.println("ll.size() > "+ll.size());
		
		
		
	}

	public static void main(String[] args) {
		new LinkedListTest();

	}

}
