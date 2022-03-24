package day0324;

import java.util.Scanner;

public class BOJ_1188_음식평론가 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 소시지의 수
		int M = sc.nextInt();	// 평론가의 수
		
		System.out.println(M-GCD(N, M));

	}
	
	// 최대공약수 이용
	public static int GCD(int a, int b) {
		// return a%b == 0 ? b: GCD(b, a%b);
		while(b!=0) {
			int n = a%b;
			a = b;
			b = n;
		}
		return a;
	}
}
