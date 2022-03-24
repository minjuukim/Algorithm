package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1411_비슷한단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 단어의 개수
		
		char[][] arr = new char[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
			
			int[] used = new int[27];	// 알파벳의 개수만큼 배열 선언
			int num = 0;
			
			// 알파벳순서를 숫자로 표현
			// aa, bb, cc => 11    / ab, cd => 12
			// abca, zbxz => 1231  / opqr => 1234
			for (int j = 0; j < arr[i].length; j++) {
				int idx = arr[i][j]-'a';
				if(used[idx]==0) {
					used[idx] = ++num;
				}
				arr[i][j] = (char) used[idx];
			}
 		}
		
		// 문자열 비교 => 각 자리의 값이 같은지 비교
		int count = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				boolean check = true;
				for (int k = 0; k < arr[i].length; k++) {
					if(arr[i][k] != arr[j][k]) {
						check = false;
						break;
					}
				}
				if(check) count++;
			}
		}
		
		System.out.println(count);
	}
}
