package day0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
=> 출력: 3 
*/

// 문제: 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하기.
// 구현: 최장증가부분수열(LIS) 알고리즘 이용.
public class BOJ_2565_전깃줄_LIS {
	static int N, min=Integer.MAX_VALUE;
	static boolean[] selected;
	static Line[] lines;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 전깃줄의 개수
		lines = new Line[N];
		selected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lines);
		// 없어야 하는 전깃줄의 개수가 최소 => 겹치지 않은 전깃줄의 개수가 최대
		
		int[] dp = new int[N];	// dp[x] : x번째 수를 마지막 원소로 가지는 LIS의 길이
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(lines[j].b < lines[i].b && dp[i]<dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N-max);
	}

	static class Line implements Comparable<Line>{
		int a;
		int b;
		
		public Line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Line o) {
			return this.a - o.a;
		}
	}
}
