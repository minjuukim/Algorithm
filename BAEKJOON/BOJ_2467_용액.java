package day0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 전체 용액 수
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = N-1;
		int ll = 0;
		int rl = 0;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) <= min) {
				ll = arr[left];
				rl = arr[right];
				min = Math.abs(sum);
			}
			
			if(sum<0) {
				left++;
			} else {
				right--;
			}
		}
		
		System.out.println(ll+" "+rl);
	}

}
