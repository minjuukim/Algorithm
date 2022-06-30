package day0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_20300_서강근육맨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 운동기구 개수
		st = new StringTokenizer(br.readLine());
		long[] muscleLoss = new long[N];	// 각 운동기구의 근손실
		for (int i = 0; i < N; i++) {
			muscleLoss[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(muscleLoss);	// 오름차순으로 정렬
		
		long ans = 0;
		
		// 근손실이 최소가 되도록 하기
		for (int i = 0; i < N/2; i++) {
			
			long sum = 0;
			
			if(N%2==0) {	// 짝수일 경우 => 양 끝 한개씩 더하기
				sum = muscleLoss[i] + muscleLoss[N-i-1];
			} 
			else {	// 홀수일 경우 => 맨끝 한개를 제외한 나머지 양끝 한개씩 더하기
				sum = muscleLoss[i] + muscleLoss[N-i-2];
			}
			
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
}
