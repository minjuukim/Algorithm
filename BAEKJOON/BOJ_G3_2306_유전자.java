package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_G3_2306_유전자 {
	static int N, dp[][];
	static String input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		N = input.length();
		
		dp = new int[N][N];
		for(int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		
		System.out.println(calc(0, N-1));
	}
	
	public static int calc(int start, int end) {
	
		if(start >= end) {
			return 0;
		}
		
		if(dp[start][end] != -1) {
			return dp[start][end];
		}
		
		int max = 0;
		char s = input.charAt(start);
		char e = input.charAt(end);
		if (((s=='a' && e=='t') || (s=='g' && e=='c'))) {	// aXt 또는 gXc인 경우
			max = Math.max(max, calc(start+1, end-1)+2);
		}
		
		for(int i=start; i<end; i++) {
			max = Math.max(max, calc(start, i) + calc(i+1, end));
		}
		return dp[start][end] = max;
	}
}
