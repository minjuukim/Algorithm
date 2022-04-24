package day0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21278_호석이두마리치킨_Floyd {
	
	static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 건물 개수
		int M = Integer.parseInt(st.nextToken());	// 도로 개수
		
		int[][] map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {	// 간선 정보 입력받기
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a]= 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j && map[i][j]==0) {	// 자기자신으로의 인접정보가 아니고 인접해있지 않다면 INF로 채우기
					map[i][j] = INF;
				}
			}
		}
		
		// 플로이드 와샬 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i==k) continue;
				for (int j = 1; j <= N; j++) {
					if(i==j || k==j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int c1 = Integer.MAX_VALUE;		// 치킨집1
		int c2 = Integer.MAX_VALUE;		// 치킨집2
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {	// 두 지점을 치킨집으로 가정
			for (int j = i+1; j <= N; j++) {
				
				int sum = 0;
				for (int k = 1; k <= N; k++) {	// 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단시간의 총합 구하기
					sum += Math.min(map[i][k], map[j][k]);	// 두 치킨집 중 더 가까운 치킨집까지의 거리를 구함
				}
				if(min>sum) {
					c1 = i;
					c2 = j;
					min = sum;
				}
			}
		}
		
		System.out.println(c1+" "+c2+" "+min*2);
	}
	
}
