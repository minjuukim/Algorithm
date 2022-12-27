package day1226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_26598_색종이와공예 {
	
	static int N, M;
	static char board[][];
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i=0; i<N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					if(!bfs(i, j, board[i][j])) {
						System.out.println("BaboBabo");
						return;
					}
				}
			}
		}
		System.out.println("dd");
	}
	
	public static boolean bfs(int r, int c, char alpha) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[]{r, c});
		visited[r][c] = true;
		
		int cnt = 1;
		int maxR = r, maxC = c;
		int minR = r, minC = c;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || board[nr][nc]!=alpha) continue;
				
				maxR = Math.max(maxR, nr);
				maxC = Math.max(maxC, nc);
				minR = Math.min(minR, nr);
				minC = Math.min(minC, nc);
				
				cnt++;
				que.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
		
		for(int i=minR; i<=maxR; i++) {
			for(int j=minC; j<=maxC; j++) {
				if(board[i][j] != alpha) {
					return false;
				}
			}
		}
		return true;
	}
}
