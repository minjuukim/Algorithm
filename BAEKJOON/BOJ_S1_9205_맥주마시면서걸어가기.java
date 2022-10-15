package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_9205_맥주마시면서걸어가기 {
	
	static int N, position[][], map[][];
	static boolean[][] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine()) + 2;
			position = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				position[i][0] = Integer.parseInt(st.nextToken());	// x좌표
				position[i][1] = Integer.parseInt(st.nextToken());	// y좌표
			}
			
			map = new int[N][N];
			visited = new boolean[N][N];
			// 양방향으로 각 위치 사이의 거리를 저장
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					map[i][j] = Math.abs(position[i][0] - position[j][0]) + Math.abs(position[i][1] - position[j][1]);
					map[j][i] = map[i][j];
				}
			}
			
			bfs();
			
			// 정답 저장
			for (int i = 0; i < N; i++) {
				if(visited[N-1][i]) {
					sb.append("happy\n");
					break;
				}
				if(i==N-1) {
					sb.append("sad\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);	// 집에서 출발
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for (int i = 0; i < N; i++) {
				if(map[cur][i] <= 1000 && !visited[cur][i]) {	// 거리가 되는 모든 방향으로 가보기
					// 양방향 방문 체크
					visited[cur][i] = true;
					visited[i][cur] = true;
					que.offer(i);
				}
			}
		}
	}

}
