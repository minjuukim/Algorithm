package day0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_14627_파닭파닭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());	// 파의 개수
		int C = Integer.parseInt(st.nextToken());	// 파닭의 개수
		
		int[] L = new int[S];
		
		long sum = 0;
		for (int i = 0; i < S; i++) {
			L[i] = Integer.parseInt(br.readLine());	// 파의 길이
			sum += L[i];	// 모든 파의 길이를 합함.
		}
		
		int left = 1;
		int right = 1_000_000_000;
		
		// 최적의 파의 길이 구하기 => 이분탐색
		while(left <= right) {
			int mid = (left+right)/2;
			
			int cnt = 0;	// 최적의 파의 길이로 나눈 파의 개수
			
			for (int i = 0; i < S; i++) {
				cnt += L[i]/mid;
			}
			
			if(cnt >= C) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		// 라면에 넣을 파의 길이 = 파의 전체 길이 - 최적 파의 길이 * 파닭의 개수
		System.out.println(sum - right * (long) C);
	}

}
