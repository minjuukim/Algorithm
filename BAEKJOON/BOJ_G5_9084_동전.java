package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_9084_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());	// 동전의 가지 수
//			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());	// 만들어야 할 금액
			
			int[] dp = new int[M+1];
			dp[0] = 1;
			
			for(int coin : arr) {
				for(int j=coin; j<=M; j++) {
					dp[j] += dp[j - coin];
				}
			}
			sb.append(dp[M]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
