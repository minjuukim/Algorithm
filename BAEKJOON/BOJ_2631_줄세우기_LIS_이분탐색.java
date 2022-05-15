package day0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BOJ_2631_줄세우기_LIS_이분탐색 {
// LIS(가장 긴 증가하는 수열)
// 방법: 이분탐색으로 구현
// 시간복잡도: O(NlogN) => DP로 구현하는 것보다 빠름.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 전체 숫자 개수
		
		int[] numbers = new int[N];
		numbers[0] = Integer.parseInt(br.readLine());	
		
		int end = 1;
		for (int i = 1; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());	
			
			int left = 0;
			int right = end;
			
			while(left<right) {
				int mid = (left+right) / 2;
				
				if(numbers[mid] < temp) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
				
			numbers[right] = temp;
				
			if(right==end) end++;
		}
		
		System.out.println(N - end);	// 옮겨야 하는 수 = 전체 - 가장 긴 증가하는 수열길이
	}
}
