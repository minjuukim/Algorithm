package day1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_11049_행렬곱셈순서 {
	static int matrix[][], dp[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][N];
		System.out.println(calc(0, N-1));;
	}
	
	public static int calc(int start, int end) {
		if(start == end) {
			return 0;
		}
		
		if(dp[start][end] != 0) {
			return dp[start][end];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=start; i<end; i++) {
			min = Math.min(min, calc(start, i) + calc(i+1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1]);
		}
		dp[start][end] = min;
		
		return min;
	}
}
