package day0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_S2_1654_랜선자르기 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());	// 이미 가지고 있는 랜선의 개수
		N = Integer.parseInt(st.nextToken());	// 필요한 랜선의 개수
		
		int[] lines = new int[K];	// 가지고 있는 랜선의 길이 배열
		for (int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());	// 랜선의 길이
		}
		
		// int형 배열 내림차순
		// primitive Type을 Wrapper클래스로 박싱해주어야 reverseOrder 사용가능.
		Integer[] arr = Arrays.stream(lines).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Comparator.reverseOrder());	// 내림차순 정렬
	
		System.out.println(cutLines(arr));
	}
	
	public static long cutLines(Integer[] arr) {
		long left = 1;
		long right = (long)arr[0]+1;
		long key = 0;
		long ans = 0;
		
		while(left<right) {
			long cnt = 0;	// 기준길이로 자른 랜선의 총 개수
			key = (left + right)/2;	// 자를 랜선 기준길이
			if(key==0) key=1;
			
			for (int i = 0; i < K; i++) {
				cnt += arr[i]/key;
			}
			if(cnt<N) {
				right = key;
			} else {
				left = key+1;
			}
			
			if(cnt>=N) {
				ans = Math.max(ans, key);
			}
		}
		
		return ans;
	}
}
