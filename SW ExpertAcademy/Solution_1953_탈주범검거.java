import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	
	static int N, M, L, count;
	static Pos start;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 세로
			M = Integer.parseInt(st.nextToken());	// 가로
			int R = Integer.parseInt(st.nextToken());	// 맨홀뚜껑 세로위치
			int C = Integer.parseInt(st.nextToken());	// 맨홀뚜껑 가로위치
			L = Integer.parseInt(st.nextToken());	// 탈출후 소요된 시간
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			start = new Pos(R, C, map[R][C], 1);
			bfs();
			System.out.println("#"+tc+" "+count);
		}

	}
	
	private static void bfs() {
		
		Queue<Pos> que = new LinkedList<>();
		que.offer(start);	// 맨홀뚜껑 위치를 큐에 저장
		visited[start.x][start.y] = true;
		
		count = 0;
		
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			
			int x = cur.x, y = cur.y, p = cur.p, time = cur.time;
			if(time>L) break;	// 탈출
			
			count++;
			for (int d = 0; d < 4; d++) {
				
				if(d==0 && (p==3 || p==5 || p==6)) continue;	// ㅡ,「, ㄱ 파이프 => 상 방향으로 이동 불가
				if(d==1 && (p==3 || p==4 || p==7)) continue;	// ㅡ, ㄴ, 」파이프 => 하 방향으로 이동 불가
				if(d==2 && (p==2 || p==6 || p==7)) continue;	// ㅣ, ㄱ, 」파이프 => 우 방향으로 이동 불가
				if(d==3 && (p==2 || p==4 || p==5)) continue;	// ㅣ, ㄴ,「  파이프 => 좌 방향으로 이동 불가

				int nx = x + dx[d];
				int ny = y + dy[d];
				int nextP;  // 이동할 위치의 파이프 종류
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]==0) continue;
				
				nextP = map[nx][ny];
				if(mCheck(d, nextP) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					que.offer(new Pos(nx, ny, nextP, time+1));
				}
			}
		}
	}
	
	// 이동할 위치의 파이프 종류를 확인하여 이동 가능한지 체크
	public static boolean mCheck(int d, int p) {
		if(d==0 && (p==1 || p==2 || p==5 || p==6)) return true;
		else if(d==1 && (p==1 || p==2 || p==4 || p==7)) return true;
		else if(d==2 && (p==1 || p==3 || p==6 || p==7)) return true;
		else if(d==3 && (p==1 || p==3 || p==4 || p==5)) return true;
		else return false;
	}

	static class Pos {
		int x;
		int y;
		int p;	// 파이프 종류
		int time;	// 이 파이프에 도달하는데 소요된 시간
		
		public Pos(int x, int y, int p, int time) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.time = time;
		}
	}

}

