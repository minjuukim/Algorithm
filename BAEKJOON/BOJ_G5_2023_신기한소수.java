package day1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_2023_�ű��ѼҼ� {
	
	static boolean is ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// �ڸ� �� 
		
		dfs(N);
	}
	
	// �Ҽ� �Ǵ�
	public static void dfs(int N) {
		for (int i = 1; i < N; i++) {
			if(N%i == 0) {
				is = false;
				return;
			}
		}
		
		if(N<10) return;
		dfs(N);
	}

}
