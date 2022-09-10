package day0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1253_좋다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 수의 개수
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		
		for (int k = 0; k < N; k++) {
			int i = 0;
			int j = N-1;
			long key = arr[k];
			
			// 투포인터 알고리즘
			while(i<j) {
				
				int sum = arr[i] + arr[j];
				
				if(sum == key) {	// key가 서로 다른 두 수의 합이어야 함을 체크.
					if(i!=k && j!=k) {
						count++;
						break;
					} else if(i == k) {
						i++;
					} else if(j == k){
						j--;
					}
				}
				else if(sum < key) {
					i++;
				} else {
					j--;
				}
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
