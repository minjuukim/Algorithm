package day0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2482_색상환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 색의 개수
		int k = Integer.parseInt(br.readLine());	// 선택할 색의 개수
		
		int[][] dp = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][1] = i;	// i개 중에서 1개를 선택하는 방법 -> i가지
			dp[i][0] = 1;	// 점화식을 위해 1로 초기화
		}
		
		// 일직선 상에서 N개 중에 k개를 연속하지 않도록 뽑는 경우의 수
		for (int i = 3; i <= N; i++) {
			for (int j = 2; j <= (i+1)/2; j++) {
				// n번째 색을 선택하는 경우 -> n-1번째 색 선택 불가 ==> 총 n-2개 중에서 k-1개 선택 => dp[n-2][k-1]
				// n번째 색을 선택하지 않는 경우  ==> 총 n-1개 중에서 k개 선택 => dp[n-1][k]
				dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % 1000000003;
			}
		}
		
		// 원형 모양의 N개 색 중에서 k개를 선택할 수 있는 경우의 수
		// n번째 색을 선택하는 경우 -> 맨 첫번째 색 선택 불가 ==> 총 n-3개 중에서 k-1개 선택 => dp[n-3][k-1]
		System.out.println((dp[N-3][k-1] + dp[N-1][k]) % 1000000003);
	}

}
