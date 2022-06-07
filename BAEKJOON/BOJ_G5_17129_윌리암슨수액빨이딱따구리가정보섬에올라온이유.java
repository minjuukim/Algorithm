package day0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17129_윌리암슨수액빨이딱따구리가정보섬에올라온이유 {
	
	static int N, M;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int x=0, y=0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x, y);
		if(ans==Integer.MAX_VALUE) {
			sb.append("NIE");
		} else {
			sb.append("TAK").append("\n").append(ans);
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(x, y, 0));
		
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]==1 || visited[nx][ny]) continue;
				
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					que.offer(new Pos(nx, ny, cur.dist+1));
				} else {
					visited[nx][ny] = true;
					ans = Math.min(ans, cur.dist+1);
					return;
				}
			}
		}
	}
	
	public static class Pos {
		int x;
		int y;
		int dist;
		
		public Pos(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}
