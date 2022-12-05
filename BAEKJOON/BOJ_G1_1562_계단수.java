package day1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G1_1562_계단수 {

	static final int MOD = 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][][] dp = new long[N+1][10][1<<10];
		int allVisited = (1<<10)-1;		// 모두 방문한 경우 (1111111111)
		
		// dp[n][k][visited]: n자리 숫자 중 끝나는 수가 k이고, visited에는 여태까지 사용한 수의 정보
		for(int i=1; i<=9; i++) {
			dp[1][i][1<<i] = 1;
		}
		
		for(int n=2; n<=N; n++) {	// 자리 개수
			for(int k=0; k<=9; k++) {	// 끝나는 숫자
				for(int visited=0; visited <= allVisited; visited++ ) {		// 0~9 숫자 중 사용한 수 체크
					int newVisit = visited | (1<<k);
					
					if(k==0) {		// 끝자리 수가 0인 경우 -> 새로운 숫자는 1만 가능
						dp[n][k][newVisit] += dp[n-1][1][visited] % MOD;
					} else if(k==9) {	// 끝자리 수가 9인 경우 -> 새로운 숫자는 8만 가능
						dp[n][k][newVisit] += dp[n-1][8][visited] % MOD;
					} else {
						dp[n][k][newVisit] += (dp[n-1][k-1][visited] + dp[n-1][k+1][visited]) % MOD;
					}
				}
			}
		}
		
		// 출력
		long sum = 0;
		for(int i=0; i<=9; i++) {
			sum = (sum + dp[N][i][allVisited]) % MOD;
		}
		
		System.out.println(sum);
	}
}
