package day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_1546_평균 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 과목의 개수
		int[] scores = new int[N];
		
		long max = 0;
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, scores[i]);
			sum += scores[i];
		}
		
		System.out.println(sum*100.0/max/N);
		
	}
}
