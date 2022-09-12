package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17070_파이프옮기기1 {
	
	static int N, count;
	static int[][] map;
	// →, ↘, ↓
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 집의 크기
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(count);
	}
	
	public static void bfs() {
		Queue<Pipe> que = new LinkedList<>();
		que.offer(new Pipe(0, 1, 0));
		
		while(!que.isEmpty()) {
			Pipe cur = que.poll();
			int dir = cur.dir;
			
			for (int d = 0; d < 3; d++) {
				if(dir==0 && d==2) continue;
				else if(dir==2 && d==0) continue;
				
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr>=N || nc>=N || nr<0 || nc<0 || map[nr][nc]==1) continue;
				if(d==1) {
					if(map[nr][cur.c]==1 || map[cur.r][nc]==1) continue;
				}
				
				if(nr==N-1 && nc==N-1) count++;
				que.add(new Pipe(nr, nc, d));
			}
		}
	}
}

class Pipe {
	int r;
	int c;
	int dir;
	
	public Pipe(int r, int c, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
} 
