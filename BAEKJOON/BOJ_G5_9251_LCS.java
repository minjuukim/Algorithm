package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LCS(최장 공통 부분 수열) Top-Down 방식
public class BOJ_G5_9251_LCS {
	static char[] str1, str2;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        
        dp = new Integer[str1.length][str2.length];
        
        System.out.println(LCS(str1.length-1, str2.length-1));
	}
	
	public static int LCS(int a, int b) {
		if(a < 0 || b < 0) {
			return 0;
		}
		
		if(dp[a][b] == null) {	// 탐색하지 않은 경우
			dp[a][b] = 0;
			
			if(str1[a] == str2[b]) {
				dp[a][b] = LCS(a-1, b-1) + 1;
			} else {
				dp[a][b] = Math.max(LCS(a-1, b), LCS(a, b-1));
			}
		}
		
		return dp[a][b];
	}
}
