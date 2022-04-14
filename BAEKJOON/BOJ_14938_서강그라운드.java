package day0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
5 5 4
5 7 8 2 3
1 4 5
5 2 4
3 2 3
1 2 3
==> 23
 */

// 문제 : 낙하지역중심으로 수색범위 이내의 모든 지역에서 얻을 수 있는 최대 아이템 개수 구하기
// 구현 : 플로이드-와샬(Floyd-Warshall) 알고리즘 이용.
public class BOJ_14938_서강그라운드 {
	
	static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 지역의 개수
		int M = Integer.parseInt(st.nextToken());	// 수색범위
		int R = Integer.parseInt(st.nextToken());	// 길의 개수
		
		int[] item = new int[N+1];	// 각 구역의 아이템 수
		int[][] dist = new int[N+1][N+1];	// 두 지역간 길의 길이를 저장
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			dist[a][b] = l;
			dist[b][a] = l;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j && dist[i][j]==0) {
					dist[i][j] = INF;	//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
				}
			}
		}
		
		// 경유지-->출발지-->도착지
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i==k) continue;
				for (int j = 1; j <= N; j++) {
					if(i==k || k==j) continue;
					if(dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		// 시작점마다 수색범위에서 가능한 아이템 수를 카운트
		int count = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			count = 0;
			for (int j = 1; j <= N; j++) {
				if(dist[i][j] <= M) {	// 수색 범위 이내일 경우 아이템 개수를 합함
					count += item[j];
				}
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}

}
