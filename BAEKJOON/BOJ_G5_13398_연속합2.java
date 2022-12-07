package day1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_13398_연속합2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i][j] => i: 특정 수, j: 제거한 적이 있는지 (0이면 제거하지 않은 경우, 1이면 제거한 경우)
		int[][] dp = new int[N][2];	
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];
		
		int max = arr[0];
		
		for(int i=1; i<N; i++) {
			// 수를 제거하지 않는 경우
			dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);	
			
			// 특정 수를 제거할 경우 -> (i번째 수를 처음 제거하는 경우, i번째 수 이전에 제거된 경우)
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
				
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(max);
	}
	
}
