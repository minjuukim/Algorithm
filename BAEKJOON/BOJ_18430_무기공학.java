package day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18430_무기공학 {
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	
//	기역자 부메랑 좌표 설정
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] boomerag = {{1, 2}, {3, 0}, {0, 2}, {3, 1}};
	
//  방향 설정 4개 좌표로 하는 법 =================
//	static int[] dy = {1, 1, -1, -1};
//	static int[] dx = {1, -1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(getBoomerang(0, 0));

	}
	
	public static int getBoomerang(int r, int c) {
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = c; j < M; j++) {
				
				if(visited[i][j]) continue;
				
				for (int k = 0; k < 4; k++) {
					int x1 = i + dx[boomerag[k][0]];
					int y1 = j + dy[boomerag[k][0]];
					int x2 = i + dx[boomerag[k][1]];
					int y2 = j + dy[boomerag[k][1]];
//					int wing1 = i+dy[k];
//	                int wing2 = j+dx[k];

					
					if(x1<0 || x1>=N || y1<0 || y1>=M || x2<0 || x2>=N || y2<0 || y2>=M || visited[x1][y1] || visited[x2][y2]) continue;
//					if (visited[wing1][j] || visited[i][wing]) 
					
					visited[i][j] = true;
					visited[x1][y1] = true;
					visited[x2][y2] = true;
					
					max = Math.max(max, getBoomerang(i, j)+ board[i][j]*2 + board[x1][y1] + board[x2][y2]);
					
					visited[i][j] = false;
					visited[x1][y1] = false;
					visited[x2][y2] = false;
				}
			}
		}
		
		return max;
	}

}
