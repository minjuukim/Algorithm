package day0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_1940_주몽 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 재료의 개수
		int M = Integer.parseInt(br.readLine());	// 갑옷을 만드는데 필요한 수
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	// 크기 비교 -> 오름차순 정렬
		
		int count = 0;
		// 양쪽 끝의 위치를 투포인터로 지정
		int i = 0;
		int j = N-1;
		
		while(i < j) {
			long sum = arr[i] + arr[j];
			
			if(sum < M) {
				i++;
			} else if(sum > M) {
				j--;
			} else {
				i++;
				j--;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
