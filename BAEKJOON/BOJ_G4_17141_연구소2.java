package day0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_17141_연구소2 {
	
	static int N, M, map[][], min, ans;
	static ArrayList<Pos> vList = new ArrayList<>();	// 바이러스를 놓을 수 있는 칸 배열
	static Pos[] virus;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	// 바이러스 개수
		map = new int[N][N];
		virus = new Pos[M];		// 바이러스가 있는 칸
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 0:빈칸, 1:벽, 2:바이러스 놓을수 있는 칸
				if(map[i][j]==2) {
					vList.add(new Pos(i, j));
				}
			}
		}
		min = Integer.MAX_VALUE;
		ans = -1;
		comb(0, 0);
		System.out.println(ans);
	}
	
	// M개 바이러스 놓기
	// 바이러스를 놓을수 있는 칸 중에서 바이러스 M개를 놓을 자리 선택
	public static void comb(int start, int cnt) {
		
		if(cnt==M) {
			int time = bfs(virus);
			if(time!=-1) {
				min = Math.min(min, time);
				ans = min;
			}
			return;
		}
		
		for (int i = start; i < vList.size(); i++) {
			virus[cnt] = vList.get(i);
			comb(i+1, cnt+1);
		}
	}
	
	// 모든 빈칸에 바이러스 퍼뜨리는 최소시간 구하기
	public static int bfs(Pos[] virus) {
		Queue<Pos> que = new LinkedList<>();
		int[][] times = new int[N][N];	// 바이러스가 퍼진 시간 저장한 배열
		for (int i = 0; i < N; i++) {
			Arrays.fill(times[i], -1); 	// -1로 초기화
		}
		
		for (int i = 0; i < M; i++) {
			que.offer(new Pos(virus[i].r, virus[i].c));
			times[virus[i].r][virus[i].c] = 0;	// 바이러스가 있는 칸:0
		}
		
		int cnt = 0;
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				// 범위를 벗어나거나, 벽이거나, 이미 방문한 곳이라면 패스
				if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==1 || times[nr][nc]!=-1) continue;
				
				times[nr][nc] = times[cur.r][cur.c]+1;
				cnt = times[nr][nc];
				que.offer(new Pos(nr, nc));
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=1 && times[i][j]==-1) {	// 모든 빈칸에 바이러스를 퍼뜨릴 수 없는 경우
					return -1;
				}
			}
		}
		return cnt;
	}
	
	public static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
