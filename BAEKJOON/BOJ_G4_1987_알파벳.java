package day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1987_알파벳 {
	
	static int[][] board;
	static int R, C;
	// 하, 우, 상, 좌
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] visit = new boolean[26];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());	//행 입력
		C = Integer.parseInt(st.nextToken());	//열 입력
		board = new int[R][C];

		//입력 초기화
		for(int i=0; i<R; i++){
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = str.charAt(j) - 'A';	// 입력받은 문자형을 int형으로 저장
			}
		}
		
		dfs(0,0,0);		// (0,0) 부터 시작하여, 현재 이동한 위치는 0회
		System.out.println(ans);
		
	}
	
	
	public static void dfs(int x, int y, int count) {
		
		if(visit[board[x][y]]) {	// (x,y)에 저장된 알파벳이 이미 방문한 알파벳이라면 반환.
			ans = Math.max(ans, count);		// 방문한 횟수가 현재 ans보다 많다면 정답 갱신
			return;
		}
		
		visit[board[x][y]] = true;	// 방문한 알파벳을 표시.
		
		// 4방 탐색
		for(int d=0; d<4; d++) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=0 && nx<R && ny>=0 && ny<C) {
				dfs(nx, ny, count+1);
			}
		}
		
		visit[board[x][y]] = false;		// 다른 루트로 dfs 탐색하기 위해 visit 배열을 방문하지 않은 상태로 초기화
	}
}
