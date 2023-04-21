import java.io.*;
import java.util.*;

class Main {
	static int N; 
	static int[][] map, tmp;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(check()) {
			tmp = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] != 0) {
						bfs(i, j);
						
					}
				}
			}
			
			map = tmp;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void bfs(int r, int c) {
		int cnt = 0;
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			
			if(map[nr][nc]==0) {
				cnt++;
			}
		}
		
		tmp[r][c] = map[r][c]-cnt >= 0 ? map[r][c]-cnt : 0;
	}
}
