package day0612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_10026_적록색약 {
	
	static int N;
	static char[][] board;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		visited = new boolean[N][N][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		int normal_cnt = 0;
		int rgcb_cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j][0]) {		// 적록색약이 아닌 경우 방문체크
					dfs(0, i, j);
					normal_cnt++;
				} 
				if(!visited[i][j][1]) {		// 적록색약인 경우 방문체크
					dfs(1, i, j);
					rgcb_cnt++;
				}
			}
		}
		
		System.out.println(normal_cnt+" "+rgcb_cnt);
	}
	
	public static void dfs(int rgcb, int r, int c) {	// 정상:rgcb=0, 적록색약:rgcb=1
		
		visited[r][c][rgcb] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc][rgcb]) continue;
			
			if(rgcb==1 && (board[r][c]=='R' || board[r][c]=='G')) {
				if(board[nr][nc]=='R' || board[nr][nc]=='G') {
					dfs(1, nr, nc);
				}
			}
			else if(board[r][c] == board[nr][nc]) {
				dfs(rgcb, nr, nc);
			}
		}
	}
}
