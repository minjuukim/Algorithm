package day1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_5904_Moo게임 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		
		int len = 3;	// "moo"의 길이
		int k = 0;		// Index
		
		// N의 범위 구하기 -> 재귀함수에 시작값으로 넣어주기 위해 S(k)의 k를 구함.
		while(len < N) {
			k++;
			len = len*2 + (k+3);	// S(k)의 길이
		}
		
		String[] str = new String[k+1];
		str[0] = "moo";
		
		System.out.println(moo(k, len));
	}
	
	// 이분탐색
	// S(k) = S(k-1) + 	  (k+3) 	+ 	S(k-1)
	//		      왼쪽      / 가운데("mo..o") /   오른쪽
	public static char moo(int k, int len) {
		// 기저조건
		if(k==0) {
			if(N==1) return 'm';
			else return 'o';
		}
		
		int tmp = (len-k-3) / 2;	// S(k-1)의 길이
		
		if(N <= tmp) {		// 왼쪽인 경우
			return moo(k-1, tmp);
		} 
		else if(N > tmp+k+3) {	// 오른쪽인 경우
			N -= tmp+k+3;
			return moo(k-1, tmp);
		} 
		else {		// 가운데인 경우
			if(N==tmp+1) return 'm';
			else return 'o';
		}
	}
}
