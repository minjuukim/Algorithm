package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_14888_연산자끼워넣기 {
	
	static int N;
	static int numbers[], operators[], list[];
	static boolean isSelected[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 수의 개수
		numbers = new int[N];		// 
		operators = new int[N-1];
		int idx = 0;
		isSelected = new boolean[N-1];
		list = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());	// N개의 수 입력받아 배열에 저장
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4 ; i++) {
			int cnt = Integer.parseInt(st.nextToken());	
			for(int j=0; j<cnt; j++) {	// +, -, x, / 을 개수만큼 배열에 저장
				operators[idx++] = i;	// +(0), -(1), *(2), /(3) 숫자로 표현하여 저장
			}
		}
		
		cal(0);
		System.out.println(max);
		System.out.println(min);

	}
	
	// 연산자를 순서대로 나열하는 순열로 경우의 수 구하여 식을 계산
	public static void cal(int cnt) {
		
		if(cnt==N-1) {
			int sum = numbers[0];
			for(int i=0; i<N-1; i++) {
				switch(list[i]) {
				case 0: sum += numbers[i+1]; break;
				case 1: sum -= numbers[i+1]; break;
				case 2: sum *= numbers[i+1]; break;
				case 3: sum /= numbers[i+1]; break;
				}
			}
			
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < N-1; i++) {
			if(isSelected[i]) continue;
			
			list[cnt] = operators[i];
			isSelected[i] = true;
			
			cal(cnt+1);
			isSelected[i] = false;
		}
	}

}
