package day0216;

import java.io.*;
import java.util.*;

//LCS(최장 공통 부분 수열) Bottom-Up 방식
public class BOJ_G3_1958_LCS3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();
        
        int[][][] dp = new int[str1.length+1][str2.length+1][str3.length+1];
        
        for(int i=1; i<=str1.length; i++) {
        	for(int j=1; j<=str2.length; j++) {
        		for(int k=1; k<=str3.length; k++) {
        			
        			if(str1[i-1]==str2[j-1] && str2[j-1]==str3[k-1]) {
        				dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
        			} else {
        				dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
        			}
        		}
        	}
        }
        
        System.out.println(dp[str1.length][str2.length][str3.length]);
	}
}
