package day1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G2_1377_버블소트 {
	
	static int N, arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		bubbleSort();
	}
	
	public static void bubbleSort() {
		
		boolean changed = false;
		
		for(int i=1; i<N; i++) {
			changed = false;
			for(int j=1; j<=N-i; j++) {
				if(arr[j] > arr[j+1]) {		// 앞의 수가 뒤의 수보다 클 경우
					changed = true;
					
					// 배열의 앞 뒤 수를 바꿔줌. 
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			if(changed == false) {	// 이미 모든 수가 정렬된 상태인 경우
				System.out.println(i);
				return;
			}
		}
	}
}
