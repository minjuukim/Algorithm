package day0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22858_원상복구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());	//카드 개수
		int K = Integer.parseInt(st.nextToken());	//카드 섞은 횟수
		
		st = new StringTokenizer(br.readLine());
		int[] S = new int[N+1];
		int[] D = new int[N+1];
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] P = new int[N+1];
		for (int k = 0; k < K; k++) {
			for (int i = 1; i <= N; i++) {
				P[D[i]] = S[i];
			}
			
			S = P.clone();	// 배열 복사 (clone(): 객체 생성하고 나서 복제 - 원본과 다른 참조 주소값을 갖는 배열)
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(P[i]+" ");
		}
		
		System.out.println(sb);
	}

}
