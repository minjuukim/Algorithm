package day0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2470_두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 용액의 수
		st = new StringTokenizer(br.readLine());
		long[] num = new long[N];
		for(int i=0; i<N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		
		// 배열 정렬
		Arrays.sort(num);
		
		int left = 0;
		int right = N-1;
		long diff = Long.MAX_VALUE;	// 특성값
		long sol1 = 0, sol2 = 0;	// 정답인 두 용액
		
		while(left<right) {
			long mix = num[left] + num[right];

			if(Math.abs(mix) < diff) {
				sol1 = num[left];
				sol2 = num[right];
				diff = Math.abs(mix);
			}
			
			if(mix < 0) {
				left++;
			} else if(mix > 0) {
				right--;
			} else {
				System.out.println(num[left]+" "+num[right]);
				break;
			}
		}
		
		System.out.println(sol1+" "+sol2);
	}
}
