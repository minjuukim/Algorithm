package day1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2110_공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 집의 개수
		int C = Integer.parseInt(st.nextToken());	// 공유기의 개수
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1;	// 가능한 최소 거리
		int right = arr[N-1] - arr[0];	// 가능한 최대 거리
		int ans = 0;
		int distance = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;	// 기준
			int cnt = 1;
			int start = arr[0];
			
			// 간격을 기준으로 공유기 설치
			for(int i=1; i<N; i++) {
				distance = arr[i] - start;
				
				if(mid <= distance) {
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt < C) {	 // 공유기가 더 설치되어야함 => 간격 좁히기
				right = mid - 1;
			} else {		// 공유기의 수를 줄여야함 => 간격 넓히기
				ans = mid;
				left = mid+1;
			}
		}
		System.out.println(ans);
	}

}
