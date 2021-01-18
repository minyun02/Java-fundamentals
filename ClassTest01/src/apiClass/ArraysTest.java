package apiClass;

import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {

	public ArraysTest() {
		int data[] = {58,62,4,95,31,75,15,27,45,79,12};
		
		//배열객체의 데이터를 크기순으로 정렬, 	
		//sort(int[] a) : 오름차순으로 정리 > parallelSort(int[] a)도 참고
		//Arrays.sort(data);
		//System.out.println("오름차순 정렬> "+Arrays.toString(data));
		//sort(T[] a, Comparator<? super T> c) : 내림차순정렬, Collections와 연결해서 사용: reverseOrder() method
		
		//sort(int[] a, int fromIndex, int toIndex) : 데이터 크기 정렬 범위 지정
		Arrays.sort(data, 1, 5);
		System.out.println("1 ~ 5번지 앞까지만 정렬> "+Arrays.toString(data));
		
		//copyOf(int[] original, int newLength): 배열의 몇 개를 복사할 건지, cf. copyOfRange(int[] original, int from, int to): 카피 범위 지정
		int data2[] = Arrays.copyOfRange(data, 1,5);	// 1 ~ 4번지까지만 복사
		System.out.println("1 ~ 5번지 앞까지 복사> "+Arrays.toString(data2));
		
		int data3[] = Arrays.copyOf(data, 5);
		System.out.println("5개 복사> "+Arrays.toString(data3));
		
		//System의 method: arraycopy(Object src(배열의 자리) int srcPos,/set 1/ Object dest, int destPos, int length/set2/)
		int data4[] = new int[20]; // 초기값인 0이 20개가 들어있음
		System.arraycopy(data, 5, data4, 3, 6); // data배열의 [5]의 값부터 data4의 [3]의 위치부터  6개를 복사
		System.out.println("System.arraycopy> "+Arrays.toString(data4));
	}

	public static void main(String[] args) {
		new ArraysTest();

	}

}
