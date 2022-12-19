package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_18291_비요뜨의징검다리건너기 {
	
	static final int MOD = (int) (1e9 + 7);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());	// 징검다리 개수
			
			if(N <= 2) {
				sb.append(1).append("\n");
			} else {
				sb.append((int) pow(N-2)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	// 2의 거듭제곱 계산하기
	public static long pow(int n) {
		if(n == 0) {
			return 1;
		}
		
		long temp = pow(n/2);		// 절반 계산
		temp = (temp*temp) % MOD;	// 절반을 다시 두 배로 만들기
		
		if(n%2 == 0) {		// 짝수일 경우
			return temp;
		} else {			// 홀수일 경우
			return (temp*2) % MOD;
		}
	}
}
