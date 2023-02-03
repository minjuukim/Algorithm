package day0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2240_자두나무 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());	// 시간(초)
		int W = Integer.parseInt(st.nextToken());	// 최대 이동횟수
		int[] arr = new int[T+1];
		
		for(int i=1; i<=T; i++) {
			arr[i] = Integer.parseInt(br.readLine());	// 떨어지는 자두의 나무위치 정보
		}
		
		int[][][] dp = new int[3][T+1][W+2];	// DP[현재위치][떨어지는 시간][이동횟수]
		
		for(int i=1; i<=T; i++) {
			for(int j=1; j<=W+1; j++) {		// 초기 이동횟수를 0이 아닌 1로 잡음
				if(arr[i]==1) {		// 자두가 나무1에 떨어지는 경우
					dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]) + 1;		// 자두가 1에 위치했을 때
					dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]);			// 자두가 2에 위치했을 때
				} else {		// 자두가 나무2에 떨어지는 경우
					if (i==1 && j==1) continue;
					dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);			// 자두가 1에 위치했을 때
					dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]) + 1;	// 자두가 2에 위치했을 때
				}
			}
		}
		
		int ans = 0;	// 자두가 받을 수 있는 자두의 최대 개수
		for(int i=1; i<=W+1; i++) {
			ans = Math.max(ans, Math.max(dp[1][T][i], dp[2][T][i]));
		}
		
		System.out.println(ans);
	}
}
