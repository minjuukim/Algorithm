package day0825;

import java.util.Scanner;

public class BOJ_S5_2018_수들의합5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	
		
		int start_idx = 1;
		int end_idx = 1;
		int sum = 1;
		int count = 1;	// 숫자 N만 뽑는 경우의 수를 미리 넣고 초기화
		
		while(end_idx != N) {
			if(sum == N) {
				count++;
				end_idx++;
				sum += end_idx;
			} else if(sum > N) {
				sum -= start_idx;
				start_idx++;
			} else {
				end_idx++;
				sum += end_idx;
			}
		}
		System.out.println(count);
	}

}
