package day0602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14699_관악산등산_DP {
	
	static int N;
	static int[][] map;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());	//쉼터의 수
		int M = Integer.parseInt(st.nextToken());	//쉼터를 연결하는 길의 수
		
		map = new int[N+1][N+1];
		
		int[] h = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			h[i] = Integer.parseInt(st.nextToken());	// 각 쉼터의 높이
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(h[a] < h[b]) {
				map[a][b] = 1;
			} else {
				map[b][a] = 1;
			}
		}
		
		dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if(dp[i]==0) {
				dfs(i);
			}
			sb.append(dp[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int to) {
		for (int i = 1; i <= N; i++) {
			if(map[to][i]==1) {
				if(dp[i]==0) {
					dfs(i);
				}
				
				if(dp[to]<dp[i]+1) {
					dp[to] = dp[i]+1;
				}
				
			}
		}
		
		if(dp[to]==0) dp[to] = 1;	// 자신보다 높은 쉼터와 연결된 길이 없는 경우
	}

}
