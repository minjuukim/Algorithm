package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_3052 {

	/*******방법1: BufferedReader + List **********/	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 나머지 값이 들어갈 리스트 생성
		List<Integer> list = new ArrayList<>();
		
		//리스트에 나머지값 넣기
		for(int i=0; i<10; i++) {
			int reminder = Integer.parseInt(br.readLine()) % 42;
			if ( !list.contains(reminder) )
				list.add(reminder);	// List에 새로운 값 추가
		}
		System.out.println(list.size());
	}
	
/*******방법2: Scanner + Array *********	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int reminder;
		int count=0;
		int[] arr = new int[1000];
		
		for(int i=0; i<10; i++) {
			reminder = sc.nextInt() % 42;
			arr[reminder]++;
		}
		for( int i=0; i<arr.length; i++) {
			if( arr[i] != 0) 
				count++;
		}
		System.out.println(count);
	} */
}
