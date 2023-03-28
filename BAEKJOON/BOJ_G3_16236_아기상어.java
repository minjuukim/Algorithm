package day0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_16236_아기상어 {
	
	static int N, cnt, sharkSize;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int startR = 0, startC = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					startR = i;
					startC = j;
				}
			}
		}
		sharkSize = 2;
		System.out.print(play(startR, startC));
	}
	
	public static int play(int r, int c) {
		int nextR = r;
		int nextC = c;
		int time = 0;
		map[r][c] = 0;
		
		while(nextR!=-1 && nextC!=-1) {
			Fish f = bfs(nextR, nextC, time);
			nextR = f.r;
			nextC = f.c;
			time = f.dist;
		}
		return time;
	}
	
	public static Fish bfs(int startR, int startC, int time) {
		
		Queue<Fish> que = new LinkedList<>();
		que.offer(new Fish(startR, startC, time));
		visited = new boolean[N][N];
		visited[startR][startC] = true;
		int minR = N, minC = N;
		int minDist = Integer.MAX_VALUE;
		
		while(!que.isEmpty()) {
			Fish cur = que.poll();
			int r = cur.r;
			int c = cur.c;
//			time = cur.dist;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]>sharkSize || visited[nr][nc]) continue;
				
				if(map[nr][nc]==0 || map[nr][nc]==sharkSize) {	// 이동할 수 있는 칸이 있는 경우
					visited[nr][nc] = true;
					que.offer(new Fish(nr, nc, cur.dist+1));
					
				} else {	// 먹을 수 있는 물고기가 있는 경우
					
					if(minDist > cur.dist+1) {
						minR = nr;
						minC = nc;
						minDist = cur.dist+1;
						
					} else if(minDist == cur.dist+1) {	// 거리가 같은 물고기가 많은 경우
						if(minR > nr) {					// 가장 위에 있는 물고기 먹기
							minR = nr;
							minC = nc;
							minDist = cur.dist+1;
						} else if(minR == nr) {		// 같은 행에 있는 경우
							if(minC > nc) {			// 가장 왼쪽에 있는 물고기 먹기
								minC = nc;
								minR = nr;
								minDist = cur.dist+1;
							}
						}
					}
				} 
			}
		}
		
		if(minR!=N && minC!=N) {
			cnt++;
			map[minR][minC] = 0;
			
			if(cnt == sharkSize) {
				sharkSize++;
				cnt = 0;
			}
			return new Fish(minR, minC, minDist);
		}
		return new Fish(-1, -1, time);
	}

	public static class Fish {
		int r;
		int c;
		int dist;
		
		public Fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
