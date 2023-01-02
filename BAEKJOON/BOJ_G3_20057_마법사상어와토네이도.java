package day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_20057_마법사상어와토네이도 {
	
	static int N, map[][];
	static int ans;
	static boolean visited[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {-1, 0, 1, 0};
	static int[][][] m = {{{-1,0}, {1,0}, {-2,-1}, {2,-1}, {-1,-1}, {1,-1}, {-1,-2}, {1,-2}, {0,-3}, {0,-2}},
						  {{0,-1}, {0,1}, {1,-2}, {1,2}, {1,-1}, {1,1}, {2,-1}, {2,1}, {3,0}, {2,0}},
						  {{-1,0}, {1,0}, {-2,1}, {2,1}, {-1,1}, {1,1}, {-1,2}, {1,2}, {0,3}, {0,2}},
						  {{0,-1}, {0,1}, {-1,-2}, {-1,2}, {-1,-1}, {-1,1}, {-2,-1}, {-2,1}, {-3,0}, {-2,0}}};
	static int p[] = {1, 1, 2, 2, 7, 7, 10, 10, 5};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		visited[N/2][N/2] = true;
		move(N/2, N/2, 0);
		System.out.println(ans);
	}
	
	public static void move(int r, int c, int d) {
		if(r==0 && c==0) {
			return;
		}
		
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]) {
			d = (d+3)%4;
			nr = r + dr[d];
			nc = c + dc[d];
		}	
		
		if(nr>=0 && nr<N && nc>=0 && nc<N) {
			int temp = map[nr][nc];
			int sum = 0;
			
			if(temp!=0) {
				// 비율별 모래 이동
				for(int i=0; i<10; i++) {
					int mr = r + m[d][i][0];
					int mc = c + m[d][i][1];
					
					// 격자 밖으로 이동한 경우 
					if(mr<0 || mr>=N || mc<0 || mc>=N) {
						if(i==9) {
							ans += (temp-sum);
						} else {
							sum += (temp*(p[i]*0.01));
							ans += (temp*(p[i]*0.01));
						}
						continue;
					}
					
					if(i==9) {	// 알파칸 이동
						map[mr][mc] += (temp - sum);
					} else {
						sum += temp*(p[i]*0.01);
						map[mr][mc] += temp*(p[i]*0.01);
					}
				}
				map[nr][nc] = 0;
			}
			visited[nr][nc] = true;
			move(nr, nc, (d+1)%4);
		}
	}
}
