package day1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_11066_파일합치기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스
		while(T-->0) {
			int K = Integer.parseInt(br.readLine());	// 소설 장의 수
			int[] arr = new int[K+1];
			int[] subSum = new int[K+1];
			int[][] dp = new int[K+1][K+1];
			
			for(int i=1; i<=K; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = Integer.parseInt(st.nextToken());	// 파일 크기
				subSum[i] = subSum[i-1] + arr[i];
				Arrays.fill(dp[i], -1);
			}
			
			for(int i=1; i<=K; i++) {
				dp[i][i] = 0;
			}
			
			dp(dp, subSum, 1, K);
		}

	}
	
	public static int dp(int[][] dp, int[] subSum, int start, int end) {
		
		if(dp[start][end] == -1) {
			dp[start][end] = Integer.MAX_VALUE;
			int sum = subSum[end] - subSum[start-1];
			
			for(int i=start; i<end; i++) {
				dp[start][end] = Math.min(dp[start][end], dp(dp, subSum, start, i) + dp(dp, subSum, i+1, end) + sum);
			}
		}
		
		return dp[start][end];
	}

}
