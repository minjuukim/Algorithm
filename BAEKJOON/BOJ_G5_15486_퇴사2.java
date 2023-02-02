package day0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_15486_퇴사2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+2];
		int[][] consult = new int[N+2][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			consult[i][0] = Integer.parseInt(st.nextToken());	// 기간 T
			consult[i][1] = Integer.parseInt(st.nextToken());	// 금액 P
		}
		
		int max = -1;
		for(int i=1; i<=N+1; i++) {		// N번째 일에 일한 돈은 N+1번째 일에 받기 때문에
			if(max < dp[i]) {
				max = dp[i];	// 현재 시점까지의 최대 수익
			}
			
			int next = i + consult[i][0];	// i번째 날에 시작한 상담이 끝마친 다음 날
			
			if(next > N+1) continue;
			
			dp[next] = Math.max(dp[next], max + consult[i][1]);		// 해당일에 얻을 수 있는 최대금액을 저장
		}
		
		System.out.println(dp[N+1]);
	}
	
	

}
