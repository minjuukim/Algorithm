package day0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_1449_수리공항승 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 물 새는 곳의 개수
		int L = Integer.parseInt(st.nextToken());	// 테이프의 길이
		
		st = new StringTokenizer(br.readLine());
		int[] list = new int[N];	// 물이 새는 곳의 위치를 저장한 리스트
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());	// 물이 새는 곳의 위치
		}
		
		Arrays.sort(list);		// 오름차순 정렬
		
		double left = list[0] - 0.5;	// 첫번째 위치의 left 값
		int ans = 1;
		for (int i = 0; i < N; i++) {
			if(left + L < list[i] + 0.5) {	// 테이프 길이의 위치보다 물이 새는 곳의 위치가 더 오른쪽에 있으면
				ans++;						// 카운트 증가
				left = list[i] - 0.5;		// left 값 갱신
			}
		}
		System.out.println(ans);
	}
}
