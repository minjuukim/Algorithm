package day0307;

import java.util.Map;
import java.util.Scanner;

public class BOJ_S1_14712_넴모넴모 {
	
	static int N, M, ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 행의 개수
		M = sc.nextInt();	// 열의 개수
		map = new int[N+1][M+1];
		
		dfs(0);
		System.out.println(ans);
	}
	
	public static void dfs(int cnt) {
		
		if(cnt == N*M) {	// 모든 칸을 조회한 후
			ans++;
			return;
		}
		
		int r = cnt/M + 1;
		int c = cnt%M + 1;
				
		// 현재 놓을 칸의 주변에 넴모가 3개 배치되어 있을 경우 => 현재 칸에 두지 않는다.
		if(map[r][c-1]==1 && map[r-1][c]==1 && map[r-1][c-1]==1) {
			dfs(cnt+1);
		} else {
			// 넴모 배치하기
			map[r][c] = 1;
			dfs(cnt+1);
			
			// 넴모 배치하지 않기
			map[r][c] = 0;
			dfs(cnt+1);
		}
		
	}

}
