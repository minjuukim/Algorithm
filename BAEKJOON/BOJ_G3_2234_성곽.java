package day0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_2234_성곽 {
	static int R, C;
	static String map[][];
	static boolean[][] visited;
	static int[] dr = {1, 0, -1, 0};	// 좌상우하
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());	
		R = Integer.parseInt(st.nextToken());	
		map = new String[R][C];
		int num = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				num = Integer.parseInt(st.nextToken());
				map[i][j] = toBinary(num);
			}
		}
		
		int rooms = 0;	// 섬에 있는 방의 개수
		int maxRoom = 0;
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j]) {
					rooms++;
					maxRoom = Math.max(maxRoom, bfs(i, j));
				}
			}
		}
		
		System.out.println(rooms);
		System.out.println(maxRoom);
	}
	
	// 십진수 -> 이진수 로 변환
	public static String toBinary(int decimal) {
		String binary = "";
		for (int i = 3; i >= 0; i--) {
			binary = decimal%2 + binary;
			decimal /= 2;
		}
		return binary;
	}
	
	public static int bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[]{r, c});	// 초기에 (0,0)추가
		visited[r][c] = true;
		int cnt = 1;	// 방의 칸의 개수
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			String num = map[cur[0]][cur[1]];
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc] || num.charAt(i)=='1') continue;
				
				visited[nr][nc] = true;
				cnt++;
				que.offer(new int[] {nr, nc});
			}
		}
		return cnt;
	}

}
