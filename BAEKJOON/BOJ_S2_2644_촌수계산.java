package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2644_촌수계산 {
	static int n, p2, count, ans=-1;
	static int[][] map;
	static boolean[] visited ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());	// 전체 사람 수
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());	// 관계의 개수
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		visited[p1] = true;
		dfs(p1);
		
		System.out.println(ans);
	}
	
	public static void dfs(int i) {
		
		if(i==p2) {
			ans = count;
			return;
		}
		
		for (int j = 1; j <= n; j++) {
			if(map[i][j]==1 && !visited[j]) {
				visited[j] = true;
				count++;
				dfs(j);
				count--;
			}
		}
	}
}
