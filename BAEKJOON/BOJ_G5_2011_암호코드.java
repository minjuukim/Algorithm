package day1211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_2011_암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int[] arr = new int[N+1];
		
		for(int i=0; i<N; i++) {
			arr[i+1] = str.charAt(i) - '0';
		}
		
		int[] dp = new int[N+1];
		dp[0] = dp[1] = 1;
		if(arr[1]==0) dp[1] = 0;
		
		for(int i=2; i<=N; i++) {
			
			int num = arr[i-1]*10 + arr[i];
			
			if( 1<=arr[i] && arr[i]<=9 ) {
				dp[i] = dp[i-1];
			}
			
			if( 10<=num && num<=26 ) {
				dp[i] += dp[i-2];
			} 
			
			dp[i] %= 1000000;
		}
		System.out.println(dp[N]);
	}
}
