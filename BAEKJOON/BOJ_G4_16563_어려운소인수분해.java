package day0209;

import java.io.*;
import java.util.*;

// 알고리즘 : "에라토스테네스의 체 "(소수/소인수분해를 구하는 효율적인 알고리즘)
// 2~n 정수 x가 소수인지 아닌지 판단 하거나, 
// x가 갖는 가장 작은 소인수 값을 minFactor[x]에 저장

public class BOJ_G4_16563_어려운소인수분해 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 자연수 개수
		
		int[] minFactor = new int[5_000_001];
		
		for(int i=2; i<=5_000_000; i++) {
			minFactor[i] = i;
		}
		
		// 미리 각 자연수의 가장 작은 소인수를 저장해 둔다.
		for(int i = 2; i*i <= 5_000_000; i++) {
			
			if(minFactor[i] == i) {	// i가 소수라면
				for(int j = i*i; j <= 5_000_000; j += i) {	// 그 다음 큰 배수부터 전부 해당 소수로 표시 (각 자연수의 가장 작은 소인수 값이 저장됨)
					if(minFactor[j] == j) {
						minFactor[j] = i;
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			// 소인수 분해
			while(n > 1) {
				sb.append(minFactor[n] + " ");
				n /= minFactor[n];
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
