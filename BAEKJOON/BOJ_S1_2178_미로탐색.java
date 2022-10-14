package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2178_¹Ì·ÎÅ½»ö {
	
	static int N, M;
	static int[][] map;
	static int[][] sum;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sum = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(sum[N-1][M-1]);
		
    }
	
	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {0, 0, 1});
		sum[0][0] = map[0][0];
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int curx = cur[0];
			int cury = cur[1];
			int cnt = cur[2];
			
			for (int d = 0; d < 4; d++) {
				int nx = curx + dx[d];
				int ny = cury + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny]==0) continue;
				
				if(sum[curx][cury]+1 < sum[nx][ny] || sum[nx][ny]==0) {
					sum[nx][ny] = sum[curx][cury]+1;
					que.offer(new int[] {nx, ny, cnt+1});
				}
			}
		}
	}
	
}
