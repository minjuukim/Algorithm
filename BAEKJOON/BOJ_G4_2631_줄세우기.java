package day1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_G4_2631_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(dp, 1);    // 각 숫자의 초기 최장거리는 1
		
		int max = 0;
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				// 자기보다 먼저 나온 수 중에서 작은 수가 있다면, 그 수의 dp값에 +1 해주면서 가장 긴 증가하는 수열 구하기
				if(arr[j] < arr[i]) {	
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				max = Math.max(max, dp[i]);
			}
		}
		
		System.out.println(N-max);	// 자리 바꿔야할 숫자 개수 => N - (가장 긴 오름차순 길이)
	}

}
