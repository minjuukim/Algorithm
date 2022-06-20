package day0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S4_13413_오셀로재배치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] initial = new char[N];
			char[] target = new char[N];
			
			initial = br.readLine().toCharArray();
			target = br.readLine().toCharArray();
			
			int b_cnt = 0, w_cnt = 0;
			for (int i = 0; i < N; i++) {
				if(initial[i] != target[i]) {
					if(initial[i] == 'B') b_cnt++;
					else if(initial[i] == 'W') w_cnt++;
				}
			}
			int ans = 0;
			if(b_cnt <= w_cnt) {
				ans = w_cnt;
			} else ans = b_cnt;
			
			System.out.println(ans);
		}
	}
}
