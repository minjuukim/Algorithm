package day1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_2023_신기한소수_sol {
	
	static int N;
	static boolean isPrimenum;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());	// 자리 수 
		
		// 2, 3, 5, 7로 탐색 시작 (맨 왼쪽 자리 수)
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		
		System.out.println(sb);
	}
	
	// 자리수 늘려가며 답 구하기
	public static void dfs(int n, int digits) {		// 수, 자리수

		if(digits == N) {
			if(isPrime(n)) {
				sb.append(n+"\n"); 		
				return;
			}
		}
		
		for (int i = 1; i <= 9; i+=2) {		// 뒤에 붙는 수가 홀수인 경우 (짝수라면 탐색할 필요 없음)
			if(isPrime(n)) {				// 소수일 경우
				dfs(n*10 + i, digits+1);	// 재귀 함수로 자릿수를 늘림
			}
		}
	
	}

	// 소수 구하기
	public static boolean isPrime(int n) {
		for (int i = 2; i <= n/2; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
