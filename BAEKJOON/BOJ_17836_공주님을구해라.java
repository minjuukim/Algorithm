package day0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836_공주님을구해라 {
	
	static int N, M, T;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());	// 제한 시간
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 0:빈공간, 1:벽, 2:그람
			}
		}
		
		int ans = bfs();
		System.out.println(ans==-1? "Fail" : ans);
	}
	
	public static int bfs() {
		Queue<Pos> que = new LinkedList<Pos>();
		que.offer(new Pos(0, 0, 0, false));
		
		boolean[][][] visited = new boolean[N][M][2];	// 0: 그람없는경우, 1: 그람있는경우
		visited[0][0][0] = true;
		
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			
			if(cur.t > T) break;	// 제한시간 이상 경과된 경우
			if(cur.r==N-1 && cur.c==M-1) {	// 도착지일 경우
				return cur.t;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if(!visited[nr][nc][0] && !cur.get) {	// 그람이 없는 경우 => 벽으로 이동 불가
					
					if(map[nr][nc] == 0) {		// 빈공간인 경우
						que.offer(new Pos(nr, nc, cur.t+1, false));
						visited[nr][nc][0] = true;
						
					} else if(map[nr][nc] == 2) {	// 그람인 경우
						que.offer(new Pos(nr, nc, cur.t+1, true));
						visited[nr][nc][0] = true;
					}
					
				} else if(cur.get) {	// 그람을 획득한 경우
					que.offer(new Pos(nr, nc, cur.t+1, true));
					visited[nr][nc][1] = true;
				}
			}
		}
		return -1;
	}
	
	public static class Pos {
		int r;
		int c;
		int t;
		boolean get;
		
		public Pos(int r, int c, int t, boolean get) {
			super();
			this.r = r;
			this.c = c; 
			this.t = t;
			this.get = get;
		}
	}

}
