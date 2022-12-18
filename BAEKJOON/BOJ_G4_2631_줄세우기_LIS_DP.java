package day0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BOJ_2631_줄세우기_LIS_DP {
// LIS(가장 긴 증가하는 수열)
// 방법: DP로 구현
// 시간복잡도: O(N²)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 전체 숫자 개수
		
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());	
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);		// 처음 각 최장거리는 1로 저장
		
		int max = 0;	// 가장 긴 증가하는 수열의 길이
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(numbers[j] < numbers[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				max = Math.max(max, dp[i]);
			}
		}
		
		System.out.println(N - max);	// 옮겨야 하는 수 = 전체 - 가장 긴 증가하는 수열길이
	}
}
