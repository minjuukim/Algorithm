package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 입력 개수
		
		// 입력을 공백으로 구분
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = -1;	// 입력받을 값이 0보다 크거나 같기 때문
		double sum = 0.0;
		
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(value > max) {
				max = value;
			}
			
			sum += value;
		}
		// 매번 하나의 value 마다 (value/max)*100을 해주면서 sum에 더해주는 것보다 
		// 마지막에 한번에 연산한 값을 출력해주는게 연산을 덜 할 것이다
		System.out.println(((sum/max)*100.0) / N);
		// sum이 double형이라 연산값 또한 double로 형변환 되어 반환됨
	}
}

	/*****방법2: 배열 + Scanner 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		double[] scores = new double[num];
		double sum = 0;
		
		for(int i=0; i<num; i++) {
			scores[i] = sc.nextDouble();
		}
		
		Arrays.sort(scores);	// 배열 정렬
		
		for(int i=0; i<num; i++) {
			sum += (scores[i] / scores[scores.length-1]) * 100;
		}
		System.out.println(sum/num);
	} */

