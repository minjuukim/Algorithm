package day0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 삼성SW 역량 테스트 기출문제
public class BOJ_G5_14503_로봇청소기 {
	
	static int[][] map;
	static boolean[][] visited;
	static int N, M, ans=1;
	
	static int[] dr = {-1,0,1,0};	// 북 동 남 서
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());	// 로봇청소기 행위치
		int c = Integer.parseInt(st.nextToken());	// 로봇청소기 열위치
		int d = Integer.parseInt(st.nextToken());	// 로봇청소기 방향 (0:북, 1:동, 2:남, 3:서)
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 0:빈칸, 1:벽
			}
		}
		dfs(r, c, d);
		System.out.println(ans);
	}
	
	public static void dfs(int r, int c, int d) {
		visited[r][c] = true;	// 현재 위치 청소
		
		for(int i=0; i<4; i++) {
			d = (d+3)%4;		// 왼쪽 방향
			int nr = r + dr[d];	// 왼쪽 위치
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
			
			if(map[nr][nc]==0 && !visited[nr][nc]) {	// 청소하지 않은 빈 공간인 경우
				ans++;	// 청소한 칸의수 증가
				dfs(nr, nc, d);	// 한칸 전진
				return;
			} 
		}
		
		int back = (d+2)%4;	// 뒤쪽 방향
		int br = r + dr[back];
		int bc = c + dc[back];
		
		if(br<0 || br>=N || bc<0 || bc>=M || map[br][bc]==1) return;	// 뒤쪽이 벽이라면 작동을 멈춤.
		else {
			dfs(br, bc, d);		// 후진
		}
	}
}
