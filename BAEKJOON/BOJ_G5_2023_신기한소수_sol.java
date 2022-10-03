package day1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_2023_�ű��ѼҼ�_sol {
	
	static int N;
	static boolean isPrimenum;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());	// �ڸ� �� 
		
		// 2, 3, 5, 7�� Ž�� ���� (�� ���� �ڸ� ��)
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		
		System.out.println(sb);
	}
	
	// �ڸ��� �÷����� �� ���ϱ�
	public static void dfs(int n, int digits) {		// ��, �ڸ���

		if(digits == N) {
			if(isPrime(n)) {
				sb.append(n+"\n"); 		
				return;
			}
		}
		
		for (int i = 1; i <= 9; i+=2) {		// �ڿ� �ٴ� ���� Ȧ���� ��� (¦����� Ž���� �ʿ� ����)
			if(isPrime(n)) {				// �Ҽ��� ���
				dfs(n*10 + i, digits+1);	// ��� �Լ��� �ڸ����� �ø�
			}
		}
	
	}

	// �Ҽ� ���ϱ�
	public static boolean isPrime(int n) {
		for (int i = 2; i <= n/2; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
