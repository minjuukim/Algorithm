package day0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17129_윌리암슨수액빨이딱따구리가정보섬에올라온이유 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int x=0, y=0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(i) - '0';
				if(map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x, y);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {x, y});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int nx = cur[0];
			int ny = cur[1];
			
			for
		}
		
	}

}
