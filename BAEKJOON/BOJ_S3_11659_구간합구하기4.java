package day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());	// 수의 개수
		int M = Integer.parseInt(st.nextToken());	// 합을 구해야하는 횟수
		
		int[] S = new int[N+1];	// 합 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 구간 합 구하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());	// 구간 시작
			int end = Integer.parseInt(st.nextToken());		// 구간 끝
			sb.append(S[end] - S[start-1]+"\n");	// 구간합
		}
		System.out.println(sb);
	}

}
