package day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	
	static int N, M, cheese, time, cnt;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheese++;	// 치즈의 개수 카운트
				}
			}
		}
		
		while(cheese != 0) {	// 치즈 개수가 0이 될 떄까지 반복
			time++;
			cnt = cheese;	// 남아있는 치즈의 개수
			bfs();
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	// 치즈 녹이기
	public static void bfs() {	// 주의) 치즈 안에 공기가 있을 때는 치즈가 녹지 않는다.
		//Queue<int[]> que = new LinkedList<>();
		//que.offer(new int[] {0, 0});	// (0,0)부터 시작
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(0, 0));
		
		visited = new boolean[N][M];
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			//int[] cur = que.poll();
			Pos cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				//int nx = cur[0] + dx[d];
				//int ny = cur[1] + dy[d];
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;
				
				if(map[nx][ny] == 1) {	// 치즈를 만나면 치즈 개수 줄이고 0으로 변경
										// 내부 모서리를 탐색하지 않도록 치즈를 만나면 더이상 큐에 삽입하지 않는다.
					cheese--;
					map[nx][ny] = 0;
					
				} else if (map[nx][ny] == 0) {	// 공기를 만날 경우
					//que.offer(new int[] {nx, ny});
					que.offer(new Pos(nx, ny));
				}
				visited[nx][ny] = true;
			}
		}
	}
	
	public static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
