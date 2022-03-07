package day0307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_S1_16194_카드구매하기2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 카드의 개수
		int[] price = new int[N+1];		// 가격 저장할 배열
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			price[i] = sc.nextInt();
			dp[i] = Integer.MAX_VALUE;	// 최소값을 초기화.
		}
		
		// 카드 1개부터 N개까지. (Bottom-Up 방식)
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {						// 카드 i개 구매할때
				dp[i] = Math.min(dp[i], price[j] + dp[i-j]);	// 카드 j개 카드팩 구매 + 카드 i-j개 구입할때 최소값
			}
		}
		
		System.out.println(dp[N]);
	}

}
