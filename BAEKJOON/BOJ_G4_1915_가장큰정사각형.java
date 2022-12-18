package day1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1915_가장큰정사각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][M];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				int temp = input.charAt(j) - '0';
				dp[i][j] = temp;
				
				if(i>=1 && j>=1) {
					if(temp == 1) {		// 해당 게임판의 숫자가 1인 경우
						// 해당 게임판의 왼쪽, 위쪽, 왼쪽 대각선의 저장된 숫자 중 가장 작은 값에 1일 더한 값을 dp에 저장
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max*max);
	}
}
