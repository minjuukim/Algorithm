package day0207;

import java.io.*;
import java.util.*;

public class BOJ_G5_12348_분해합2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		long N = Long.parseLong(input);
		
		int digit = input.length();		// 문자열의 길이 (=입력값의 자릿수)
		long start = N - digit*9;		// 가능한 최솟값인 'N - 9*(N의 자릿수)' 부터 시작
		
		for(long i=start; i<N; i++) {
			long num = i;
			long sum = num;
			
			while(num>0) {
				sum += num % 10;	// 각 자릿수 더하기
				num /= 10;
			}
			
			if(sum == N) {	// 생성자를 찾았을 경우
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);	// 생성자가 없는 경우
	}
}
