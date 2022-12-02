package day1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_10942_팰린드롬_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 수열의 크기
		int[] numbers = new int[N+1];
		int[][] dp = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1;	// 길이가 1인 경우 -> 항상 팰린드롬
		}
		
		// 길이가 2인 경우 -> 2개의 수가 같은 경우 팰린드롬
		for(int i=1; i<N; i++) {
			if(numbers[i] == numbers[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		
		// 길이가 3 이상인 경우 -> 시작점==끝점 && dp[시작점+1][끝-1]==1 인 경우 팰린드롬
		for(int i=2; i<N; i++) {	// 길이
			for(int j=1; j<=N-i; j++) {
				if( numbers[j]==numbers[j+i] && dp[j+1][j+i-1]==1 ) {
					dp[j][j+i] = 1;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());	// 질문의 개수
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(dp[S][E]==1) sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		
		System.out.println(sb);
	}
}
