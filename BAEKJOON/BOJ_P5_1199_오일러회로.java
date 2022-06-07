package day0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 ## 오일러 회로란? ##
->모든 간선을 지나되 한번 지난 간선은 다시 지나지 않고 출발점으로 돌아오는 회로 (한붓그리기)
->시작점=출발점 
->모든 정점의 차수가 짝수
 */
public class BOJ_P5_1199_오일러회로 {
	
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 정점의 수
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int vertex = 0;		// 한 정점의 차수 개수
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				vertex += map[i][j];
			}
			if(vertex%2 != 0) {	// 한 정점의 차수가 짝수가 아니라면 -1 출력
				System.out.println(-1);
				return;
			}
		}
		
		getEulerCircuit(0);
		System.out.println(map.length);
		System.out.println(sb);
	}
	
	// dfs
	public static void getEulerCircuit(int cur) {	// 오일러 회로 탐색
		for (int next = 0; next < map.length; next++) {		// <N으로 하면 시간초과 발생 => why왜지?????
			while(map[cur][next] > 0) {	// 연결되어 있는 간선이 있으면 양쪽 간선 모두 제거
				map[cur][next]--;
				map[next][cur]--;
				getEulerCircuit(next);
			}
		}
		sb.append((cur+1)+" ");
	}

}
