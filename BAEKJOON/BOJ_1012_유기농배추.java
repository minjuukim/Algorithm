package day0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	
	static int R, C, K;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	//테스트케이스 수
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());	// 가로길이
			R = Integer.parseInt(st.nextToken());	// 세로길이
			K = Integer.parseInt(st.nextToken());	// 배추가 심어져있는 위치의 개수
			
			map = new int[R][C];
			visited = new boolean[R][C];
			ArrayList<int[]> list = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c =  Integer.parseInt(st.nextToken());
				int r =  Integer.parseInt(st.nextToken());
				map[r][c] = 1;
				list.add(new int[]{r, c});
			}
			
			int count = 0;
			for (int i = 0; i < K; i++) {
				int r = list.get(i)[0];
				int c = list.get(i)[1];
				if(map[r][c]==1) {
					dfs(r, c);
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void dfs(int r, int c) {
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			
			if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]==1) {
				map[nr][nc] = 0;
				dfs(nr, nc);
			}
		}
	}
}
