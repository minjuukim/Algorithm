package day0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_21610_마법사상어와비바라기 {
	static int N, map[][];
	static int[][] check;
	static Queue<Basket> list;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new LinkedList<>();
		list.add(new Basket(N, 1));
		list.add(new Basket(N, 2));
		list.add(new Basket(N-1, 1));
		list.add(new Basket(N-1, 2));
		
		while(M-- > 0) {
			System.out.println("M: "+M);
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			check = new int[N+1][N+1];
			
			for(Basket cloud : list) {
				check[cloud.r][cloud.c] = 1;
			}
			move(d-1, s);	// 구름 이동
			magic();		// 대각선 체크
			cloud();		// 구름 생성
		}
		
		int total = 0;
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(map[r][c]>0) {
					total += map[r][c];
				}
			}
		}
		System.out.println(total);
	}
	
	// 구름 이동
	public static void move(int d, int s) {
		int n = list.size();
		for(int i=0; i<n; i++) {
			Basket cloud = list.poll();
			int nr = cloud.r + dr[d]*s;
			int nc = cloud.c + dc[d]*s;
			
			if(nr<=0) {
				nr = N-(Math.abs(nr)%N);
			} else if(nr>N) {
				nr = nr%N;
				if(nr==0) nr = N;
			}
			
			if(nc<=0) {
				nc = N-(Math.abs(nc)%N);
			} else if(nc>N) {
				nc = nc%N;
				if(nc==0) nc = N;
			}
			check[nr][nc] = -1;		// 구름 있었던 칸 표시
			map[nr][nc]++;			// 구름있는 칸에 물 1 증가
			list.add(new Basket(nr, nc));
		}
	}
	
	// 대각선 체크 -> 물이 있는 칸 수 만큼 물 증가
	public static void magic() {
		for(Basket cloud : list) {
			int cnt = 0;
			for(int d=1; d<8; d+=2) {
				int nr = cloud.r + dr[d];
				int nc = cloud.c + dc[d];
				
				if(nr<=0 || nr>N || nc<=0 || nc>N) continue;
				
				if(map[nr][nc] > 0) {
					cnt++;
				}
			}
			map[cloud.r][cloud.c] += cnt;
		}
		list.clear();
	}
	
	// 구름 생성 
	public static void cloud() {
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(check[r][c] != -1 && map[r][c] >= 2) {
					list.add(new Basket(r, c));
					map[r][c] -= 2;
				}
			}
		}
	}

	static class Basket {
		int r;
		int c;
		
		public Basket(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
