package day0214;

import java.util.Scanner;

public class BOJ_B2_3040_백설공주와일곱난쟁이 {
	
	static int[] input;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = new int[9];		// 입력 수 저장배열
		numbers = new int[7];	// 뽑은 수 저장배열
		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();	// 9개의 수 입력받음
		}
		
		comb(0,0);

	}

	// 조합 - 9개중 7개를 뽑는 조합
	private static void comb(int cnt, int start) {
		
		// 기저조건
		if(cnt==7) {
			int sum=0;
			for(int i : numbers) {
				sum += i;	// 뽑은 수들의 원소의 합
			}
			
			if(sum==100) {	// 뽑은 수들의 합이 100일 경우 출력
				for(int i : numbers) {
					System.out.println(i);
				}
			}
			return;
		}
		
		// 유도파트
		for(int i=start; i<9; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1,	i+1);
		}
	}

}
