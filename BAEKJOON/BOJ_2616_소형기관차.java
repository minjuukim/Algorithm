package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2616_소형기관차 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 객차의 수
		int arr[] = new int[N+1];
		int sum[] = new int[N+1];	// 인구수에 대한 누적값
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	// {0, 35, 40, 50, 10, 30, 45, 60}
			sum[i] = sum[i-1] + arr[i];		// {0, 35, 75, 125, 135, 165, 210, 270}
		}
		int M = Integer.parseInt(br.readLine());	// 소형 기관차가 끌수 있는 최대 객차 수
		
		int dp[][] = new int[4][N+1];	// 소형기관차 i대로 j개의 객차를 끌었을 때 최대 손님의 수를 저장
//		dp[1][2] : 소형기관차 1대로 2개의 객차를 끌었을 때 최대 손님의 수
//		dp[2][3] : 소형기관차 2대로 3개의 객차를 끌었을 때 최대 손님의 수
		
		for (int i = 1; i < 4; i++) {	// 소형기관차 수
			for (int j = i*M; j <= N; j++) {	// 객차의 수
//			i*M : 소형기관차 i대가 각각 최대 M개의 객차를 끌수 있다면 최소 i*M개의 객차가 필요하기 떄문
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-M] + (sum[j]-sum[j-M]));
//				sum[j]-sum[j-M] : j-max+1칸부터 j칸 까지 손님수의 합 (M개의 칸을 운송했을 때 손님수)
			}
		}
		
		System.out.println(dp[3][N]);
	}

}
