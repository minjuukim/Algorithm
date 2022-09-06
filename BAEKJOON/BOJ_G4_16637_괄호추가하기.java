package day0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_16637_괄호추가하기 {
	
	static int N;
	static long max=Integer.MIN_VALUE;
	static char[] expression;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 수식의 길이
		expression = br.readLine().toCharArray();	// 수식
		
		dfs(2, expression[0]-'0');
		System.out.println(max);
	}
	
	public static void dfs(int cur, long sum) {
		// 종료 조건
		if(cur>=N) {
			max = Math.max(max, sum);
			return;
		}
		
		// 괄호를 사용하지 않을 경우 => 지금까지의 합과 cur을 계산한 결과를 다음 숫자에 넘김.
		dfs(cur+2, cal(sum, expression[cur-1], expression[cur] - '0'));
		
		// cur부터 괄호를 사용할 경우 
		if(cur+2 < N) {
			long subSum = cal(expression[cur]-'0', expression[cur+1], expression[cur+2]-'0');	// 괄호안의 값 계산
			dfs(cur+4, cal(sum, expression[cur-1], subSum));	// 지금까지의 결과와 괄호안의 값을 계산하기
		}
	}
	
	public static long cal(long sum, char op, long cur) {
		if(op == '+') return sum + cur;
		else if(op == '-') return sum - cur;
		else return sum * cur;
	}

}
