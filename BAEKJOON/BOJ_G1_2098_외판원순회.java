package day1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G1_2098_외판원순회 {

	static final int INF = 16000001;	// 불가능한 경우를 체크해주기 위해 선언
	static int END, N;
	static int[][] cost, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		END = (1<<N) - 1;	// 모든 비트가 1인 경우
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][1<<N];
		
		System.out.println(TSP(0, 1));
	}
	
	public static int TSP(int cur, int visited) {
		
		if(visited == END) {	// 모든 도시를 다 방문한 경우
			if(cost[cur][0] != 0) {		// 순회가 가능한 경우
				return cost[cur][0];
			}
			return INF;
		}
		
		// 이미 방문한 도시인 경우
		if(dp[cur][visited] != 0) {
			return dp[cur][visited];
		}
		
		dp[cur][visited] = INF;
		
		for(int i=1; i<N; i++) {	// 다음 방문할 도시 탐색
			int bit = 1<<i;		// 다음에 방문할 도시의 비트
			
			if( (visited&bit) > 0 || cost[cur][i]==0 ) continue;		// 방문한 적이 있거나 길이 없는 경우 패스
			
			dp[cur][visited] = Math.min(dp[cur][visited], TSP(i, visited | bit) + cost[cur][i]);
		}
		
		return dp[cur][visited];
	}

}
