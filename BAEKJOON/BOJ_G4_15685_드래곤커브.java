package day0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_15685_드래곤커브 {
	
	static boolean[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 드래곤 커브의 개수
		map = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// 시작점 열 좌표
			int y = Integer.parseInt(st.nextToken());	// 시작점 행 좌표
			int d = Integer.parseInt(st.nextToken());	// 시작방향
			int g = Integer.parseInt(st.nextToken());	// 세대 수
			
			dragonCurve(x, y, d, g);
		}
		
		int cnt = 0;	// 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형의 개수 
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

	public static void dragonCurve(int x, int y, int d, int g) {
		
		ArrayList<Integer> dList = new ArrayList<>();	// 드래곤 커브의 방향을 담은 배열
		dList.add(d);		// 시작방향 추가
		map[y][x] = true;
		
		for (int i = 0; i < g; i++) {
			for (int j = dList.size()-1; j >= 0; j--) {
				int newD = (dList.get(j)+1)%4;	// 반시계방향으로 90도 회전한 방향
				dList.add(newD);
			}
		}
		
		for (int dir : dList) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			map[ny][nx] = true;
			x = nx;
			y = ny;
		}
	}
}
