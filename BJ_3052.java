package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_3052 {

	/*******���1: BufferedReader + List **********/	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ������ ���� �� ����Ʈ ����
		List<Integer> list = new ArrayList<>();
		
		//����Ʈ�� �������� �ֱ�
		for(int i=0; i<10; i++) {
			int reminder = Integer.parseInt(br.readLine()) % 42;
			if ( !list.contains(reminder) )
				list.add(reminder);	// List�� ���ο� �� �߰�
		}
		System.out.println(list.size());
	}
	
/*******���2: Scanner + Array *********	
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
