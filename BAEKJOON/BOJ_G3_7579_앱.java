package day1204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_7579_앱 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memory = new int[N];
		int[] cost = new int[N];
		
		// 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp 배열 초기화
		int[] dp = new int[10001];
		
		// dp[i]: 비용 i만큼 썼을 때 최대로 줄일 수 있는 메모리 크기
		for (int i = 0; i < N; i++) {
			
			for(int j=10000; j>=cost[i]; j--) {
				if(dp[j-cost[i]] != -1) {
					dp[j] = Math.max(dp[j], dp[j-cost[i]] + memory[i]);
				}
			}
			
			// 메모리 업데이트가 안되어 있는 경우 업데이트
			if(dp[cost[i]] < memory[i]) {
				dp[cost[i]] = memory[i];
			}
		}
		
		// 출력
		for(int i=0; i<10000; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}
