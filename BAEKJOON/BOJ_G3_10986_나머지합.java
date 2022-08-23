package day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_10986_나머지합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] sum = new long[N];		// 합 배열
		long[] cnt = new long[M];		// 같은 나머지의 인덱스를 카운트하는 배열 
		
		st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());	// 합 배열 저장
		}
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int remainder = (int) (sum[i] % M);	// 합 배열을 M으로 나눈 나머지 값
			if(remainder == 0) {	// 0~i까지의 구간 합 자체가 0일 때 정답에 1더하기
				ans++;	
			}
			cnt[remainder]++;		// 나머지가 같은 인덱스의 개수 카운팅
		}
		
		for (int i = 0; i < M; i++) {
			if(cnt[i] > 1) {	// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				ans += cnt[i]*(cnt[i]-1)/2;
			}
		}
		
		System.out.println(ans);
	}
}
